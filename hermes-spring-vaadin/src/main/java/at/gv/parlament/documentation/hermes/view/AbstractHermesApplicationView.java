package at.gv.parlament.documentation.hermes.view;

import org.springframework.beans.factory.annotation.Autowired;

import at.gv.parlament.documentation.hermes.controller.HermesSessionController;
import at.gv.parlament.documentation.hermes.view.login.LoginView;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;

public abstract class AbstractHermesApplicationView extends CustomComponent
		implements View {
	
	protected static final String SESSIONCONTROLLER = "SESSIONCONTROLLER";
	
	@Autowired
	private HermesSessionController sessionController;
	
	protected HermesSessionController getSessionController() {
		if(getSession() == null) {
			return null;
		}
		
		return (HermesSessionController) getSession().getAttribute(SESSIONCONTROLLER);
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		checkLogin();
	}
	
	protected boolean checkLogin() {
		if (getSessionController() == null || getSessionController().isLoggedOut()) {
			logoutSessionAndNavigateToLoginView();
			return (false);
		}
		return true;
	}
	
	public void logoutSessionAndNavigateToLoginView() {
		if(getSessionController()!=null) {
			getSessionController().logout();
		}
		getUI().getNavigator().navigateTo(LoginView.NAME);
	}
}
