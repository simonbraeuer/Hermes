/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.gov.parlament.documentation.hermes.domain;

import at.gov.parlament.documentation.hermes.dao.UserEntity;


/**
 *
 */
public class User 
{
    private UserEntity entity;
	private boolean logedIn = false;
    
    public User(UserEntity entity)
    {
        this.entity = entity;
    }
    
    public User()
    {
        entity = new UserEntity();
    }
    
    public UserEntity getEntity()
    {
        return entity;
    }
    
    public String getName()
    {
        return entity.getName();              
    }
    
    public void setName(String name)
    {
        entity.setName(name);
    }
	
	public boolean getLogedIn()
	{
		return this.logedIn;
	}
	
	public void setLogedIn(boolean logedIn)
	{
		this.logedIn = logedIn;
	}
    
    public String getPassword()
    {
        return entity.getPassword();
    }
    
    public void setPassword(String password)
    {
        entity.setPassword(password);
    }
	
	@Override
	public String toString()
	{
		return getName();
	}
}
