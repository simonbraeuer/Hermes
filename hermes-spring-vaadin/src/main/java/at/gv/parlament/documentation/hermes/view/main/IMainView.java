package at.gv.parlament.documentation.hermes.view.main;

import at.gv.parlament.documentation.hermes.controller.main.IMainViewController;
import at.gv.parlament.documentation.hermes.controller.main.MenuAction;
import at.gv.parlament.documentation.hermes.view.IContentPage;

public interface IMainView {
	public void setController(IMainViewController controller);
	public void setContentPage(IContentPage view);
	public void addMenuEntry(String caption, MenuAction action);
	public void logoutSessionAndNavigateToLoginView();
}
