import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class NurseMainMenu implements Serializable {

	public static void main (String args[])
	{
		new NurseMainMenu();
	}

	public NurseMainMenu(){
	}

	public NurseMainMenu(Nurse n1)
	{
		boolean keep_going = true;
		System.out.println ("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
		System.out.println ("Welcome to the Nurse Menu!\n");
		System.out.println ("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");

		while (keep_going)
		{
			System.out.println ("Please enter your choice: \n");
			System.out.println ("1. Read Note\n2. Delete a note\n3. List Patient\n4. View A Patient's Info\n5. Get prescription of a patient\n6. Sign out\n"); //View appointment dates
			Scanner input = new Scanner (System.in);
			int choice = input.nextInt();
			if (choice == 1)
			{
				Nurse n = new Nurse();
				n = n1;
				n.readNote();
				if (n.note.size() > 10)
				{
					System.out.println ("Looks like you have quite a few notes stored in your account. Clearing some old notes will help you organize better!\n");
				}
			}
			else if (choice == 2)
			{
				Nurse n = new Nurse();
				n = n1;
				n.readNote();
				System.out.println("Please select a message to be deleted.");
				Scanner input1 = new Scanner (System.in);
				int num = input1.nextInt();
				n.deleteNote(num);
			}
			else if (choice == 3)
			{
				keep_going = true;

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
				System.out.println ("Thank you for your time. Have a good day!");
				keep_going = false;
				//saveNurse(n1);
			}
			else
			{
				System.out.println ("Not a valid choice! Please try again.\n");
			}

		}
	}
}
