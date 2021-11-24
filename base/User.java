import java.lang.*;

public interface User {

	public String username = new String ("Unknown");
	public String password = new String ("Unknown");
	public String name = new String ("Unknown");

	public void setUsername (String username);
	public void setPassword (String password);
	public void setName (String name);

	public String getUsername();
	public String getPassword();
	public String getName();
}
