import java.io.*;
import java.util.*;

public class Doctor extends Admin implements Serializable {

	public ArrayList<String> notification = new ArrayList<String>();
	private String username;
	private String password;
	private String name;
	protected String specialty;
	public ArrayList<Appointment> appointment = new ArrayList <Appointment>();
	Usertype type = Usertype.DOCTOR;
	
	public static void main (String args[])
	{
		Doctor doctor = new Doctor ();
	}

	public Doctor(String username, String password, String name, String specialty) 
	{
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.specialty = specialty;
	}

	public Doctor()
	{
		super();
		this.username = "";
		this.password = "";
		this.name = "";
		this.specialty = "";
	}	

	public String getSpecialty()
	{
		return specialty;
	}

	public void setSpecialty(String specialty)
	{
		this.specialty = specialty;
	}

	public void readNotification()
	{
		System.out.println ("You have " + notification.size() + " notification(s). \n");
		for (int i = 0; i< notification.size(); i++)
		{
			System.out.println (i+1 + ") " + notification.get(i));
		}
		System.out.println ("");
		if (notification.size() > 10)
		{
			System.out.println ("Looks like you have quite a few notifications stored in your account. Clearing some old messages will help you organize better!\n");
		}
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

	public void addAppointment (Appointment app)
	{
		






	}

}
