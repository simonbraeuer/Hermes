package at.gv.parlament.documentation.hermes.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.VaadinUIScope;
import com.vaadin.spring.navigator.SpringViewProvider;

import at.gv.parlament.documentation.hermes.view.IMainView;
import at.gv.parlament.documentation.hermes.view.IRecordPage;
import at.gv.parlament.documentation.hermes.view.ISearchPage;

@SpringComponent
@VaadinUIScope
public class MainViewController implements IMainViewController, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2149117725914284080L;

	private IMainView mainView;
	
	@Autowired
	private IRecordPage recordPage;
	
	@Autowired
	private ISearchPage searchPage;
	
	@Autowired
    private SpringViewProvider viewProvider;

	
	@Override
	public void menuSelect(MenuAction action) {
		if(action.equals(MenuAction.LOGOUT)) {
			mainView.logoutSessionAndNavigateToLoginView();
		} else if(action.equals(MenuAction.RECORD)) {
			mainView.setContentPage(recordPage);
		} else if(action.equals(MenuAction.SEARCH)) {
			mainView.setContentPage(searchPage);
		}
	}

	@Override
	public void setMainView(IMainView view) {
		mainView = view;
		mainView.addMenuEntry("Beitraege", MenuAction.SEARCH);
		mainView.addMenuEntry("Aufnahmen", MenuAction.RECORD);
		mainView.addMenuEntry("Logout", MenuAction.LOGOUT);
	}
	
}
