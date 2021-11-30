import java.io.*;
import java.util.*;

public class Nurse extends Admin implements Serializable {

	public ArrayList<String> note = new ArrayList<String>();
	private String username;
	private String password;
	private String name;	
	Usertype type = Usertype.NURSE;

	public static void main (String args[])
	{
		Nurse nurse = new Nurse();
	}

	public Nurse ()
	{
		super();
		this.username = "Unknown";
		this.password = "Unknown";
		this.name = "Unknown";
	}

	public Nurse (String username, String password, String name)
	{
		super();
		this.username = username;
		this.password = password;
		this.name = name;
	}

	public void setNote (String message)
	{
		this.note.add(message);
	}

	public void deleteNote (int num)
	{
		int ind = num - 1;
		if (this.note.size() >= num)
		{
			note.remove(ind);
			System.out.println ("Message has been deleted!\n");
		}
		else 
		{
			System.out.println ("Cannot find the message you intend to delete. Sorry!\n");
		}
	}

	public void readNote ()
	{
		System.out.println ("You have " + note.size() + " notification(s). \n");
		for (int i = 0; i < note.size(); i++)
		{
			System.out.println (i+1 + ") " + note.get(i));
		}
		System.out.println ("");
		if (note.size() > 10)
		{
			System.out.println ("Looks like you have quite a few notifications stored in your account. Clearing some old messages will help you organize better!\n");
		}
	}

}
