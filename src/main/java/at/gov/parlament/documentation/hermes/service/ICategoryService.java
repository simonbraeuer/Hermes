package at.gov.parlament.documentation.hermes.service;

import java.util.List;

import at.gov.parlament.documentation.hermes.domain.Category;

public interface ICategoryService {

	List<Category> getAllCategoryList();

	void saveCategory(Category categoryToSave);

	void deleteCategory(Category categoryToDelete);

}
