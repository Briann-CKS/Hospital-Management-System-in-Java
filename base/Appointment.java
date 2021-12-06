import java.util.*;
import java.io.*;

// Start Appointment class
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
		String nameDay = findDay (start.getDay(), start.getMonth(), start.getYear());
		System.out.println ("Name: " + this.name);
		System.out.println ("Date and time: " + start.stringTime() + " to " + end.stringTime());
		System.out.println ("Day: " + nameDay);
		System.out.println ("Note: " + this.note + "\n");
	}

	public String findDay(int day, int month, int year)
	{
		String nday [] = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		int monthKeyNo[] = { 0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};
		int centuryValue = 6;
		int total = (year % 100) + ((year % 100) / 4) + day + monthKeyNo[month - 1] + centuryValue; 	
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
		{	
			if ((total % 7) > 0)
			{
				return nday[(total % 7) - 1];
			}
			else
			{
				return nday[6];
			}
		}
		else
		{
			return nday[(total % 7)];
		}
	}
} // End Appointment class
