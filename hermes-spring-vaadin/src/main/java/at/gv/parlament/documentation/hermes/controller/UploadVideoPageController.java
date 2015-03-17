package at.gv.parlament.documentation.hermes.controller;

import java.io.Serializable;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.VaadinUIScope;

import at.gv.parlament.documentation.hermes.domain.UploadVideoSetting;
import at.gv.parlament.documentation.hermes.view.IUploadVideoPage;

@SpringComponent
@VaadinUIScope
public class UploadVideoPageController implements IUploadVideoPageController, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7796355461513368286L;
	private IUploadVideoPage page;
	
	@Override
	public void persistVideoFile(UploadVideoSetting setting) {
		//TODO save video
		page.resetWithMessage("Video erfolgreich gespeichert!");
	}

	@Override
	public void setUploadVideoPage(IUploadVideoPage page) {
		this.page = page;
		page.resetWithMessage("");
	}

}
