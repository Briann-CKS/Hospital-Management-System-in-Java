import java.io.*;
import java.lang.*;
import java.util.Scanner;
import java.util.Vector;

public class Hospital implements Serializable{

	public static Vector<Doctor> doc = new Vector<Doctor>();
	public static Vector<Nurse> nur = new Vector<Nurse>();
	public static Vector<FrontDesk> fd = new Vector<FrontDesk>();
	public static Vector<Patient> pt = new Vector<Patient>();
	Doctor doc1 = new Doctor();
	Doctor doc2 = new Doctor();


	public static void main (String[] args)
	{
		Hospital account = new Hospital();
		//doc.add(addDoctor());
		//saveDoctor(doc.get(0));
		//saveDoctorA();
		//loadDoctor();
		//saveDoctorA();
		//Doctor doc2 = new Doctor ();
		//doc2 = doc.get(0);
		//doc2.setNotification("Meeting at 1pm");
		//doc2.setNotification("Appointment at 3pm");		
		//account.main_menu();
	}

	public Hospital ()
	{
		loadUser();
		//doc.add(addDoctor());
		//System.out.println(doc.get(1).getUsername());
		//doc.get(0).setNotification("Appointment at 1pm");
		//doc.get(0).readNotification();
		//saveDoctor();
		this.main_menu();
		//saveDoctorA();
	}

	@SuppressWarnings("unchecked")
	public void loadUser()
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
	
		/*try{
		FileInputStream nur_file = new FileInputStream("Nurses.dat");
		ObjectInputStream inputN = new ObjectInputStream(nur_file);
		nur = (Vector) inputN.readObject();
		inputN.close();
		} catch (IOException e) {
			System.out.println (e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println (e.getMessage());
		}
	
		try{
		FileInputStream fd_file = new FileInputStream("FrontDesks.dat");
		ObjectInputStream inputF = new ObjectInputStream(fd_file);
		fd = (Vector) inputF.readObject();
		inputF.close();
		} catch (IOException e) {
			System.out.println (e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println (e.getMessage());
		}
	
		try{
		FileInputStream pt_file = new FileInputStream("Patients.dat");
		ObjectInputStream inputP = new ObjectInputStream(pt_file);
		pt = (Vector) inputP.readObject();
		inputP.close();
		} catch (IOException e) {
			System.out.println (e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println (e.getMessage());
		}*/
	}

	/*public void saveDoctor (Doctor d)
	{
		try{
                FileOutputStream doc_file = new FileOutputStream("Doctors.dat");
                ObjectOutputStream out = new ObjectOutputStream(doc_file);
                for(int i=0; i<doc.size(); i++)
		{
              		//Doctor doc1 = new Doctor();
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
	}*/

	public void saveDoctor()
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

	public void saveNurse()
	{
		try{
                FileOutputStream nur_file = new FileOutputStream("Nurses.dat");
                ObjectOutputStream out = new ObjectOutputStream(nur_file);
                out.writeObject(nur);
                out.close();
                nur_file.close();
                } catch(Exception e){
                        System.out.println(e.getMessage());
                }
	}

	public void saveFrontDesk()
	{
		try{
                FileOutputStream fd_file = new FileOutputStream("FrontDesks.dat");
                ObjectOutputStream out = new ObjectOutputStream(fd_file);
                out.writeObject(fd);
                out.close();
                fd_file.close();
                } catch(Exception e){
                        System.out.println(e.getMessage());
                }
	}

	public void savePatient()
	{
		try{
                FileOutputStream pt_file = new FileOutputStream("Patients.dat");
                ObjectOutputStream out = new ObjectOutputStream(pt_file);
                out.writeObject(pt);
                out.close();
                pt_file.close();
                } catch(Exception e){
                        System.out.println(e.getMessage());
                }
	}
	
	public Doctor addDoctor()
	{
		String username;
		String password;
		String name;
		boolean not_exist = true;
		boolean keep_going = true;
		Scanner input1 = new Scanner (System.in);
		while (keep_going)
		{
			not_exist = true;
			System.out.println("\nPlease enter a username:");
			String untry = input1.nextLine();
			for (int i = 0; i< doc.size(); i++)
			{
				if (untry.equals(doc.get(i).getUsername()))
				{
					not_exist = false;
					break;
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
		while (keep_going)
		{
			not_exist = true;	
			System.out.println("\nPlease enter a password:");
			String pwtry = input1.nextLine();
			for (int i = 0; i< doc.size(); i++)
			{
				if (pwtry.equals(doc.get(i).getPassword()))
				{
					not_exist = false;
					break;
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
		name = input1.nextLine();	
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
			System.out.println (doc.get(1).getUsername() + " " + doc.get(1).getPassword() + " " + un + " " + pw);
			/*if (type == 1)
			{
				for (int i = 0; i < doc.size(); i++)
				{
					//Doctor doc1 = new Doctor();
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
			}*/

			

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
