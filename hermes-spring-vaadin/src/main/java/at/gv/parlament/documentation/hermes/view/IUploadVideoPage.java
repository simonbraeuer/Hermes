package at.gv.parlament.documentation.hermes.view;

import at.gv.parlament.documentation.hermes.controller.IUploadVideoPageController;

public interface IUploadVideoPage extends IContentPage {
	public void setController(IUploadVideoPageController controller);
	public void resetWithMessage(String text);
}
