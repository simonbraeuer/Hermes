package at.gov.parlament.documentation.hermes.gui;

import at.gov.parlament.documentation.hermes.controller.LoginController;


/**
 *
 */
public interface IMainLoginView extends IView
{
	void setDetailView(IView view);
	void setController(LoginController contorller);
}
