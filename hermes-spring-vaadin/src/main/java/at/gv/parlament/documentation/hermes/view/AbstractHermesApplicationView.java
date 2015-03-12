package at.gv.parlament.documentation.hermes.view;

import at.gv.parlament.documentation.hermes.controller.HermesSessionController;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;

public abstract class AbstractHermesApplicationView extends CustomComponent
		implements View {
	
	protected static final String SESSIONCONTROLLER = "SESSIONCONTROLLER";
	
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
		getSessionController().logout();
		getUI().getNavigator().navigateTo(LoginView.NAME);
	}
}
