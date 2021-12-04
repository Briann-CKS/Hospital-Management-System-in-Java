import java.util.*;
import java.io.*;

public class Appointment implements Serializable {

	public Time start = new Time();
	public Time end = new Time();
	private String name;
	private String note;

	public static void main (String args[])
	{
		Appointment appointment = new Appointment();
	}

	public Appointment()
	{
		this.name = "";
		this.note = "";
	}

	public Appointment (Time start, Time end, String name, String note)
	{
		this.start = start;
		this.end = end;
		this.name = name;
		this.note = note;
	}

	public void setName (String name)
	{
		this.name = name;
	}

	public void setNote (String note)
	{
		this.note = note;
	}

	public void setStart (Time start)
	{
		this.start = start;
	}
	
	public void setEnd (Time end)
	{
		this.end = end;
	}

	public String getName()
	{
		return name;
	}

	public String getNote()
	{
		return note;
	}

	public void printAppointment()
	{
		System.out.println ("Name: " + this.name);
		System.out.println ("Date and time: " + start.stringTime() + " to " + end.stringTime());
		System.out.println ("Note: " + this.note + "\n");
	}
}
