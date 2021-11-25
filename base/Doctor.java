import java.io.*;
import java.util.*;

public class Doctor extends Admin implements Serializable {

	public static ArrayList<String> notification = new ArrayList<String>();
	String username;
	String password;
	String name;
	Usertype type = Usertype.DOCTOR;
	
	public static void main (String args[])
	{
		Doctor doctor = new Doctor ();
		/*doctor.setNotification("Hello");
		doctor.setNotification("Its me");
		doctor.setNotification ("I love you");
		doctor.readNotification();
		doctor.deleteNotification(2);
		doctor.readNotification();*/
	}

	public Doctor() 
	{
		super();
		this.username = "Unknown";
		this.password = "Unknown";
		this.name = "Unknown";
	}

	public Doctor (String username, String password, String name)
	{
		super();
		this.username = username;
		this.password = password;
		this.name = name;
	}

	//public void listPatient

	public void readNotification()
	{
		System.out.println ("You have " + notification.size() + " notification(s): \n");
		for (int i = 0; i< notification.size(); i++)
		{
			System.out.println (i+1 + ") " + notification.get(i));
		}
		System.out.println ("");
		/*if (notification.size() > 10)
		{
			System.out.println ("Looks like you have quite a few notifications stored in your account. Clearing some old messages will help you organize better!\n");
		}*/
	}

	public void deleteNotification(int num)
	{
		int ind = num -1;
		if (notification.size() >= num)
		{
			notification.remove(ind);
			System.out.println("Message has been deleted!\n");
		}
		else
		{
			System.out.println("Cannot find the message you intend to delete. Sorry!\n");
		}
	}

	public void setNotification (String message)
	{
		this.notification.add(message);
	}

	
}
