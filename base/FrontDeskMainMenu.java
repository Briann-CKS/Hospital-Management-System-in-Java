import java.util.Formatter;
import java.io.*;
import java.lang.*;
import java.util.Scanner;
import java.util.Vector;
import java.util.*;

public class FrontDeskMainMenu implements Serializable {

	public static void main (String args[])
	{
		new FrontDeskMainMenu ();
	}

	public FrontDeskMainMenu() {
	}

	public FrontDeskMainMenu (FrontDesk fd1)
	{
		boolean keep_going = true;
		System.out.println ("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
		System.out.println ("Welcome to the Front Desk Menu!\n");
		System.out.println ("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");

		while (keep_going)
		{
			System.out.println ("Please enter your choice: \n");
			//System.out.println ("1. Read Notification\n2. Delete a notification\n3. View A Patient's Info\n4. Make diagnosis for a patient\n5. Set prescriptions for a patient\n6. Write a note to the nurse\n7. Sign out\n");
			Scanner input = new Scanner(System.in);
			int choice  = input.nextInt();
			if (choice == 1)
			{
				keep_going = false;
			}
			else if (choice == 2)
			{
				keep_going = false;
			}
			else if (choice == 3)
			{
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
				//saveUser();
			}
			else
			{
				System.out.println ("Not a valid choice! Please try again.\n");
			}


		}
	}

	/*public void listPatient()
	{
		Formatter f = new Formatter();
		System.out.println (f.format("%05s %15s %25s", "No.", "Username", "Full Name")); 
		for (int i = 0; i < pt.size(); i++)	
		{
			f = new Formatter();
			System.out.println (f.format("%05s %15s %25s", i+1 + ")", pt.get(i).getUsername(), pt.get(i).getName()));
		}
	}*/
}