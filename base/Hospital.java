import java.io.*;
import java.lang.*;
import java.util.Scanner;
import java.util.Vector;
import java.util.*;

public class Hospital implements Serializable{

	public Vector<Doctor> doc = new Vector<Doctor>();
	public Vector<Nurse> nur = new Vector<Nurse>();
	public Vector<FrontDesk> fd = new Vector<FrontDesk>();
	public Vector<Patient> pt = new Vector<Patient>();
	Doctor doc1 = new Doctor();
	Nurse nur1 = new Nurse();
	FrontDesk fd1 = new FrontDesk();
	Patient pt1 = new Patient();

	public static void main (String[] args)
	{
		Hospital account = new Hospital();
	}

	public Hospital ()
	{
		loadUser();
		this.main_menu();
		//saveDoctor();
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
	
		try{
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
		}
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

	public void saveUser()
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
	
		try{
                FileOutputStream nur_file = new FileOutputStream("Nurses.dat");
                ObjectOutputStream out = new ObjectOutputStream(nur_file);
                out.writeObject(nur);
                out.close();
                nur_file.close();
                } catch(Exception e){
                        System.out.println(e.getMessage());
                }
	
		try{
                FileOutputStream fd_file = new FileOutputStream("FrontDesks.dat");
                ObjectOutputStream out = new ObjectOutputStream(fd_file);
                out.writeObject(fd);
                out.close();
                fd_file.close();
                } catch(Exception e){
                        System.out.println(e.getMessage());
                }

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
		String name;
		boolean not_exist = true;
		boolean keep_going = true;
		Scanner input1 = new Scanner (System.in);
		while (keep_going)
		{
			not_exist = true;
			System.out.println("\nPlease enter a username:");
			String untry = input1.nextLine();
			if (compareUsername(untry) == true)
			{
				not_exist = false;
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
			if (comparePassword(pwtry))	
			{
				not_exist = false;
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
	
	public Nurse addNurse ()
	{
		String name;
		boolean not_exist = true;
		boolean keep_going = true;
		Scanner input1 = new Scanner (System.in);
		while (keep_going)
		{
			not_exist = true;
			System.out.println("\nPlease enter a username:");
			String untry = input1.nextLine();
			if (compareUsername(untry) == true)
			{
				not_exist = false;
				System.out.println("\nSorry, this username has been used. Please try another username!");
			}
			else	
			{
				nur1.setUsername(untry);
				keep_going = false;
			}
		}

		keep_going = true;
		while (keep_going)
		{
			not_exist = true;	
			System.out.println("\nPlease enter a password:");
			String pwtry = input1.nextLine();
			if (comparePassword(pwtry))	
			{
				not_exist = false;
				System.out.println("\nSorry, this password has been used. Please try another password!");
			}
			else	
			{
				nur1.setPassword(pwtry);
				keep_going = false;
			}
		}

		System.out.println("\nPlease enter your Full Name:");
		name = input1.nextLine();	
		nur1.setName(name);
		return nur1;
	}

	public FrontDesk addFrontDesk ()
	{
		String name;
		boolean not_exist = true;
		boolean keep_going = true;
		Scanner input1 = new Scanner (System.in);
		while (keep_going)
		{
			not_exist = true;
			System.out.println("\nPlease enter a username:");
			String untry = input1.nextLine();
			if (compareUsername(untry) == true)
			{
				not_exist = false;
				System.out.println("\nSorry, this username has been used. Please try another username!");
			}
			else	
			{
				fd1.setUsername(untry);
				keep_going = false;
			}
		}

		keep_going = true;
		while (keep_going)
		{
			not_exist = true;	
			System.out.println("\nPlease enter a password:");
			String pwtry = input1.nextLine();
			if (comparePassword(pwtry))	
			{
				not_exist = false;
				System.out.println("\nSorry, this password has been used. Please try another password!");
			}
			else	
			{
				fd1.setPassword(pwtry);
				keep_going = false;
			}
		}

		System.out.println("\nPlease enter your Full Name:");
		name = input1.nextLine();	
		fd1.setName(name);
		return fd1;
	}

	public Patient addPatient ()
	{
		String name;
		boolean not_exist = true;
		boolean keep_going = true;
		Scanner input1 = new Scanner (System.in);
		while (keep_going)
		{
			not_exist = true;
			System.out.println("\nPlease enter a username:");
			String untry = input1.nextLine();
			if (compareUsername(untry) == true)
			{
				not_exist = false;
				System.out.println("\nSorry, this username has been used. Please try another username!");
			}
			else	
			{
				pt1.setUsername(untry);
				keep_going = false;
			}
		}
		keep_going = true;
		while (keep_going)
		{
			not_exist = true;	
			System.out.println("\nPlease enter a password:");
			String pwtry = input1.nextLine();
			if (comparePassword(pwtry))	
			{
				not_exist = false;
				System.out.println("\nSorry, this password has been used. Please try another password!");
			}
			else	
			{
				pt1.setPassword(pwtry);
				keep_going = false;
			}
		}

		System.out.println("\nPlease enter your Full Name:");
		name = input1.nextLine();	
		pt1.setName(name);
		return pt1;
	}

	public void main_menu()
	{
		int type;
		Scanner input4 = new Scanner (System.in);
		System.out.println ("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
		System.out.println ("Welcome to CSCI240 Hospital System!\n");	
		System.out.println ("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
		boolean not_valid = true;
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
                 			String une = doc.get(i).getUsername();
                        		String pwd = doc.get(i).getPassword();
					if(un.equals(une))
					{
       	        				if (pw.equals(pwd))
						{
							uexist = true;
							System.out.println("Hello Doctor!");
							DoctorMainMenu dmm = new DoctorMainMenu (doc.get(i));
							saveUser();
							System.exit(0);	
						}
						else 
						{
							System.out.println ("Sorry, wrong password.Try again next time!");
							System.exit(0);
						}
               				}
						
				}

				if (uexist == false) 
				{
					System.out.println ("Sorry, we cannot find an account that matches your credentials! Try again next time!");
					System.exit(0);
				}
			}
		

			

			else if (type == 2)
			{
				for (int i = 0; i < nur.size(); i++)
				{       
                                        String une = nur.get(i).getUsername();
                                        String pwd = nur.get(i).getPassword();
                                        if(un.equals(une))
                                        {
                                        	if (pw.equals(pwd))
						{
							uexist = true;
							System.out.println ("Hello Nurse!");
							NurseMainMenu nmm = new NurseMainMenu(nur.get(i));
							saveUser();
                                                        System.exit(0);
						}
                                                else
                                                {
							System.out.println ("Sorry, wrong password.Try again next time!");
                                                        System.exit(0);
                                                }
					}

				}
			
				if (uexist == false);
                                {                        	                
					System.out.println ("Sorry, we cannot find an account that matches your credentials! Try again next time!");
					System.exit(0);
				}
			}


			else if (type == 3)
			{
				for (int i = 0; i < fd.size(); i++)
                                {
                                        String une = fd.get(i).getUsername();
                                        String pwd = fd.get(i).getPassword();
                                        if(un.equals(une))
                                        {
                                        	if (pw.equals(pwd))
                                                {
                                                	uexist = true;
                                                       	System.out.println ("Hello Front Desk!");
                                                       	FrontDeskMainMenu fdmm = new FrontDeskMainMenu(fd.get(i));
                                                       	System.exit(0);
						}
                                                else
                                                {
                                	                System.out.println ("Sorry, wrong password.Try again next time!");
                                                        System.exit(0);
                                                }
					}

				}                  
				if (uexist == false)
                                {                
					System.out.println ("Sorry, we cannot find an account that matches your credentials! Try again next time!");                                                
					System.exit(0);
				}
			}

			else 
			{
				for (int i = 0; i < fd.size(); i++)
                                {
                                        String une = pt.get(i).getUsername();
                                        String pwd = pt.get(i).getPassword();
                                        if(un.equals(une))
                                        {
						if (pw.equals(pwd))
						{
							uexist = true;
							System.out.println ("Hello Front Patient!");
                                                        PatientMainMenu pmm = new PatientMainMenu(pt.get(i));
                                                        System.exit(0);
                                                }
                                                else
                                                {
                                                        System.out.println ("Sorry, wrong password.Try again next time!");
                                                        System.exit(0);
                                                }
					}
				}
				if (uexist == false)
				{                                                
					System.out.println ("Sorry, we cannot find an account that matches your credentials! Try again next time!");                                                
					System.exit(0);
				}

			}
		}

		else if (choice == 2)
		{
			if (type == 1)
			{
				doc.add(addDoctor());
				System.out.println ("\nWelcome to the CSCI Hospital, Doctor!\n");
				DoctorMainMenu dmm = new DoctorMainMenu(doc.get(doc.size()-1));
				//saveUser();
				System.exit(0);
			}
			else if (type == 2)
			{
				nur.add(addNurse());
				System.out.println ("\nWelcome to the CSCI Hospital, Nurse!\n");                                       
				NurseMainMenu nmm = new NurseMainMenu(nur.get(nur.size()-1));
				saveUser();
				System.exit(0);
			}
			else if (type == 3)
			{
				fd.add(addFrontDesk());
				System.out.println ("\nWelcome to the CSCI Hospital, FrontDesk!\n");                              
				FrontDeskMainMenu fdmm = new FrontDeskMainMenu(fd.get(fd.size()-1));
				saveUser();
				System.exit(0);
			}
			else
			{
				pt.add(addPatient());
				System.out.println ("\nWelcome to the CSCI Hospital, Patient!\n");               
				PatientMainMenu ptmm = new PatientMainMenu(pt.get(pt.size()-1));
				saveUser();
				System.exit(0);
			}
		}

		else 
		{
			System.out.println ("Not a valid option. Please try again next time!");
		}
	}

	public boolean compareUsername(String username)
	{
		ArrayList<String> usern = new ArrayList<String>();
		for (int i = 0; i< doc.size(); i++)
		{
			usern.add(doc.get(i).getUsername());
		}
		for (int i = 0; i< nur.size(); i++)
		{
			usern.add(nur.get(i).getUsername());
		}	
		for (int i = 0; i< fd.size(); i++)
		{
			usern.add(fd.get(i).getUsername());
		}
		for (int i = 0; i< pt.size(); i++)
		{
			usern.add(pt.get(i).getUsername());
		}

		for (int i = 0; i< usern.size(); i++)
		{
			if (username.equals(usern.get(i)))
			{
				return true;	
			}
		}
		return false;
	}

	public boolean comparePassword(String password)
	{
		ArrayList<String> passw = new ArrayList<String>();
		for (int i = 0; i< doc.size(); i++)
		{
			passw.add(doc.get(i).getPassword());
		}
		for (int i = 0; i< nur.size(); i++)
		{
			passw.add(nur.get(i).getPassword());
		}	
		for (int i = 0; i< fd.size(); i++)
		{
			passw.add(fd.get(i).getPassword());
		}
		for (int i = 0; i< pt.size(); i++)
		{
			passw.add(pt.get(i).getPassword());
		}

		for (int i = 0; i< passw.size(); i++)
		{
			if (password.equals(passw.get(i)))
			{
				return true;	
			}
		}
		return false;
	}

		
}
