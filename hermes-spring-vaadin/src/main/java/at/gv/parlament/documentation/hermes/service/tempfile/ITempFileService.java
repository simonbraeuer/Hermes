package at.gv.parlament.documentation.hermes.service.tempfile;

import java.io.File;
import at.gv.parlament.documentation.hermes.service.ServiceException;

public interface ITempFileService {
	public File getTempFile(String name, String contentType) throws ServiceException;
}
