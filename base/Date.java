import java.io.*;

public class Date implements Serializable {

	int day = 0;
	int month = 0;
	int year = 0;
	String fullDate;

	public static void main (String args[])
	{
		Date date = new Date();
		System.out.println (date.getFullDate());
	}

	Date () {
	}

	Date (int day, int month, int year)
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
