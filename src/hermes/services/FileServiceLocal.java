package hermes.services;

import java.io.File;

public class FileServiceLocal implements IFileService {

	public String getHashStringForFile(File file) {
		if (file == null) {
			return "";
		}
		return ""+file.hashCode();
	}

}
