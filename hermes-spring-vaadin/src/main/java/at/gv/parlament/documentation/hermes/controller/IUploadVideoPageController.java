package at.gv.parlament.documentation.hermes.controller;

import at.gv.parlament.documentation.hermes.domain.UploadVideoSetting;
import at.gv.parlament.documentation.hermes.view.IUploadVideoPage;

public interface IUploadVideoPageController {
	public void persistVideoFile(UploadVideoSetting setting);
	public void setUploadVideoPage(IUploadVideoPage page);
}
