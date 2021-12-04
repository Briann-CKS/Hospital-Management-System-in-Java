import java.io.*;

public class Time implements Serializable {

	int day = 0;
	int month = 0;
	int year = 0;
	//int hr;
	//int startMin;
	int min; 
	//int endMin;
	String fullDate;

	public static void main (String args[])
	{
		Time time = new Time();
	}

	public Time () {
	}

	public Time (int day, int month, int year)
	{
		this.day = day;
		this.month = month;
		this.year = year;
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

	public void setStartTime (int hr, int min)
	{
	//	this.startHr = hr;
	//	this.startMin = min;
	}

	public void setEndTime (int hr, int min)
	{
		//this.end
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

	public String getFullDate()
	{
		this.fullDate = day + "/" + month + "/" + year + " ";
		return fullDate;
	}

} 	
