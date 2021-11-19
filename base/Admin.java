public abstract class Admin implements User Serializable {

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
		return Username;
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
