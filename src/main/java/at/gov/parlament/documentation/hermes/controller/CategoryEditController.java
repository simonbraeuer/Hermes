package at.gov.parlament.documentation.hermes.controller;

import at.gov.parlament.documentation.hermes.domain.Category;
import at.gov.parlament.documentation.hermes.gui.ICategoryEditView;
import at.gov.parlament.documentation.hermes.gui.IView;
import at.gov.parlament.documentation.hermes.service.ICategoryService;
import lombok.extern.java.Log;
import ch.qos.logback.classic.Logger;

@Log
public class CategoryEditController implements IController
{
	private ICategoryService service;
	private ICategoryEditView view;
	
	public void setCategoryView(ICategoryEditView view)
	{
		this.view = view;
		this.view.setController(this);
		this.view.setCategoryList(service.getAllCategoryList());
	}
	
	public void setCategoryService(ICategoryService service)
	{
		this.service = service;
	}
	
	public IView getView()
	{
		return view;
	}
	
	public void saveCategory()
	{
		Category categoryToSave = view.getCategory();
		service.saveCategory(categoryToSave);
		view.setCategoryList(service.getAllCategoryList());
	}
	
	public void deleteCategory()
	{
		Category categoryToDelete = view.getCategory();
		service.deleteCategory(categoryToDelete);
		view.setCategoryList(service.getAllCategoryList());
	}
}
