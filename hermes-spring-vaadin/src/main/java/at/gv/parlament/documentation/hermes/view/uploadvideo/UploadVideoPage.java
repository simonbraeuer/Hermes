package at.gv.parlament.documentation.hermes.view.uploadvideo;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import at.gv.parlament.documentation.hermes.controller.NotificationType;
import at.gv.parlament.documentation.hermes.controller.uploadVideo.IUploadVideoPageController;
import at.gv.parlament.documentation.hermes.domain.VideoFile;
import at.gv.parlament.documentation.hermes.service.ServiceException;
import at.gv.parlament.documentation.hermes.service.tempfile.ITempFileService;
import at.gv.parlament.documentation.hermes.view.AbstractContentPage;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Container;
import com.vaadin.data.validator.AbstractValidator;
import com.vaadin.server.FileResource;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.VaadinUIScope;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.TabSheet.SelectedTabChangeListener;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.Upload.SucceededListener;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;
import com.vaadin.ui.Video;

@SpringComponent
@VaadinUIScope
public class UploadVideoPage extends AbstractContentPage implements
		IUploadVideoPage {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;

	@AutoGenerated
	private VerticalSplitPanel splitPanel;

	@AutoGenerated
	private HorizontalLayout previewPanel;

	@AutoGenerated
	private Accordion pageSelection;

	@AutoGenerated
	private HorizontalLayout existingUploadsPanel;

	@AutoGenerated
	private ListSelect uploadList;

	@AutoGenerated
	private VerticalLayout uploadVideoPanel;

	@AutoGenerated
	private Button saveButton;

	@AutoGenerated
	private TextField persistenceFileName;

	@AutoGenerated
	private Upload videoFileUpload;

	private Video video;

	private File currentlyUploadedVideoFile;
	
	private Container existingUploadListContainer;

	/**
	 * 
	 */
	private static final long serialVersionUID = 4485407104851140289L;

	private IUploadVideoPageController controller;
	
	private ITempFileService tempFileService;

	/**
	 * The constructor should first build the main layout, set the composition
	 * root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the visual
	 * editor.
	 */
	public UploadVideoPage() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
		// video
		video = new Video();
		video.setImmediate(false);
		video.setWidth("100.0%");
		video.setHeight("100.0%");
		
		previewPanel.addComponent(video);
		
		VideoUploader receiver = new VideoUploader();
		videoFileUpload.addSucceededListener(receiver);
		videoFileUpload.setReceiver(receiver);
		
		existingUploadListContainer = uploadList.getContainerDataSource();
		existingUploadListContainer.addContainerProperty("name", String.class, "<Keine Datei>");
		existingUploadListContainer.addContainerProperty("absolutePath", String.class, "<Kein Pfad>");
		
		persistenceFileName.addValidator(new PersistenceFileValidator());
		
		saveButton.addClickListener(new ClickListener() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				if(persistenceFileName.isValid()) {
					controller.persistUpload(getUploadVideoFormData());
				}
			}
		});
		
		pageSelection.addSelectedTabChangeListener(new SelectedTabChangeListener() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void selectedTabChange(SelectedTabChangeEvent event) {
				if (event.getTabSheet().equals(existingUploadsPanel)) {
					showSelectedExistingVideo();
				} else if (event.getTabSheet().equals(uploadVideoPanel)) {
					showUploadVideo();
				}
				
			}
		});
		
	}

	private static final class PersistenceFileValidator extends
			AbstractValidator<String> {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public PersistenceFileValidator() {
			super("Der Name der Datei muss mit (.mp4) enden!");
		}

		@Override
		protected boolean isValidValue(String value) {
			if (value != null && value.endsWith(".mp4")) {
				return true;
			}
			return false;
		}
		
		@Override
		public Class<String> getType() {
			return String.class;
		}
	}

	private VideoFile getUploadVideoFormData() {
		VideoFile data = new VideoFile();
		data.setName(persistenceFileName.getValue());
		data.setFile(currentlyUploadedVideoFile);
		data.setContentType("video/mp4");
		return data;
	}

	@Override
	public void onDisplayPage() {
	}

	@Autowired
	@Override
	public void setController(IUploadVideoPageController controller) {
		this.controller = controller;
		this.controller.setUploadVideoPage(this);
	}
	
	@Autowired
	public void setTempFileService(ITempFileService service) {
		tempFileService = service;
	}

	private void showUploadVideo() {
		if (currentlyUploadedVideoFile != null) {
			video.setVisible(true);
			video.setSource(new FileResource(currentlyUploadedVideoFile));
			video.setShowControls(true);
			video.setAutoplay(true);
		} else {
			video.setVisible(false);
		}
	}

	private void showSelectedExistingVideo() {
		uploadList.getValue();
	}

	class VideoUploader implements Receiver, SucceededListener {
		/**
		 * 
		 */
		private static final long serialVersionUID = -4452730377757210675L;
		public File file;
		public String mimeType;

		public OutputStream receiveUpload(String filename, String mimeType) {
			// Create upload stream
			this.mimeType = mimeType;
			file = null;
			try {
				file = tempFileService.getTempFile(filename, mimeType);
				OutputStream fos = new BufferedOutputStream(new FileOutputStream(file));
				
				// OK
				return fos; // Return the output stream to write to
			
			} catch (ServiceException e1) {
				showNotification(NotificationType.WARN, "Achtung", e1.getMessage());
			} catch (FileNotFoundException e) {
				showNotification(NotificationType.WARN, "Achtung", "Die Datei konnte nicht erstellt werden!");
			} 
			
			// not Ok
			return null;
		}

		public void uploadSucceeded(SucceededEvent event) {
			// Show the uploaded file in the image viewer
			currentlyUploadedVideoFile = new File(file.getAbsolutePath());
			showUploadVideo();
		}
	}

	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setMargin(false);

		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");

		// verticalSplitPanel_1
		splitPanel = buildVerticalSplitPanel_1();
		mainLayout.addComponent(splitPanel);
		mainLayout.setExpandRatio(splitPanel, 1.0f);

		return mainLayout;
	}

	@AutoGenerated
	private VerticalSplitPanel buildVerticalSplitPanel_1() {
		// common part: create layout
		splitPanel = new VerticalSplitPanel();
		splitPanel.setImmediate(false);
		splitPanel.setWidth("100.0%");
		splitPanel.setHeight("100.0%");

		// pageSelection
		pageSelection = buildPageSelection();
		splitPanel.addComponent(pageSelection);

		// previewPanel
		previewPanel = new HorizontalLayout();
		previewPanel.setImmediate(false);
		previewPanel.setWidth("100.0%");
		previewPanel.setHeight("100.0%");
		previewPanel.setMargin(false);
		splitPanel.addComponent(previewPanel);

		return splitPanel;
	}

	@AutoGenerated
	private Accordion buildPageSelection() {
		// common part: create layout
		pageSelection = new Accordion();
		pageSelection.setImmediate(true);
		pageSelection.setWidth("100.0%");
		pageSelection.setHeight("100.0%");

		// uploadVideoPanel
		uploadVideoPanel = buildUploadVideoPanel();
		pageSelection.addTab(uploadVideoPanel, "VideoFileEntity hochladen", null);

		// existingUploadsPanel
		existingUploadsPanel = buildExistingUploadsPanel();
		pageSelection
				.addTab(existingUploadsPanel, "Vorhandene Aufnahmen", null);

		return pageSelection;
	}

	@AutoGenerated
	private VerticalLayout buildUploadVideoPanel() {
		// common part: create layout
		uploadVideoPanel = new VerticalLayout();
		uploadVideoPanel.setImmediate(false);
		uploadVideoPanel.setWidth("100.0%");
		uploadVideoPanel.setHeight("100.25%");
		uploadVideoPanel.setMargin(false);

		// videoFileUpload
		videoFileUpload = new Upload();
		videoFileUpload.setImmediate(false);
		videoFileUpload.setWidth("100.0%");
		videoFileUpload.setHeight("-1px");
		uploadVideoPanel.addComponent(videoFileUpload);

		// persistenceFileName
		persistenceFileName = new TextField();
		persistenceFileName.setCaption("Speichern als");
		persistenceFileName.setImmediate(false);
		persistenceFileName.setWidth("100.0%");
		persistenceFileName.setHeight("-1px");
		uploadVideoPanel.addComponent(persistenceFileName);

		// saveButton
		saveButton = new Button();
		saveButton.setCaption("Speichern");
		saveButton.setImmediate(false);
		saveButton.setWidth("-1px");
		saveButton.setHeight("-1px");
		uploadVideoPanel.addComponent(saveButton);

		return uploadVideoPanel;
	}

	@AutoGenerated
	private HorizontalLayout buildExistingUploadsPanel() {
		// common part: create layout
		existingUploadsPanel = new HorizontalLayout();
		existingUploadsPanel.setImmediate(false);
		existingUploadsPanel.setWidth("100.0%");
		existingUploadsPanel.setHeight("100.0%");
		existingUploadsPanel.setMargin(false);

		// uploadList
		uploadList = new ListSelect();
		uploadList.setCaption("Aufnahmen");
		uploadList.setImmediate(false);
		uploadList.setWidth("100.0%");
		uploadList.setHeight("100.0%");
		existingUploadsPanel.addComponent(uploadList);
		existingUploadsPanel.setExpandRatio(uploadList, 1.0f);

		return existingUploadsPanel;
	}

	@Override
	public void setVideoFiles(List<VideoFile> existingVideoFiles) {
		existingUploadListContainer.removeAllItems();
		for(VideoFile file:existingVideoFiles) {
			existingUploadListContainer.addItem(file.getName());
		}
	}

	@Override
	public void resetUpload() {
		currentlyUploadedVideoFile = null;
		showUploadVideo();
	}

}