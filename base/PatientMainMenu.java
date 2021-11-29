import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class PatientMainMenu implements Serializable {

	public static void main (String args[])
	{
		new PatientMainMenu ();
	}

	public PatientMainMenu() {
	}

	public PatientMainMenu (Patient p1)
	{
		Scanner input = new Scanner(System.in);
		boolean keep_going = true;
		System.out.println ("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
		System.out.println ("Welcome to the Patient Menu!\n");
		System.out.println ("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");

		while (keep_going)
		{
			System.out.println ("Please enter your choice: \n");
			System.out.println ("1. Get Diagnosis\n2. Get Prescription\n3. Pay Medical Bill\n4. \n5. Set prescriptions for a patient\n6. Write a note to the nurse\n7. Sign out\n");
			int choice  = input.nextInt();
			if (choice == 1)
			{
				System.out.println("Here is the diagnosis given by your doctor:\n");
				System.out.println(p1.printDiagnosis()+ "\n");
			}
			else if (choice == 2)
			{
				System.out.println("Here are your prescriptions:\n");
				//System.out.println(p1.printPrescription() + "\n");	
			}

			else if (choice == 3)
			{
				p1.paymedical_bill();
				keep_going = false;
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
