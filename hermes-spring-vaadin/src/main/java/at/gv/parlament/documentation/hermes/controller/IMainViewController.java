package at.gv.parlament.documentation.hermes.controller;

import at.gv.parlament.documentation.hermes.view.IMainView;

public interface IMainViewController {
	public void menuSelect(MenuAction command);
	public void setMainView(IMainView view);
}
