package at.gv.parlament.documentation.hermes.controller.main;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.VaadinUIScope;
import com.vaadin.spring.navigator.SpringViewProvider;

import at.gv.parlament.documentation.hermes.domain.User;
import at.gv.parlament.documentation.hermes.service.login.ILoginService;
import at.gv.parlament.documentation.hermes.service.login.LoginService;
import at.gv.parlament.documentation.hermes.view.main.IMainView;
import at.gv.parlament.documentation.hermes.view.record.IRecordPage;
import at.gv.parlament.documentation.hermes.view.search.ISearchPage;
import at.gv.parlament.documentation.hermes.view.uploadvideo.IUploadVideoPage;

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
	private IUploadVideoPage uploadVideoPage;

	@Autowired
	private SpringViewProvider viewProvider;

	@Autowired
	private ILoginService loginService;

	@Override
	public void menuSelect(MenuAction action) {
		if (action.equals(MenuAction.LOGOUT)) {
			mainView.logoutSessionAndNavigateToLoginView();
		} else if (action.equals(MenuAction.RECORD)) {
			mainView.setContentPage(recordPage);
		} else if (action.equals(MenuAction.SEARCH)) {
			mainView.setContentPage(searchPage);
		} else if (action.equals(MenuAction.UPLOADVIDEO)) {
			mainView.setContentPage(uploadVideoPage);
		}
	}

	@Override
	public void setMainView(IMainView view) {
		mainView = view;
		User user = loginService.getLoggedInUser();
				
		if(user != null) {
			// NonAdmin functionalities
			mainView.addMenuEntry("Beiträge", MenuAction.SEARCH);
			
			// Admin functionalities
			if(user.getIsAdmin()) {
				mainView.addMenuEntry("Aufnahmequellen", MenuAction.RECORD);
				mainView.addMenuEntry("Aufnahmen", MenuAction.UPLOADVIDEO);
			}
			mainView.addMenuEntry("Logout", MenuAction.LOGOUT);
		}
	}
}
