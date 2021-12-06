import java.io.*;

// Start Time class
public class Time implements Serializable {

	private int day;
	private int month;
	private int year;
	private int hour;
	private String AMorPM;

	public static void main (String args[])
	{
		Time time = new Time();
	}

	public Time () {
		this.day = 0;
		this.month = 0;
		this.year = 0;
		this.hour = 0;
		this.AMorPM = "";
	}

	public Time (int day, int month, int year, int hour, String AMorPM)
	{
		this.day = day;
		this.month = month;
		this.year = year;
		this.hour = hour;
		this.AMorPM = AMorPM;
	}
		
	public void setDay (int day)
	{
		this.day = day;
	}

	public void setMonth (int month)
	{
		this.month = month;
	}

	public void setYear (int year)
	{
		this.year = year;
	}

	public void setHour (int hour)
	{
		this.hour = hour;
	}

	public void setAMorPM (String AMorPM)
	{
		this.AMorPM = AMorPM;
	}

	public int getDay ()
	{
		return day;
	}

	public int getMonth()
	{
		return month;
	}
	
	public int getYear()
	{
		return year;
	}

	public int getHour()
	{
		return hour;
	}

	public String getAMorPM()
	{
		return AMorPM;
	}

	public String stringTime()
	{
		String full = month + "/" + day + "/" + year + ", " + hour + ":00" + AMorPM; 
		return full;
	}
} // End Time class
