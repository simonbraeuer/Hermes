package at.gv.parlament.documentation.hermes.service.login;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.VaadinUIScope;

import at.gv.parlament.documentation.hermes.domain.LoginCredentials;
import at.gv.parlament.documentation.hermes.domain.User;

@SpringComponent
@VaadinUIScope
public class DummyLoginService implements ILoginService {
	private User currUser;
	
	@Override
	public boolean login(LoginCredentials credentials) {
		currUser = new User();
		currUser.setName("Dummy");
		currUser.setEmail("mail@dummy.at");
		currUser.setIsAdmin(true);
		return true;
	}

	@Override
	public User getLoggedInUser() {
		return currUser;
	}

	@Override
	public void logout() {
		currUser = null;
	}

}
