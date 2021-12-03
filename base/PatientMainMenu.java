import java.io.*;
import java.util.Scanner;
import java.util.Vector;
import java.util.Formatter;

public class PatientMainMenu implements Serializable {

	Scanner gen = new Scanner (System.in);
	Doctor doc1 = new Doctor();
	Nurse nur1 = new Nurse();
	FrontDesk fd1 = new FrontDesk();
	Patient pt1 = new Patient();

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
			System.out.println ("1. Get Diagnosis\n2. Get Prescription\n3. Pay Medical Bill\n4. \n5. Set prescriptions for a patient\n6. Write a note to the nurse\n7. Sign out\n");
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
				keep_going = false;
			}

			else if (choice == 5)
			{
				keep_going = false;
			}

			else if (choice == 6)
			{
				keep_going = false;

			}
			else if (choice == 7)
			{
				System.out.println ("Thank you for your time. Have a good day!");
				keep_going = false;
				//saveUser ();
			}
			else
			{
				System.out.println ("Not a valid choice! Please try again.\n");
			}
		}


	}

}
