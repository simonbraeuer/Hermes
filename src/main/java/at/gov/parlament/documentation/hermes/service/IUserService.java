/*
 */
package at.gov.parlament.documentation.hermes.service;

import java.util.List;

import at.gov.parlament.documentation.hermes.domain.User;


/**
 */
public interface IUserService
{
    User registerUser(String name, String passwords);
    List<User> getAllUsers();
}
