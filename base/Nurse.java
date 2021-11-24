import java.io.*;
import java.util.*;

public class Nurse extends Admin implements Serializable {

	ArrayList<String> note = new ArrayList<String>();
	String username;
	String password;
	String name;	
	Usertype type = Usertype.NURSE;

	public static void main (String args[])
	{
		Nurse nurse = new Nurse();


	
	
	}

	Nurse ()
	{
		super();
		this.username = "Unknown";
		this.password = "Unknown";
		this.name = "Unknown";
	}

	Nurse (String username, String password, String name)
	{
		super();
		this.username = username;
		this.password = password;
		this.name = name;
	}

	
}
