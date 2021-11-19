public abstract class User {

	String username;
	String password;
	String name;

	public abstract void setUsername (String username);
	public abstract void setPassword (String password);
	public abstract void setName (String name);

	public abstract String getUsername();
	public abstract String getPassword();
	public abstract String getName();
}
