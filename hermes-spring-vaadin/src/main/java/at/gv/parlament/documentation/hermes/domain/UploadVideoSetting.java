package at.gv.parlament.documentation.hermes.domain;

import lombok.Data;

@Data
public class UploadVideoSetting {
	private String fileName;
	private byte[] data;
}
