/*
 */
package at.gov.parlament.documentation.hermes.controller;

import lombok.extern.java.Log;
import at.gov.parlament.documentation.hermes.gui.IErrorView;
import at.gov.parlament.documentation.hermes.gui.IMainView;
import at.gov.parlament.documentation.hermes.service.IBeanService;

/**
 *
 */
@Log
public class AppController {

	private IMainView view;
	private IErrorView errorView;
	private IBeanService beanService;

	public void setMainView(IMainView view) {
		this.view = view;
		view.setController(this);
	}

	public void setBeanService(IBeanService service) {
		this.beanService = service;
	}

	public void setErrorView(IErrorView view) {
		this.errorView = view;
	}

	public void run() {
		log.info("Showing main view");
		setLoginView();
		view.showView();
	}

	public void setFormsAndViews() {
		MainTabViewController mainTabViewcontroller = beanService
				.getBean(MainTabViewController.class);
		view.setContainedView(mainTabViewcontroller.getView());

		CategoryEditController categoryEditController = beanService.getBean(CategoryEditController.class);
		mainTabViewcontroller.addView("Category", categoryEditController);
	}

	public void setLoginView() {
		LoginController mainLoginController = beanService
				.getBean(LoginController.class);
		view.setContainedView(mainLoginController.getView());
	}
}
