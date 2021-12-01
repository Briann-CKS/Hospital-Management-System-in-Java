import java.io.*;
import java.lang.*;
import java.util.Scanner;
import java.util.Vector;
import java.util.Formatter;
import java.util.*;

public class FrontDeskMainMenu implements Serializable {

	Scanner gen = new Scanner (System.in);
	Doctor doc1 = new Doctor();
	Nurse nur1 = new Nurse();
	FrontDesk fd1 = new FrontDesk();
	Patient pt1 = new Patient();

	public static void main (String args[])
	{
		new FrontDeskMainMenu ();
	}

	public FrontDeskMainMenu() {
	}

	public FrontDeskMainMenu (FrontDesk fd1, Vector d, Vector n, Vector f, Vector p)
	{
		boolean keep_going = true;
		System.out.println ("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
		System.out.println ("Welcome to the Front Desk Menu!\n");
		System.out.println ("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");

		while (keep_going)
		{
			System.out.println ("Please enter your choice: \n");
			System.out.println ("1. Read Memo\n2. Add Memo\n3. Delete Memo\n4. List all Patients\n5. List all Admins\n6. View A Patient's Info\n7. Set Medical Bill for a Patient\n8. Write a note to an Admin\n9. Add a Patient\n7. Add an Admin\n8. Delete a Patient\n9. Delete an Admin\n10. Sign out\n");
			int choice  = gen.nextInt();
			if (choice == 1)
			{
				fd1.readMemo();
				keep_going = false;
			}
			else if (choice == 2)
			{
				System.out.println ("\nWhat do you want to add to your memo?");
				String str = gen.nextLine();
				fd1.setMemo(str);
				System.out.println ("\nMemo successfully added!\n");
			}
			else if (choice == 3)
			{
				fd1.readMemo();
				System.out.println ("\nWhich string do you want to delete from your memo?");
				int num = gen.nextInt();
				fd1.deleteMemo(num);
			}
			else if (choice == 4)
			{	
				listPatient(p);
			}
			else if (choice == 5)
			{
				listAdmin (d, n, f);
			}
			else if (choice == 6)
			{
				listPatient(p);
				viewPatientInfo(p);	
			}
			else if (choice == 7)
			{
				listPatient(p);
				System.out.println ("\nPick a patient to update his/her medical bill:\n");
				int num = gen.nextInt();
				pt1 = (Patient) p.get(num-1); 
				System.out.println ("\nWhat is the amount you want to add to " + pt1.getName() + "'s medical bill?\n");	
				float amount = gen.nextFloat();
				pt1.addBill(amount);
				//System.out.println ("\nSuccessfully added $" + amount + " to " + pt1.getName() + "'s medical bill.\n");
			}
			else if (choice == 8)
			{
				keep_going = false;
			}
			else if (choice == 9)
			{
				keep_going = false;
			}
			else if (choice == 10)
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
		System.out.println (fo.format("%05s %15s %25s", "No.", "Username", "Full Name")); 
		for (int i = 0; i < p.size(); i++)	
		{
			fo = new Formatter();
			pt1 = (Patient) p.get(i);
			System.out.println (fo.format("%05s %15s %25s", i+1 + ")", pt1.getUsername(), pt1.getName()));
		}
	}

	public void listAdmin (Vector d, Vector n, Vector f)
	{
		System.out.println ("\nDoctors\n");
		Formatter fo = new Formatter();
		System.out.println (fo.format("%-5s%-20s%-30s%-15s", "No.", "Username", "Full Name", "Specialty")); 
		for (int i = 0; i < d.size(); i++)	
		{
			doc1 = (Doctor) d.get(i);
			fo = new Formatter();
			System.out.println (fo.format("%-5s%-20s%-30s%-15s", i+1 + ")", doc1.getUsername(), doc1.getName(), doc1.getSpecialty()));
		}

		System.out.println ("\nNurses\n");
		fo = new Formatter();
		System.out.println (fo.format("%-5s%-20s%-30s", "No.", "Username", "Full Name")); 
		for (int i = 0; i < n.size(); i++)	
		{
			nur1 = (Nurse) n.get(i);
			fo = new Formatter();
			System.out.println (fo.format("%-5s%-20s%-30s", i+1 + ")", nur1.getUsername(), nur1.getName()));
		}	
		
		System.out.println ("\nFront Desks\n");
		fo = new Formatter();
		System.out.println (fo.format("%-5s%-20s%-30s", "No.", "Username", "Full Name")); 
		for (int i = 0; i < f.size(); i++)	
		{
			fd1 = (FrontDesk) f.get(i);
			fo = new Formatter();
			System.out.println (fo.format("%-5s%-20s%-30s", i+1 + ")", fd1.getUsername(), fd1.getName()));
		}


	}

	public void viewPatientInfo(Vector p)
	{		
		System.out.println ("\nWhich patient info would you like to view?\n");
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
