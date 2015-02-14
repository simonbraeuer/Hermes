package at.gov.parlament.documentation.hermes.domain;

import at.gov.parlament.documentation.hermes.dao.CategoryEntity;

public class Category {
	private CategoryEntity entity;

	public CategoryEntity getEntity() {
		return entity;
	}
	
	public String getName( ) {
		return entity.getName();
	}

	public void setName(String name) {
		entity.setName(name);
	}
}
