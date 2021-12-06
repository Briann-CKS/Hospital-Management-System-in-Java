import java.lang.*;

// Start User interface
public interface User {

	String username = "Unknown";
	String password = "Unknown";
	String name = "Unknown";

	public void setUsername (String username);
	public void setPassword (String password);
	public void setName (String name);

	public String getUsername();
	public String getPassword();
	public String getName();
} // end User interface
