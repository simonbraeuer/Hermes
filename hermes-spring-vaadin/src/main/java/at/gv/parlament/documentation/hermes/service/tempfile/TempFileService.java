package at.gv.parlament.documentation.hermes.service.tempfile;

import java.io.File;
import java.io.IOException;

import lombok.extern.java.Log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import at.gv.parlament.documentation.hermes.service.ServiceException;

import com.vaadin.spring.annotation.SpringComponent;

@Log
@SpringComponent
public class TempFileService implements ITempFileService {
	
	@Autowired
	@Qualifier("appDataPathTmp")
	private String tmpFolderPath;
	
	@Override
	public File getTempFile(String name, String contentType) throws ServiceException {
		log.info("Get temporary file: '" + name + "' - " + contentType);
		// Open the file for writing.
		File file = new File(tmpFolderPath);
		if(!file.exists()) {
			throw new ServiceException(TempFileServiceExceptionState.FOLDER_NOT_REACHABLE);
		}
		try {
			file = File.createTempFile("hermestemp_", ".mp4", file);
		} catch (IOException e) {
			throw new ServiceException(TempFileServiceExceptionState.CREATION_FAILED);
		}
		if(!file.canWrite()) {
			throw new ServiceException(TempFileServiceExceptionState.NO_WRITE_POSSIBLE);
		}
		log.info("Temporary file created: " + file.getAbsolutePath());
		return file;
	}
}
