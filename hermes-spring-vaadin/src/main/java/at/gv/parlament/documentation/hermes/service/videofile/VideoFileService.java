package at.gv.parlament.documentation.hermes.service.videofile;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import at.gv.parlament.documentation.hermes.dao.VideoFileEntity;
import at.gv.parlament.documentation.hermes.dao.VideoFileRepository;
import at.gv.parlament.documentation.hermes.domain.VideoFile;
import at.gv.parlament.documentation.hermes.service.ServiceException;

import com.vaadin.spring.annotation.SpringComponent;

@SpringComponent
public class VideoFileService implements IVideoFileService {
	
	@Autowired
	VideoFileRepository repository;

	@Override
	public void persistUploadedFile(VideoFile file) throws ServiceException {
		VideoFileEntity videoFileEntity = new VideoFileEntity();
		videoFileEntity.setContentType(file.getContentType());
		videoFileEntity.setName(file.getName());
		videoFileEntity.setFilePath(file.getFile().getAbsolutePath());
		
		videoFileEntity = repository.save(videoFileEntity);
		
		if(videoFileEntity == null || videoFileEntity.getId() == null) {
			throw new ServiceException(VideoFileServiceExceptionState.FAIL_UPLOAD);
		}
	}

	@Override
	public List<VideoFile> getAllFiles() {
		ArrayList<VideoFile> allFiles = new ArrayList<VideoFile>();
		for(VideoFileEntity videoFileEntity : repository.findAll()) {
			allFiles.add(VideoFile.createByEntity(videoFileEntity));
		}
		return allFiles;
	}
	
}
