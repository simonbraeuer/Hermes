package at.gv.parlament.documentation.hermes.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import at.gv.parlament.documentation.hermes.domain.LoginCredentials;
import at.gv.parlament.documentation.hermes.service.ILoginService;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.VaadinUIScope;

@VaadinUIScope
@SpringComponent
public class HermesSessionController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3891133617828612761L;

	transient private LoginCredentials loggedInCredentials;	
	
	@Autowired
	transient private ILoginService loginService;
	
	public void logout() {
		loginService.logout();
		loggedInCredentials = null;
	}
	
	public boolean login(LoginCredentials credentials) {
		if (loginService.login(credentials)) {
			loggedInCredentials = credentials;
			return true;
		}
		
		loggedInCredentials = null;
		return false;
	}
	
	public boolean isLoggedOut() {
		return loggedInCredentials == null;
	}
}
	
