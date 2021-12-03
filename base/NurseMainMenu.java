import java.io.*;
import java.util.Scanner;
import java.util.Vector;
import java.util.Formatter;

public class NurseMainMenu implements Serializable {

	Scanner gen = new Scanner (System.in);
	Doctor doc1 = new Doctor();
	Nurse nur1 = new Nurse();
	FrontDesk fd1 = new FrontDesk();
	Patient pt1 = new Patient();

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
			System.out.println ("1. Read Note\n2. Delete a note\n3. List Patient\n4. View A Patient's Info\n5. Write a note to an admin\n6. Sign out\n"); //View appointment dates
			int choice = gen.nextInt();
			if (choice == 1)
			{
				n1.readNote();
				if (n1.note.size() > 10)
				{
					System.out.println ("Looks like you have quite a few notes stored in your account. Clearing some old notes will help you organize better!\n");
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
				keep_going = false;
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

	public void viewPatientInfo(Vector p)
	{		
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
