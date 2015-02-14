package at.gov.parlament.documentation.hermes.gui;

import java.util.List;

import at.gov.parlament.documentation.hermes.controller.IController;
import at.gov.parlament.documentation.hermes.domain.Category;

public interface ICategoryEditView extends IView{

	void setController(IController categoryEditController);

	void setCategoryList(List<Category> allCategoryList);

	Category getCategory();

}
