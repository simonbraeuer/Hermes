package at.gov.parlament.documentation.hermes.dao.entities;

import lombok.Data;
import lombok.NonNull;


public @Data class VideoEntity implements IEntity {
	@NonNull private Integer id;
	@NonNull private String name;
	@NonNull private String description;
	@NonNull private Integer categoryId;
	@NonNull private Integer filestorageId;
}
