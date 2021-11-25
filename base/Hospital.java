import java.io.*;
import java.util.Scanner;
import java.util.Vector;

@SuppressWarnings("serial")
public class Hospital implements Serializable{

	public static Vector<Doctor> doc = new Vector<Doctor>();
	public static Vector<Nurse> nur = new Vector<Nurse>();
	public static Vector<FrontDesk> fd = new Vector<FrontDesk>();
	//public static Vector<Patient> pt = new Vector<Patient>();

	public static void main (String[] args)
	{
		Hospital account = new Hospital();
		Doctor doc1 = new Doctor();
		//doc1 = addDoctor();
		//doc.add(doc1);
		//doc.add(addDoctor("brcheong", "CSCI240", "Brian"));
		Doctor doc2 = new Doctor ();
		for (int i = 0; i<doc.size(); i++)
		{
			doc2 = doc.get(i);
			System.out.println (doc2.getUsername() + " " + doc2.getPassword() + " " + doc2.getName() + "\n");
		}
		doc2 = doc.get(1);
		//doc2.setNotification("Meeting at 1pm");
		//doc2.setNotification("Appointment at 3pm");		
		doc2.readNotification();
		//saveDoctor(doc2);
		//DoctorMainMenu mmd = new DoctorMainMenu (doc2);
		//this.main_menu();
	}

	public Hospital ()
	{
		loadDoctor();
	}

	@SuppressWarnings("unchecked")
	public void loadDoctor()
	{
		try{
		FileInputStream doc_file = new FileInputStream("Doctors.dat");
		ObjectInputStream inputD = new ObjectInputStream(doc_file);
		doc = (Vector) inputD.readObject();
		inputD.close();
		} catch (IOException e) {
			System.out.println (e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println (e.getMessage());
		}
	}

	public static void saveDoctor (Doctor d)
	{
		try{
                FileOutputStream doc_file = new FileOutputStream("Doctors.dat");
                ObjectOutputStream out = new ObjectOutputStream(doc_file);
                for(int i=0; i<doc.size(); i++)
		{
              		Doctor doc1 = new Doctor();
        	     	doc1 = doc.get(i);
                 	String un = doc1.getUsername();
                        String pw = doc1.getPassword();
			if(d.getUsername() == un)
			{
        	        	doc.set(i, d);
				break;
                	}
		}
		out.writeObject(doc);
                out.close();
                doc_file.close();
		} catch(Exception e){
                        System.out.println(e.getMessage());
                }
	}
	
	//public static Doctor addDoctor (String username, String password, String name)
	public static Doctor addDoctor()
	{
		String username;
		String password;
		String name;
		boolean not_exist = true;
		Doctor doc1 = new Doctor ();
		Doctor doc2 = new Doctor ();
		boolean keep_going = true;
		while (keep_going)
		{
			System.out.println("\nPlease enter a username:");
			Scanner input1 = new Scanner (System.in);
			String untry = input1.nextLine();
			for (int i = 0; i< doc.size(); i++)
			{
				doc2 = doc.get(i);
				if (doc2.getUsername() == untry)
				{
					not_exist = false;
					System.out.println("\n\nFALSE\n\n");
				}	
			}
			if (not_exist == false)
			{
				System.out.println("\nSorry, this username has been used. Please try another username!");
			}
			else	
			{
				doc1.setUsername(untry);
				keep_going = false;
			}
		}

		keep_going = true;
		not_exist = true;
		while (keep_going)
		{
			System.out.println("\nPlease enter a password:");
			Scanner input2 = new Scanner (System.in);
			String pwtry = input2.nextLine();
			for (int i = 0; i< doc.size(); i++)
			{
				doc2 = doc.get(i);
				if (doc2.getPassword() == pwtry)
				{
					not_exist = false;
				}	
			}
			if (not_exist == false)
			{
				System.out.println("\nSorry, this password has been used. Please try another password!");
			}
			else	
			{
				doc1.setPassword(pwtry);
				keep_going = false;
			}
		}

		System.out.println("\nPlease enter your Full Name:");
		Scanner input3 = new Scanner (System.in);
		name = input3.nextLine();	
		doc1.setName(name);
		return doc1;
	}
	
	public static Nurse addNurse (String username, String password, String name)
	{
		Nurse nur1 = new Nurse ();
		nur1.setUsername(username);
		nur1.setPassword(password);
		nur1.setName(name);
		return nur1;
	}

	public static FrontDesk addFrontDesk (String username, String password, String name)
	{
		FrontDesk fd1 = new FrontDesk ();
		fd1.setUsername(username);
		fd1.setPassword(password);
		fd1.setName(name);
		return fd1;
	}

	public static Patient addPatient (String username, String password, String name)
	{
		Patient p1 = new Patient ();
		p1.setUsername(username);
		p1.setPassword(password);
		p1.setName(name);
		return p1;
	}

	public void main_menu()
	{
		Scanner input4 = new Scanner (System.in);
		System.out.println ("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
		System.out.println ("Welcome to CSCI240 Hospital System!\n");	
		System.out.println ("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
		boolean not_valid = true;
		while (not_valid)
		{
			System.out.println ("Please select your User Type:\n");
			System.out.println ("1. Doctor\n2. Nurse\n3. Front Desk\n4. Patient");
			int type = input4.nextInt();
			if (type == 1 || type == 2 || type == 3 || type == 4)
			{
				not_valid = false;
			}
			else 			
			{
				System.out.println ("That is not a valid choice. Please try again!");
				continue;
			}
		}
		System.out.println ("What do you want to do?:\n");
		System.out.println ("1. Log in to an existing account\n2. Create a new account\n"); 
		Scanner input5 = new Scanner (System.in);
		int choice = input5.nextInt();	
		boolean keep_going = true;
		while (keep_going)	
		{
			if (choice == 1)
			{
				keep_going = false;
			}

			else if (choice == 2)
			{
				keep_going = false;
			}

			else 
			{
				System.out.println ("Not a valid option. Please try again!");
				continue;
			}
		}
	}
}
