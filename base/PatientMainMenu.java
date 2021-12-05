import java.io.*;
import java.util.Scanner;
import java.util.Vector;
import java.util.Formatter;
import java.util.*;

public class PatientMainMenu implements Serializable {

	private Doctor doc1 = new Doctor();
	private Nurse nur1 = new Nurse();
	private FrontDesk fd1 = new FrontDesk();
	private Patient pt1 = new Patient();
	private Time time = new Time();
	private Time endTime = new Time();
	Scanner gen = new Scanner (System.in);
	Scanner str = new Scanner (System.in);

	public static void main (String args[])
	{
		new PatientMainMenu ();
	}

	public PatientMainMenu() {
	}

	public PatientMainMenu (Patient p1, Vector d, Vector n, Vector f, Vector p)
	{
		boolean keep_going = true;
		System.out.println ("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
		System.out.println ("Welcome to the Patient Menu!\n");
		System.out.println ("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");

		while (keep_going)
		{
			System.out.println ("Please enter your choice: \n");
			System.out.println ("1. Get Diagnosis\n2. Get Prescription\n3. Pay Medical Bill\n4. View Medical Bill\n5. View all admins of this hospital\n6. Schedule an appointment with a doctor\n7. View all scheduled appointments\n8. Delete a past appointment record\n9. Sign out\n");
			int choice  = gen.nextInt();
			if (choice == 1)
			{
				if (p1.getDiagnosis().equals(""))
				{
					System.out.println ("You don't have a diagnosis yet. Try consulting a doctor!\n");
				}
				else
				{
					System.out.println("Here is the diagnosis given by your doctor:\n");
					System.out.println(p1.getDiagnosis()+ "\n");
				}
			}
			else if (choice == 2)
			{
				if (p1.getPrescription().equals(""))
				{
					System.out.println ("You don't have a prescription yet. Try consulting a doctor!\n");
				}
				else
				{
					System.out.println("Here is the prescription given by your doctor:\n");
					System.out.println(p1.getPrescription()+ "\n");
				}
			}

			else if (choice == 3)
			{
				p1.paymedical_bill();
			}

			else if (choice == 4)
			{
				String bil = String.format("%.2f", p1.getBill());
				System.out.println ("\nYour current medical bill is $" + bil + " in total.\n");  
			}

			else if (choice == 5)
			{
				System.out.println ("Admins of this hospital:\n");
				System.out.println ("Doctors");
				Formatter fo = new Formatter();
				System.out.println (fo.format("%-5s%-15s%-22s%-15s", "No.", "Username", "Full Name", "Specialty")); 
				for (int i = 0; i < d.size(); i++)	
				{
					doc1 = (Doctor) d.get(i);
					fo = new Formatter();
					System.out.println (fo.format("%-5s%-15s%-22s%-15s", i+1 + ")", doc1.getUsername(), doc1.getName(), doc1.getSpecialty()));
				}
				System.out.println ("");
				
				System.out.println ("Nurses");
				fo = new Formatter();
				System.out.println (fo.format("%-5s%-15s%-22s", "No.", "Username", "Full Name")); 
				for (int i = 0; i < n.size(); i++)	
				{
					nur1 = (Nurse) n.get(i);
					fo = new Formatter();
					System.out.println (fo.format("%-5s%-15s%-22s", i+1 + ")", nur1.getUsername(), nur1.getName()));
				}	
				System.out.println ("");

				System.out.println ("Front Desks");
				fo = new Formatter();
				System.out.println (fo.format("%-5s%-15s%-22s", "No.", "Username", "Full Name")); 
				for (int i = 0; i < f.size(); i++)	
				{
					fo = new Formatter();
					fd1 = (FrontDesk) f.get(i);
					System.out.println (fo.format("%-5s%-15s%-22s", i+1 + ")", fd1.getUsername(), fd1.getName()));
				}
				System.out.println ("");
			}
			else if (choice == 6)
			{
				System.out.println ("Doctors");
				Formatter fo = new Formatter();
				System.out.println (fo.format("%-5s%-15s%-22s%-15s", "No.", "Username", "Full Name", "Specialty")); 
				for (int i = 0; i < d.size(); i++)	
				{
					doc1 = (Doctor) d.get(i);
					fo = new Formatter();
					System.out.println (fo.format("%-5s%-15s%-22s%-15s", i+1 + ")", doc1.getUsername(), doc1.getName(), doc1.getSpecialty()));
				}
				System.out.println ("\nPlease select a doctor you want to schedule an appointment with: ");
				int ch = gen.nextInt();
				if (ch > d.size())
                               	{
                                       	System.out.println ("\nSorry, no doctor found for the number you entered!\n");
                               	}
                               	else
                               	{
					int month = 0;
					int day = 0;
					int period = 0;
					int hour = 0;
					int minute = 0;
					boolean proceed = true;
					doc1 = (Doctor) d.get(ch-1);
					System.out.println ("\n*Do take note that our hospital has restricted all appointments to be 1 hour long.*");
					System.out.println ("\nPlease select the year of your intended appointment:\n\n1. 2021\n2. 2022\n3. 2023\n");						
					int pickYear = gen.nextInt();
					if (pickYear == 1)
					{
						time.setYear(2021);
						endTime.setYear(2021);
					}
					else if (pickYear == 2)
					{
						time.setYear(2022);
						endTime.setYear(2022);
					}
					else if (pickYear == 3)
					{
						time.setYear(2023);
						endTime.setYear(2023);
					}
					else
					{
						System.out.println ("\nInvalid input!\n");
						proceed = false;
					}
			
					if (proceed == true)
					{
						System.out.println ("\nPlease enter the month of your intended appointment (integer 1 to 12):");
						month = gen.nextInt();
						if (month >= 1 && month <= 12)
						{
							time.setMonth(month);
							endTime.setMonth(month);
						}
						else 
						{	
							System.out.println ("There is no month " + month + " in a year!\n");
							proceed = false;
						}
					}
					
					if (proceed == true)
					{								
						System.out.println ("\nPlease enter the day of your intended appointment (integer 1 to 31 based on the month and year):");
						day = gen.nextInt();
						if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
						{
							if (day > 0 && day < 32)
							{
								time.setDay(day);
								endTime.setDay(day);
							}
							else
							{
								System.out.println ("\nMonth " + month + " of year " + time.getYear() + " does not have " + day + " days!\n");
								proceed = false;
							}
						}
						else if (month == 4 || month == 6 || month == 9 || month == 11)
						{
							if (day > 0 && day < 31)
							{
								time.setDay(day);
								endTime.setDay(day);
							}
							else
							{
								System.out.println ("\nMonth " + month + " of year " + time.getYear() + " does not have " + day + " days!\n");
								proceed = false;
							}
						
						}
						else
						{
							if (day > 0 && day < 29)
							{
								time.setDay(day);
								endTime.setDay(day);
							}
							else
							{
								System.out.println ("\nMonth " + month + " of year " + time.getYear() + " does not have " + day + " days!\n");
								proceed = false;
							}
						}
						boolean reconfirm = true; 
						String nameday = findDay(day, month, time.getYear());
						while (reconfirm)
						{
							System.out.println ("\nThat's a " + nameday + ". Do you want to proceed? (1. Yes 2. No)");
							int prochoice = gen.nextInt();
							if (prochoice == 1)
							{
								proceed = true;
								reconfirm = false;
							}
							else if (prochoice == 2)
							{
								proceed = false;
								reconfirm = false;
							}
							else 
							{
								System.out.println ("\nInvalid option! Try again!\n");
							}
						}	
					}		

					if (proceed == true)
					{
						System.out.println ("\nPlease select the best time period for your appointment:\n\n1. From 8:00am to 11:00am\n2. From 12:00pm to 5:00pm\n");
						period = gen.nextInt();
						if (period == 1)
						{
							time.setAMorPM("am");
							endTime.setAMorPM("am");
						}
						else if (period == 2)
						{
							time.setAMorPM("pm");
							endTime.setAMorPM("pm");
						}
						else
						{
							System.out.println ("\nInvalid input!\n");
							proceed = false;
						}
						
					}
					
					if (proceed == true)
					{
						if (period == 1)
						{
							System.out.println ("\nPlease enter the hour in integer for your intended appointment time (8, 9, or 10 AM):");
							hour = gen.nextInt();
							if (hour >= 8 && hour <= 10)
							{
								time.setHour(hour);
								endTime.setHour(hour+1);
							}
							else 
							{
								System.out.println ("\nInvalid option!\n");
								proceed = false;
							}
						}
						else if (period == 2)
						{
							System.out.println ("\nPlease enter the hour in integer for your intended appointment time (12, 1, 2, 3, or 4 PM):");
							hour = gen.nextInt();
							if (hour >= 1 && hour <= 4)
							{
								time.setHour(hour);
								endTime.setHour(hour+1);
							}
							else if (hour == 12)
							{
								time.setHour(hour);
								endTime.setHour(1);
							}
							else 
							{
								System.out.println ("\nInvalid option!\n");
								proceed = false;
							}
						}
						else 
						{
							System.out.println ("\nInvalid input!\n");
							proceed = false;
						}
					}

					if (proceed == true)
					{
						System.out.println ("\nPlease include a short message about your purpose of scheduling an appointment with a doctor:");
						String anote = str.nextLine();
						String nop = p1.getName() + " (Patient)";
						Appointment app = new Appointment (time, endTime, nop, anote);
						boolean successful = doc1.addAppointment(app);
						if (successful)
						{
							anote += "  - Scheduled for Doctor " + doc1.getName();
							Appointment papp = new Appointment (time, endTime, nop, anote);
							p1.addAppointment(papp);
							System.out.println ("\nAppointment successfully scheduled! Details are as follow:\n");
							papp.printAppointment();
						}
						else 
						{
							System.out.println ("Sorry, the doctor is busy during your intended appointment time. Please try scheduling an appointment for a different time!");
						}
					}	
					else
					{
						System.out.println ("Appointment is not scheduled successfully. Please try again next time!\n"); 
					}	
				}
			}		

			else if (choice == 7)
			{
				if (p1.appointment.size() == 0)
				{
					System.out.println ("You don't have any appointments scheduled at the moment!\n");
				}
				else
				{
					p1.printPAppointment();
				}
			}

			else if (choice == 8)
			{
				if (p1.appointment.size() == 0)
				{
					System.out.println ("You don't have any appointments scheduled at the moment!\n");
				}
				else
				{
					p1.printPAppointment();
					System.out.println ("Please select a past appointment record to be deleted:");
					int pa = gen.nextInt();
					if (pa > p1.appointment.size() || pa < 1)
					{
						System.out.println ("\nThe appointment record you entered could not be found!\n");
					}
					else
					{
						p1.appointment.remove(pa-1);
						System.out.println ("\nThe appointment record was deleted successfully!\n");
					}
				}
			}
			else if (choice == 9)
			{
				System.out.println ("Thank you for your time. Have a good day!");
				keep_going = false;
			}
			else
			{
				System.out.println ("Not a valid choice! Please try again.\n");
			}
		}
	}

	public String findDay(int day, int month, int year)
	{
		String nday [] = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		int monthKeyNo[] = { 0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};
		int centuryValue = 6;
		System.out.println ("Century Value = " + centuryValue);
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
}
