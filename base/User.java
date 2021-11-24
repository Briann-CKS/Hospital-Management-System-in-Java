import java.lang.*;

public interface User {

	String username = new String ("Unknown");
	String password = new String ("Unknown");
	String name = new String ("Unknown");

	public void setUsername (String username);
	public void setPassword (String password);
	public void setName (String name);

	public String getUsername();
	public String getPassword();
	public String getName();
}
