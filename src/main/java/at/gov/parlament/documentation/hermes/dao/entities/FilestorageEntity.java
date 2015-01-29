package at.gov.parlament.documentation.hermes.dao.entities;

import lombok.Data;
import lombok.NonNull;

public @Data class FilestorageEntity implements IEntity{
	@NonNull private Integer id;
	@NonNull private String filePath;
	@NonNull private String hashValue;
}
