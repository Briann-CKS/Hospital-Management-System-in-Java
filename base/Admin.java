import java.io.Serializable;

// Start admin abstract class
public abstract class Admin implements User, Serializable {

	private String username;
	private String password;
	private String name;
	private String code;

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

	public void setCode (String code)
	{
		this.code = code;
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
 
	public String getCode()
	{
		return code;
	}
} // end admin abstract class
