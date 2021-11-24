import java.io.*;
import java.util.*;

public class Doctor extends Admin implements Serializable {

	ArrayList<String> notification = new ArrayList<String>();
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

	Doctor() 
	{
		super();
		this.username = "Unknown";
		this.password = "Unknown";
		this.name = "Unknown";
	}

	Doctor (String username, String password, String name)
	{
		super();
		this.username = username;
		this.password = password;
		this.name = name;
	}	

	//public void listPatient

	public void readNotification()
	{
		System.out.println ("You have " + notification.size() + " new notification(s): \n");
		for (int i = 0; i< notification.size(); i++)
		{
			System.out.println (i+1 + ") " + notification.get(i));
		}
		System.out.println ("");

	}

	public void deleteNotification(int num)
	{
		int ind = num -1;
		if (notification.size() >= ind)
		{
			notification.remove(ind);
			System.out.print("Message has been deleted.");
		}
		else
		{
			System.out.println("Cannot find the message you intend to delete. Sorry!");
		}
	}

	public void setNotification (String message)
	{
		this.notification.add(message);
	}

	
	

}
