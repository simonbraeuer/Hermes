package at.gv.parlament.documentation.hermes.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.VaadinUIScope;

import at.gv.parlament.documentation.hermes.domain.LoginCredentials;
import at.gv.parlament.documentation.hermes.domain.User;


public class LoginService implements ILoginService{
	private User loggedInUser;
	
	@Autowired
	private Environment env;
	
	@Override
	public boolean login(LoginCredentials credentials) {
		if (isSuperAdmin(credentials)) {
			loggedInUser = new User();
			loggedInUser.setName(credentials.getUserName());
			loggedInUser.setIsAdmin(true);
			return true;
		} 
		if (isSimpleUser(credentials)) {
			loggedInUser = new User();
			loggedInUser.setName("sbr");
			loggedInUser.setIsAdmin(false);
			return true;
		}
		loggedInUser = null;
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
	
	private boolean isSuperAdmin(LoginCredentials credentials) {
		if(credentials.getUserName().equals(env.getProperty("hermes.superadmin.username", "HermannMaier"))) {
			if(credentials.getPassword().equals(env.getProperty("hermes.superadmin.password", "Herminator98"))) {
				return true;
			}	
		}
		return false;
	}
	
	private boolean isSimpleUser(LoginCredentials credentials) {
		if(credentials.getUserName().equals(env.getProperty("hermes.simpleuser.username", "HansKrankl"))) {
			if(credentials.getPassword().equals(env.getProperty("hermes.simpleuser.password", "Goleador78"))) {
				return true;
			}	
		}
		return false;
	}

}
