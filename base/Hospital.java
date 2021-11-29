import java.io.*;
import java.lang.*;
import java.util.Scanner;
import java.util.Vector;

public class Hospital implements Serializable{

	public static Vector<Doctor> doc = new Vector<Doctor>();
	public static Vector<Nurse> nur = new Vector<Nurse>();
	public static Vector<FrontDesk> fd = new Vector<FrontDesk>();
	public static Vector<Patient> pt = new Vector<Patient>();

	public static void main (String[] args)
	{
		Hospital account = new Hospital();
		doc.add(addDoctor());
		//saveDoctor(doc.get(0));
		saveDoctorA();
		loadDoctor();
		Doctor doc2 = new Doctor ();
		for (int i = 0; i<doc.size(); i++)
		{
			doc2 = doc.get(i);
			System.out.println (doc2.getUsername() + " " + doc2.getPassword() + " " + doc2.getName() + "\n");
		}
		//doc2 = doc.get(0);
		//doc2.setNotification("Meeting at 1pm");
		//doc2.setNotification("Appointment at 3pm");		
		//doc2.readNotification();
		//saveDoctor(doc2);
		//DoctorMainMenu mmd = new DoctorMainMenu (doc2);
		account.main_menu();
	}

	public Hospital ()
	{
		loadDoctor();
	}

	@SuppressWarnings("unchecked")
	public static void loadDoctor()
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

	public static void saveDoctorA()
	{
		try{
                FileOutputStream doc_file = new FileOutputStream("Doctors.dat");
                ObjectOutputStream out = new ObjectOutputStream(doc_file);
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
	
	/*public static Nurse addNurse (String username, String password, String name)
	{

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
	}*/

	public void main_menu()
	{
		int type;
		Scanner input4 = new Scanner (System.in);
		System.out.println ("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
		System.out.println ("Welcome to CSCI240 Hospital System!\n");	
		System.out.println ("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
		boolean not_valid = true;
		//while (not_valid)
		do
		{
			System.out.println ("Please select your User Type:\n");
			System.out.println ("1. Doctor\n2. Nurse\n3. Front Desk\n4. Patient");
			type = input4.nextInt();
			if (type == 1 || type == 2 || type == 3 || type == 4)
			{
				not_valid = false;
			}
			else 			
			{
				System.out.println ("That is not a valid choice. Please try again!");
			}
		} while (not_valid);
		System.out.println ("What do you want to do?:\n");
		System.out.println ("1. Log in to an existing account\n2. Create a new account\n"); 
		Scanner input5 = new Scanner (System.in);
		Scanner input6 = new Scanner (System.in);
		Scanner input7 = new Scanner (System.in);
		int choice = input5.nextInt();	
		boolean keep_going = true;
		boolean uexist = false;
		if (choice == 1)
		{
			System.out.println ("Welcome back! Please enter your username:\n");
			String un = input6.nextLine();
			System.out.println ("\nPlease enter your password:\n");
			String pw = input7.nextLine();
			if (type == 1)
			{
				for (int i = 0; i < doc.size(); i++)
				{
					Doctor doc1 = new Doctor();
        	     			doc1 = doc.get(i);
                 			String une = doc1.getUsername();
                        		String pwd = doc1.getPassword();
					if(un == une)
					{
       	        				if (pw == pwd)
						{
							uexist = true;
							System.out.println("Hello Doctor!");
							DoctorMainMenu dmm = new DoctorMainMenu (doc1);
							System.exit(0);	
						}
						else 
						{
							System.out.println ("Sorry, wrong password.Try again next time!");
							System.exit(0);
						}
               				}
						
					else 
					{
						System.out.println ("Sorry, we cannot find an account that matches your credentials! Try again next time!");
						System.exit(0);
					}
				}
			}
			

			/*else if (type == 2)
			{
				for (int i = 0; i < nur.size(); i++)
				{       
					Nurse nur1 = new Nurse();
                                        nur1 = nur.get(i);
                                        String une = nur1.getUsername();
                                        String pwd = nur1.getPassword();
                                        if(un == une)
                                        {
                                        	if (pw == pwd)
						{
							uexist = true;
							System.out.println (Hello Nurse!");
							NurseMainMenu(nur1);
                                                        exit(0);
						}
                                                else
                                                {
							System.out.println ("Sorry, wrong password.Try again next time!");
                                                        exit(0);
                                                }
					}

                                        else
                                        {
                        	                System.out.println ("Sorry, we cannot find an account that matches your credentials! Try again next time!");
                                                exit(0);
                                        }
				}
			}

			else if (type == 3)
			{
				for (int i = 0; i < fd.size(); i++)
                                {
                                	FrontDesk fd1 = new FrontDesk();
                                        fd1 = fd.get(i);
                                        String une = fd1.getUsername();
                                        String pwd = fd1.getPassword();
                                        if(un == une)
                                        {
                                        	if (pw == pwd)
                                                {
                                                	uexist = true;
                                                       	System.out.println ("Hello Front Desk!");
                                                       	FrontDeskMainMenu(fd1);
                                                       	exit(0);
						}
                                                else
                                                {
                                	                System.out.println ("Sorry, wrong password.Try again next time!");
                                                        exit(0);
                                                }
					}

                                        else
                                        {
                                                System.out.println ("Sorry, we cannot find an account that matches your credentials! Try again next time!");
                                                exit(0);
                                        }
				}
			}

			else 
			{
				for (int i = 0; i < fd.size(); i++)
                                {
                                	Patient pt1 = new Patient();
                                        pt1 = pt.get(i);
                                        String une = pt1.getUsername();
                                        String pwd = pt1.getPassword();
                                        if(un == une)
                                        {
						if (pw == pwd)
						{
							uexist = true;
							System.out.println ("Hello Front Patient!");
                                                        PatientMainMenu();
                                                        exit(0);
                                                }
                                                else
                                                {
                                                        System.out.println ("Sorry, wrong password.Try again next time!");
                                                        exit(0);
                                                }
					}

                                        else
                                        {
                                                System.out.println ("Sorry, we cannot find an account that matches your credentials! Try again next time!");
                                                exit(0);
                                        }
				}

			}*/
		}

		else if (choice == 2)
		{
			if (type == 1)
			{
				doc.add(addDoctor());
				System.out.println ("\nWelcome to the CSCI Hospital, Doctor!\n");
				DoctorMainMenu dmm = new DoctorMainMenu();
				//DoctorMainMenu();
			}
			/*else if (type == 2)
			{
				addNurse();
				System.out.println ("\nWelcome to the CSCI Hospital, Nurse!\n");                                       
				NurseMainMenu();
			}
			else if (type == 3)
			{
				addFrontDesk();
				System.out.println ("\nWelcome to the CSCI Hospital, FrontDesk!\n");                              
				FrontDeskMainMenu();
			}
			else
			{
				addPatient();
				System.out.println ("\nWelcome to the CSCI Hospital, Patient!\n");               
				PatientMainMenu();
			}*/
		}

		else 
		{
			System.out.println ("Not a valid option. Please try again next time!");
		}
	}
	
}
