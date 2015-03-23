package at.gv.parlament.documentation.hermes.controller.uploadVideo;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.VaadinUIScope;

import at.gv.parlament.documentation.hermes.controller.NotificationType;
import at.gv.parlament.documentation.hermes.domain.VideoFile;
import at.gv.parlament.documentation.hermes.service.ServiceException;
import at.gv.parlament.documentation.hermes.service.videofile.IVideoFileService;
import at.gv.parlament.documentation.hermes.view.uploadvideo.IUploadVideoPage;

@SpringComponent
@VaadinUIScope
public class UploadVideoPageController implements IUploadVideoPageController, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7796355461513368286L;
	private IUploadVideoPage page;
	
	@Autowired
	private IVideoFileService videoFileService;
	

	@Override
	public void setUploadVideoPage(IUploadVideoPage page) {
		this.page = page;
	}


	@Override
	public UploadVideoValidationResult validateUpload(VideoFile file) {
		return UploadVideoValidationResult.OK;
	}

	@Override
	public void persistUpload(VideoFile file) {
		UploadVideoValidationResult validationResult = validateUpload(file);
		if(!validationResult.equals(UploadVideoValidationResult.OK)) {
			page.showNotification(NotificationType.WARN, "Validierungsfehler", validationResult.getValidationMessage());
		} else {
			try {
				videoFileService.persistUploadedFile(file);
				page.showNotification(NotificationType.TRAY, "Video gespeichert!", "Das Video wurde erfolgreich gespeichert!");
				page.resetUpload();
			} catch (ServiceException e) {
				page.showNotification(NotificationType.WARN, "Achtung", e.getMessage());
			}
		}
	}
	
}
