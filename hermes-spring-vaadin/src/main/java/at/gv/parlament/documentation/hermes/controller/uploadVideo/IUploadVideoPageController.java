package at.gv.parlament.documentation.hermes.controller.uploadVideo;

import at.gv.parlament.documentation.hermes.domain.VideoFile;
import at.gv.parlament.documentation.hermes.view.uploadvideo.IUploadVideoPage;

public interface IUploadVideoPageController {
	public UploadVideoValidationResult validateUpload(VideoFile file);
	public void persistUpload(VideoFile file);
	public void setUploadVideoPage(IUploadVideoPage page);
}
