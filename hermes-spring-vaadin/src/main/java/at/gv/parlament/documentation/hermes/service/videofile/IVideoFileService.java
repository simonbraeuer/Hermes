package at.gv.parlament.documentation.hermes.service.videofile;

import java.util.List;

import at.gv.parlament.documentation.hermes.domain.VideoFile;
import at.gv.parlament.documentation.hermes.service.ServiceException;

public interface IVideoFileService {
	public void persistUploadedFile(VideoFile file) throws ServiceException;
	public List<VideoFile>getAllFiles() throws ServiceException;
}
