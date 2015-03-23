package at.gv.parlament.documentation.hermes.view.uploadvideo;

import java.util.List;

import at.gv.parlament.documentation.hermes.controller.uploadVideo.IUploadVideoPageController;
import at.gv.parlament.documentation.hermes.domain.VideoFile;
import at.gv.parlament.documentation.hermes.view.IContentPage;

public interface IUploadVideoPage extends IContentPage {
	public void setController(IUploadVideoPageController controller);
	public void resetUpload();
	void setVideoFiles(List<VideoFile> existingVideoFiles);
}
