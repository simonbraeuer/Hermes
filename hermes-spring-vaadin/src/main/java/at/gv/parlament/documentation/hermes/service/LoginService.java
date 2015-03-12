package at.gv.parlament.documentation.hermes.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import at.gv.parlament.documentation.hermes.domain.LoginCredentials;
import at.gv.parlament.documentation.hermes.domain.User;

@Component
//@Scope("session")
public class LoginService implements ILoginService{
	private User loggedInUser;
	
	@Override
	public boolean login(LoginCredentials credentials) {
		if (credentials.getUserName().startsWith("sbr")) {
			loggedInUser = new User();
			loggedInUser.setName("sbr");
			loggedInUser.setEmail("sbr@hermes.com");
			return true;
		}
		return false;
	}

	@Override
	public User getLoggedInUser() {
		return loggedInUser;
	}

	@Override
	public void logout() {
		loggedInUser = null;
	}

}
