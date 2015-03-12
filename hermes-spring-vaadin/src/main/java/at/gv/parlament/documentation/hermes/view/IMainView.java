package at.gv.parlament.documentation.hermes.view;

import at.gv.parlament.documentation.hermes.controller.IMainViewController;
import at.gv.parlament.documentation.hermes.controller.MenuAction;

public interface IMainView {
	public void setController(IMainViewController controller);
	public void setContentPage(IContentPage view);
	public void addMenuEntry(String caption, MenuAction action);
	public void logoutSessionAndNavigateToLoginView();
}
