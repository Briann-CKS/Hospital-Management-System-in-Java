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
		boolean keep_going = true;
		System.out.println ("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
		System.out.println ("Welcome to the Patient Menu!\n");
		System.out.println ("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");

		while (keep_going)
		{
			System.out.println ("Please enter your choice: \n");
			System.out.println ("1. Get Diagnosis\n2. Get Prescription\n3. Pay Medical Bill\n4. \n5. Set prescriptions for a patient\n6. Write a note to the nurse\n7. Sign out\n");
			Scanner input = new Scanner(System.in);
			int choice  = input.nextInt();
			if (choice == 1)
			{
				Doctor d = new Doctor();
				d = d1;
				d.readNotification();
				if (d.notification.size() > 10)
				{
					System.out.println ("Looks like you have quite a few notifications stored in your account. Clearing some old messages will help you organize better!\n");
				}			
			}
			else if (choice == 2)
			{
