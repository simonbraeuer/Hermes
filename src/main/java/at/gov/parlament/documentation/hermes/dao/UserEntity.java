/*
 */
package at.gov.parlament.documentation.hermes.dao;

/**
 *
 */
public class UserEntity implements IEntity
{
    private Integer id;
    private String name;
	private String password;
    
    public UserEntity()
    {
        id = -1;
    }
    
    public UserEntity(int id) 
    {
        this.id = id;
    }
    
    public void setId(int id) 
    {
        this.id = id;
    }
    
    public Integer getId()
    {
        return id;
    }
    
    public void setName(String name) 
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getPassword()
	{
		return this.password;
	}
    
    @Override
    public boolean equals(Object object)
    {
        if (object instanceof UserEntity) 
        {
            UserEntity user = (UserEntity) object;
            if (this.id.equals(user.id)) 
            {
                return true;
            }
        }
        
        return false;          
    }
}
