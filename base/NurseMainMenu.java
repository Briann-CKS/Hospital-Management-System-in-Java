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
			System.out.println ("1. Read Note\n2. Delete a note\n3. List Patient\n4. View A Patient's Info\n5. Get prescription of a patient\n6. Sign out\n"); //View appointment dates
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
}
