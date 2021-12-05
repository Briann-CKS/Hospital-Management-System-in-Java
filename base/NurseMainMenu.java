import java.io.*;
import java.util.Scanner;
import java.util.Vector;
import java.util.Formatter;

public class NurseMainMenu implements Serializable {

	private Doctor doc1 = new Doctor();
	private Nurse nur1 = new Nurse();
	private FrontDesk fd1 = new FrontDesk();
	private Patient pt1 = new Patient();
	Scanner str = new Scanner (System.in);
	Scanner gen = new Scanner (System.in);
	

	public static void main (String args[])
	{
		new NurseMainMenu();
	}

	public NurseMainMenu(){
	}

	public NurseMainMenu(Nurse n1, Vector d, Vector n, Vector f, Vector p)
	{
		boolean keep_going = true;
		System.out.println ("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
		System.out.println ("Welcome to the Nurse Menu!\n");
		System.out.println ("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");

		while (keep_going)
		{
			System.out.println ("Please enter your choice: \n");
			System.out.println ("1. Read Notification\n2. Delete a Notification\n3. List Patient\n4. View A Patient's Info\n5. Write a note to an admin\n6. Sign out\n"); //View appointment dates
			int choice = gen.nextInt();
			if (choice == 1)
			{
				if (n1.note.size() == 0)
				{
					System.out.println ("\nYou don't have any new messages at the moment.\n");
				}
				else
				{
					n1.readNote();
				}
			}
			else if (choice == 2)
			{
				n1.readNote();
				System.out.println("Please select a message to be deleted.");
				int num = gen.nextInt();
				n1.deleteNote(num);
			}
			else if (choice == 3)
			{
				listPatient (p);
			}
			else if (choice == 4)
			{
				viewPatientInfo(p);	
			}
			else if (choice == 5)
			{
				String not;
				System.out.println ("Which type of admin do you want to send a note to?\n");
				System.out.println ("1. Doctor\n2. Nurse\n3. Front Desk\n");
				int type = gen.nextInt();
				if (type == 1)
				{
					listDoctor(d);
					System.out.println ("\nPlease select a doctor:");
					int ch = gen.nextInt();
					if (ch > d.size())
                                	{
                                        	System.out.println ("\nSorry, no doctor found for the number you entered!\n");
                                	}
                                	else
                                	{
						doc1 = (Doctor) d.get(ch-1);
						System.out.println ("Please enter the note you want to send to " + doc1.getName() + ":");
						not = str.nextLine();
						not = not + "	- from Nurse " + n1.getName();
						doc1.setNotification(not);
						System.out.println ("\nYour note was sent successfully!\n");
					}	
				} 
				else if (type == 2)
				{
					listNurse(n);
                                        System.out.println ("\nPlease select a nurse:");
                                        int ch = gen.nextInt();
					if (ch > n.size())
                                	{
                                	        System.out.println ("\nSorry, no nurse found for the number you entered!\n");
                                	}
                                	else
                                	{
						nur1 = (Nurse) n.get(ch-1);
						System.out.println ("Please enter the note you want to send to " + nur1.getName() + ":");
                                        	not = str.nextLine();
                                        	not = not + "	- from Nurse " + n1.getName();
						nur1.setNote(not);
                                        	System.out.println ("\nYour note was sent successfully!\n");	
					}
				}
				else if (type == 3)
				{
					listFrontDesk(f);
                                        System.out.println ("\nPlease select a front desk:");
                                        int ch = gen.nextInt();
					if (ch > f.size())
                                	{
                                	        System.out.println ("\nSorry, no front desk found for the number you entered!\n");
                                	}
                                	else
                                	{
						fd1 = (FrontDesk) f.get(ch-1);
						System.out.println ("Please enter the note you want to send to " + fd1.getName() + ":");
                                        	not = str.nextLine();
						not = not + "	- from Nurse " + n1.getName();
                                        	fd1.setMemo(not);
                                        	System.out.println ("\nYour note was sent successfully!\n");	
					}
				}
				else
				{
					System.out.println ("\nNot a valid choice! Try again next time.\n");
				}
			}
			else if (choice == 6)
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

	public void listPatient(Vector p)
	{
		Formatter fo = new Formatter();
		System.out.println (fo.format("%-5s%-15s%-22s", "No.", "Username", "Full Name")); 
		for (int i = 0; i < p.size(); i++)	
		{
			fo = new Formatter();
			pt1 = (Patient) p.get(i);
			System.out.println (fo.format("%-5s%-15s%-22s", i+1 + ")", pt1.getUsername(), pt1.getName()));
		}
		System.out.println ("");
	}

	public void listNurse (Vector n)
	{
		System.out.println ("Nurses");
		Formatter fo = new Formatter();
		System.out.println (fo.format("%-5s%-15s%-22s", "No.", "Username", "Full Name")); 
		for (int i = 0; i < n.size(); i++)	
		{
			nur1 = (Nurse) n.get(i);
			fo = new Formatter();
			System.out.println (fo.format("%-5s%-15s%-22s", i+1 + ")", nur1.getUsername(), nur1.getName()));
		}	
		System.out.println ("");
	}

	public void listDoctor (Vector d)
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
		System.out.println ("");
	}

	public void listFrontDesk(Vector f)
	{
		System.out.println ("Front Desks");
		Formatter fo = new Formatter();
		System.out.println (fo.format("%-5s%-15s%-22s", "No.", "Username", "Full Name")); 
		for (int i = 0; i < f.size(); i++)	
		{
			fo = new Formatter();
			fd1 = (FrontDesk) f.get(i);
			System.out.println (fo.format("%-5s%-15s%-22s", i+1 + ")", fd1.getUsername(), fd1.getName()));
		}
		System.out.println ("");
	}

	public void viewPatientInfo(Vector p)
	{	
		listPatient(p);	
		System.out.println ("\nWhich patient info would you like to view?");
		int choice = gen.nextInt();
		pt1 = (Patient) p.get(choice-1);
		System.out.println ("Name: " + pt1.getName());
		if (pt1.getDiagnosis().equals(""))
		{
			System.out.println ("Diagnosis: " + "None at the moment");
		}
		else
		{
			System.out.println ("Diagnosis: " + pt1.getDiagnosis());
		}
		if (pt1.getPrescription().equals(""))
		{
			System.out.println ("Past Prescriptions: " + "None at the moment");
		}
		else
		{
			System.out.println ("Past Prescriptions: " + pt1.getPrescription());
		}	
		System.out.println (""); 
	}
}
