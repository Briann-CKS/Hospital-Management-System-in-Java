import java.io.*;
import java.util.Scanner;
import java.util.Vector;
import java.util.Formatter;

public class DoctorMainMenu implements Serializable {

	Scanner gen = new Scanner (System.in);

	public static void main (String args[])
	{
		new DoctorMainMenu ();
	}

	public DoctorMainMenu() {
	}

	public DoctorMainMenu (Doctor d1, Vector nurse, Vector frontd, Vector pat)
	{
		boolean keep_going = true;
		System.out.println ("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
		System.out.println ("Welcome to the Doctor Menu!\n");
		System.out.println ("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");

		while (keep_going)
		{
			System.out.println ("Please enter your choice: \n");
			System.out.println ("1. Read Notification\n2. Delete a notification\n3. View A Patient's Info\n4. Make diagnosis for a patient\n5. Set prescriptions for a patient\n6. Write a note to the nurse\n7. Sign out\n");
			Scanner input = new Scanner(System.in);
			int choice  = input.nextInt();
			if (choice == 1)
			{
				d1.readNotification();
				if (d1.notification.size() > 10)
				{
					System.out.println ("Looks like you have quite a few notifications stored in your account. Clearing some old messages will help you organize better!\n");
				}			
			}
			else if (choice == 2)
			{
				d1.readNotification();
				System.out.println("Please select a message to be deleted.");
				Scanner input1 = new Scanner (System.in);
				int num = input1.nextInt();
				d1.deleteNotification(num);
			}
			else if (choice == 3)
			{
				Formatter f = new Formatter();
				System.out.println (f.format("%-5s%-20s%-30s", "No.", "Username", "Full Name")); 
				for (int i = 0; i < pat.size(); i++)	
				{
					f = new Formatter();
					System.out.println (f.format("%-5s%-20s%-30s", i+1 + ")", pat.get(i).getUsername(), pat.get(i).getName()));
				}

				System.out.println ("\nWhich patient info would you like to view?\n");
				int num = gen.nextInt();
				System.out.println ("Name: " + pat.get(num-1).getName());
				if (pat.get(num-1).getDiagnosis().equals(""))
				{
					System.out.println ("Diagnosis: " + "None at the moment");
				}
				else
				{
					System.out.println ("Diagnosis: " + pat.get(num-1).getDiagnosis());
				}
				if (pat.get(num-1).getPrescription().equals(""))
				{
					System.out.println ("Past Prescriptions: " + "None at the moment");
				}
				else
				{
					System.out.println ("Past Prescriptions: " + pat.get(num-1).getPrescription());
				}	
				System.out.println ("");
			}
			else if (choice == 4)
			{
				keep_going = true;
	
			}
			else if (choice == 5)
			{
				keep_going = true;

			}
			else if (choice == 6)
			{
				keep_going = true;	

			}
			else if (choice == 7)
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

}
