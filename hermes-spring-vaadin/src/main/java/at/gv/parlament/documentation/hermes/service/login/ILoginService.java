package at.gv.parlament.documentation.hermes.service.login;

import at.gv.parlament.documentation.hermes.domain.LoginCredentials;
import at.gv.parlament.documentation.hermes.domain.User;

public interface ILoginService {
	public boolean login(LoginCredentials credentials);
	public User getLoggedInUser();
	public void logout();
}
