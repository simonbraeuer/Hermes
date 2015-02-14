package at.gov.parlament.documentation.hermes.service;

import at.gov.parlament.documentation.hermes.domain.User;


/**
 *
 */
public interface ILoginService {
	public User login(String username, String password);
}
