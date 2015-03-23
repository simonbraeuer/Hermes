package at.gv.parlament.documentation.hermes.domain;

import java.io.File;

import at.gv.parlament.documentation.hermes.dao.VideoFileEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @EqualsAndHashCode(exclude={"file", "contentType"})
@Getter @Setter 
public class VideoFile {
	private String name;
	private File file;
	private String contentType;
	
	public static VideoFile createByEntity(VideoFileEntity videoFileEntity) {
		VideoFile createdFile = new VideoFile();
		
		createdFile.name = videoFileEntity.getName();
		createdFile.contentType = videoFileEntity.getContentType();
		createdFile.file = new File(videoFileEntity.getFilePath());
		return createdFile;
	}
}
