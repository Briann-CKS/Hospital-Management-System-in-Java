import java.io.Serializable;

public abstract class Admin implements User, Serializable {

	String username;
	String password;
	String name;

	public void setUsername(String username)
	{
		this.username = username;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public void setName (String name)
	{
		this.name = name;
	}

	public String getUsername ()
	{
		return username;
	}

	public String getPassword()
	{
		return password;
	}

	public String getName()
	{
		return name;
	}
 
}
