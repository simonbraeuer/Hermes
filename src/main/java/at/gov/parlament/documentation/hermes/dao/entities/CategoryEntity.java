package at.gov.parlament.documentation.hermes.dao.entities;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NonNull;

@Entity
public @Data class CategoryEntity implements IEntity {
	private Integer id;
	@NonNull private String no;
	@NonNull private String name;
}
