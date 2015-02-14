/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.gov.parlament.documentation.hermes.service;

import at.gov.parlament.documentation.hermes.dao.IUserDao;
import at.gov.parlament.documentation.hermes.dao.UserEntity;
import at.gov.parlament.documentation.hermes.domain.User;
import at.gov.parlament.documentation.hermes.exceptions.HashingServiceException;


/**
 *
 */
public class LoginService implements ILoginService {
	
	private IUserDao userDao;
	private User user;
    private IHashingService hashingService;
	
	public void setUserDao(IUserDao userDao)
	{
		this.userDao = userDao;
	}
    
    public void setHashingService(IHashingService hashingService)
    {
        this.hashingService = hashingService;
    }
	
	public User login(String usernam, String password)
	{
        password = hashPassword(password);
		UserEntity userEntity = userDao.findUserByNameAndPassword(usernam, password);
		
		if(userEntity != null)
		{
			user = new User(userEntity);
			user.setLogedIn(true);
			return user;
		}
		
		return null;
	}
        
    private String hashPassword(String password)
    {
        try
        {
         password = hashingService.hashPassword(password);
        }
        catch(HashingServiceException e)
        {
            //TODO throw hashing exception
        }
         
        return password;
    }
}
