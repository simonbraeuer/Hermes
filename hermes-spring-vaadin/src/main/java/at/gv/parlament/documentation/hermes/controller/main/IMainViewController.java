package at.gv.parlament.documentation.hermes.controller.main;

import at.gv.parlament.documentation.hermes.view.main.IMainView;

public interface IMainViewController {
	public void menuSelect(MenuAction command);
	public void setMainView(IMainView view);
}
