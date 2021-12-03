import java.io.*;
import java.lang.*;
import java.util.Scanner;
import java.util.Vector;
import java.util.Formatter;
import java.util.*;

public class FrontDeskMainMenu implements Serializable {
	
	Scanner str = new Scanner (System.in);
	Scanner gen = new Scanner (System.in);
	Doctor doc1 = new Doctor();
	Nurse nur1 = new Nurse();
	FrontDesk fd1 = new FrontDesk();
	Patient pt1 = new Patient();

	public static void main (String args[])
	{
		new FrontDeskMainMenu ();
	}

	public FrontDeskMainMenu() {
	}

	@SuppressWarnings("unchecked")
	public FrontDeskMainMenu (FrontDesk fd1, Vector d, Vector n, Vector f, Vector p, ArrayList sp)
	{
		boolean keep_going = true;
		System.out.println ("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
		System.out.println ("Welcome to the Front Desk Menu!\n");
		System.out.println ("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");

		while (keep_going)
		{
			System.out.println ("Please enter your choice: \n");
			System.out.println ("1.  Read Memo\n2.  Add Memo\n3.  Delete Memo\n4.  List all Patients\n5.  List all Admins\n6.  View A Patient's Info\n7.  Set Medical Bill for a Patient\n8.  Write a note to an Admin\n9.  Add a Patient\n10. Add an Admin\n11. Delete a Patient\n12. Delete an Admin\n13. Sign out\n");
			int choice  = gen.nextInt();
			if (choice == 1)
			{
				fd1.readMemo();
			}
			else if (choice == 2)
			{
				System.out.println ("\nWhat do you want to add to your memo?");
				String strin = str.nextLine();
				fd1.setMemo(strin);
				System.out.println ("\nMemo successfully added!\n");
			}
			else if (choice == 3)
			{
				fd1.readMemo();
				System.out.println ("\nWhich string do you want to delete from your memo?");
				int num = gen.nextInt();
				if (num > fd1.memo.size())
				{
					System.out.println ("\nSorry, no string found for the number you entered!\n");
				}
				else
				{
					fd1.deleteMemo(num);
				}
			}
			else if (choice == 4)
			{	
				listPatient(p);
			}
			else if (choice == 5)
			{
				listDoctor (d);
				listNurse (n);
				listFrontDesk (f);
			}
			else if (choice == 6)
			{
				listPatient(p);
				viewPatientInfo(p);	
			}
			else if (choice == 7)
			{
				listPatient(p);
				System.out.println ("\nPlease a patient to update his/her medical bill:");
				int num = gen.nextInt();
				if (num > p.size())
				{
					System.out.println ("\nSorry, no patient found for the number you entered!\n"); 
				}
				else
				{
					Scanner flo = new Scanner (System.in);
					pt1 = (Patient) p.get(num-1); 
					System.out.println ("\nWhat is the amount you want to add to " + pt1.getName() + "'s medical bill?\n");	
					float amount = flo.nextFloat();
					String am = String.format("%.2f", amount);
					pt1.addBill(amount);
					System.out.println ("\nSuccessfully added $" + am + " to " + pt1.getName() + "'s medical bill.\n");
				}
			}
			else if (choice == 8)
			{
				String not;
				System.out.println ("Which type of admin do you want to send a note to?\n");
				System.out.println ("1. Doctor\n2. Nurse\n");
				int type = gen.nextInt();
				if (type == 1)
				{
					listDoctor(d);
					System.out.println ("\nPlease select a doctor:");
					int ch = gen.nextInt();
					if (ch > d.size())
                                	{
                                        	System.out.println ("\nSorry, no doctor found for the number you entered!\n");
                                	}
                                	else
                                	{
						doc1 = (Doctor) d.get(ch-1);
						System.out.println ("\nPlease enter the note you want to send to the doctor:");
						not = str.nextLine();
						doc1.setNotification(not);
						System.out.println ("\nYour note was sent successfully!\n");
					}	
				} 
				else if (type == 2)
				{
					listNurse(n);
                                        System.out.println ("\nPlease select a nurse:");
                                        int ch = gen.nextInt();
					if (ch > n.size())
                                	{
                                	        System.out.println ("\nSorry, no nurse found for the number you entered!\n");
                                	}
                                	else
                                	{
						nur1 = (Nurse) n.get(ch-1);
						System.out.println ("\nPlease enter the note you want to send to the nurse:");
                                        	not = str.nextLine();
                                        	nur1.setNote(not);
                                        	System.out.println ("\nYour note was sent successfully!\n");	
					}
				}			
				else
				{
					System.out.println ("\nNot a valid choice! Try again next time.\n");
				}
			}
			else if (choice == 9)
			{
				Patient np = new Patient ();
				String name;
				boolean not_exist = true;
				boolean kg = true;
				while (kg)
				{
					not_exist = true;
					System.out.println("\nPlease enter a username:");
					String untry = str.nextLine();
					if (compareUsername(untry, d, n, f, p) == true)
					{
						not_exist = false;
						System.out.println("\nSorry, this username has been used. Please try another username!");
					}
					else	
					{
						np.setUsername(untry);
						kg = false;
					}
				}
				kg = true;
				while (kg)
				{
					not_exist = true;	
					System.out.println("\nPlease enter a password:");
					String pwtry = str.nextLine();
					if (comparePassword(pwtry, d, n, f, p))	
					{
						not_exist = false;
						System.out.println("\nSorry, this password has been used. Please try another password!");
					}
					else	
					{
						np.setPassword(pwtry);
						kg = false;
					}
				}

				System.out.println("\nPlease enter a full name:");
				name = str.nextLine();	
				np.setName(name);
				p.add(np);
				System.out.println ("\nA new patient account has been created successfully!");	
			}
			else if (choice == 10)
			{
				String name;
				boolean not_exist = true;
				boolean kg = true;
				System.out.println ("\nPlease select an admin type that you want to add:\n\n1. Doctor\n2. Nurse\n");
				int type = gen.nextInt();
				if (type == 1)
				{
					Doctor nd = new Doctor();
					while (kg)
					{
						not_exist = true;
						System.out.println("\nPlease enter a username:");
						String untry = str.nextLine();
						if (compareUsername(untry, d, n, f, p) == true)
						{
							not_exist = false;
							System.out.println("\nSorry, this username has been used. Please try another username!");
						}
						else	
						{
							nd.setUsername(untry);
							kg = false;
						}
					}
					kg = true;
					while (kg)
					{
						not_exist = true;	
						System.out.println("\nPlease enter a password:");
						String pwtry = str.nextLine();
						if (comparePassword(pwtry, d, n, f, p))	
						{
							not_exist = false;
							System.out.println("\nSorry, this password has been used. Please try another password!");
						}
						else	
						{
							nd.setPassword(pwtry);
							kg = false;
						}
					}
					System.out.println("\nPlease enter a full name:");
					name = str.nextLine();	
					nd.setName(name);
					System.out.println("\nSpecialty\n"); 
					String nspec;
					int nspecial;
					kg = true;
					while (kg)
					{
						for (int i = 0; i < sp.size(); i++)
						{
							System.out.println (i+1 + ") " + sp.get(i));	
						}
						System.out.println ("\nPlease select a specialty for the doctor:");
						nspecial = gen.nextInt();
						if (nspecial > sp.size())
						{
							System.out.println ("\nInvalid option! Please try again.\n");
						}
						else 
						{
							nspec = (String) sp.get(nspecial - 1);		
							nd.setSpecialty(nspec);
							kg = false;
						}
					}
					d.add(nd);	
					System.out.println ("\nA new doctor account has been created successfully!\n");
				}
				else if (type == 2)
				{
					kg = true;
					Nurse nn = new Nurse();
					while (kg)
					{
						not_exist = true;
						System.out.println("\nPlease enter a username:");
						String untry = str.nextLine();
						if (compareUsername(untry, d, n, f, p) == true)
						{
							not_exist = false;
							System.out.println("\nSorry, this username has been used. Please try another username!");
						}
						else	
						{
							nn.setUsername(untry);
							kg = false;
						}
					}
					kg = true;
					while (kg)
					{
						not_exist = true;	
						System.out.println("\nPlease enter a password:");
						String pwtry = str.nextLine();
						if (comparePassword(pwtry, d, n, f, p))	
						{
							not_exist = false;
							System.out.println("\nSorry, this password has been used. Please try another password!");
						}
						else	
						{
							nn.setPassword(pwtry);
							kg = false;
						}
					}
					System.out.println("\nPlease enter a full name:");
					name = str.nextLine();	
					nn.setName(name);
					n.add(nn);	
					System.out.println ("\nA new patient account has been created successfully!\n");
				}
				else 
				{
					System.out.println ("Invalid choice! Try again next time\n");
				}
			}
			else if (choice == 11)
			{
				listPatient (p);
				System.out.println ("\nPlease select a patient to delete:");
				int num = gen.nextInt();
				if (num > p.size())
				{
					System.out.println ("\nSorry, no patient found for the number you entered!\n"); 
				}
				else
				{
					p.remove(num-1); 
					System.out.println ("\nPatient's account has been successfully deleted!\n");
				}
			}
			else if (choice == 12)
			{
				String not;
				System.out.println ("Which type of admin do you want to delete?\n");
				System.out.println ("1. Doctor\n2. Nurse\n");
				int type = gen.nextInt();
				if (type == 1)
				{
					listDoctor(d);
					System.out.println ("\nPlease select a doctor to delete:");
					int ch = gen.nextInt();
					if (ch > d.size())
                                	{
                                        	System.out.println ("\nSorry, no doctor found for the number you entered!\n");
                                	}
                                	else
                                	{
						d.remove(ch-1);
						System.out.println ("\nDoctor's account has been successfully deleted!\n");
					}	
				} 
				else if (type == 2)
				{
					listNurse(n);
                                        System.out.println ("\nPlease select a nurse to delete:");
                                        int ch = gen.nextInt();
					if (ch > n.size())
                                	{
                                	        System.out.println ("\nSorry, no nurse found for the number you entered!\n");
                                	}
                                	else
                                	{
						n.remove(ch-1);
						System.out.println ("\nNurse's account has been successfully deleted!\n");
					}
				}
				else
				{
					System.out.println ("\nInvalid option! Try again next time!\n");
				}
			}
			else if (choice == 13)
			{
				System.out.println ("Thank you for your time. Have a good day!\n");
				keep_going = false;
			}
			else
			{
				System.out.println ("Not a valid choice! Please try again.\n");
			}


		}
	}

	public void listPatient(Vector p)
	{
		Formatter fo = new Formatter();
		System.out.println (fo.format("%-5s%-15s%-25s", "No.", "Username", "Full Name")); 
		for (int i = 0; i < p.size(); i++)	
		{
			fo = new Formatter();
			pt1 = (Patient) p.get(i);
			System.out.println (fo.format("%-5s%-15s%-25s", i+1 + ")", pt1.getUsername(), pt1.getName()));
		}
		System.out.println ("");
	}

	public void listDoctor (Vector d)
	{
		System.out.println ("\nDoctors");
		Formatter fo = new Formatter();
		System.out.println (fo.format("%-5s%-15s%-25s%-15s", "No.", "Username", "Full Name", "Specialty")); 
		for (int i = 0; i < d.size(); i++)	
		{
			doc1 = (Doctor) d.get(i);
			fo = new Formatter();
			System.out.println (fo.format("%-5s%-15s%-25s%-15s", i+1 + ")", doc1.getUsername(), doc1.getName(), doc1.getSpecialty()));
		}
		System.out.println ("");
	}
	

	public void listNurse (Vector n)
	{
		System.out.println ("\nNurses");
		Formatter fo = new Formatter();
		System.out.println (fo.format("%-5s%-15s%-25s", "No.", "Username", "Full Name")); 
		for (int i = 0; i < n.size(); i++)	
		{
			nur1 = (Nurse) n.get(i);
			fo = new Formatter();
			System.out.println (fo.format("%-5s%-15s%-25s", i+1 + ")", nur1.getUsername(), nur1.getName()));
		}	
		System.out.println ("");
	}

	public void listFrontDesk (Vector f)
	{	
		System.out.println ("\nFront Desks");
		Formatter fo = new Formatter();
		System.out.println (fo.format("%-5s%-15s%-25s", "No.", "Username", "Full Name")); 
		for (int i = 0; i < f.size(); i++)	
		{
			fd1 = (FrontDesk) f.get(i);
			fo = new Formatter();
			System.out.println (fo.format("%-5s%-15s%-25s", i+1 + ")", fd1.getUsername(), fd1.getName()));
		}
		System.out.println ("");
	}

	public void viewPatientInfo(Vector p)
	{		
		System.out.println ("\nWhich patient info would you like to view?");
		int choice = gen.nextInt();
		pt1 = (Patient) p.get(choice-1);
		System.out.println ("Name: " + pt1.getName());
		if (pt1.getDiagnosis().equals(""))
		{
			System.out.println ("Recent Diagnosis: " + "None at the moment");
		}
		else
		{
			System.out.println ("Recent Diagnosis: " + pt1.getDiagnosis());
		}
		if (pt1.getPrescription().equals(""))
		{
			System.out.println ("Current Prescription: " + "None at the moment");
		}
		else
		{
			System.out.println ("Current Prescription: " + pt1.getPrescription());
		}	
		System.out.println (""); 
	}

	public boolean compareUsername(String username, Vector d, Vector n, Vector f, Vector p)
	{
		ArrayList<String> usern = new ArrayList<String>();
		for (int i = 0; i< d.size(); i++)
		{
			doc1 = (Doctor) d.get(i);
			usern.add(doc1.getUsername());
		}
		for (int i = 0; i< n.size(); i++)
		{
			nur1 = (Nurse) n.get(i);
			usern.add(nur1.getUsername());
		}	
		for (int i = 0; i< f.size(); i++)
		{
			fd1 = (FrontDesk) f.get(i);
			usern.add(fd1.getUsername());
		}
		for (int i = 0; i< p.size(); i++)
		{
			pt1 = (Patient) p.get(i);
			usern.add(pt1.getUsername());
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

	public boolean comparePassword(String password, Vector d, Vector n, Vector f, Vector p)
	{
		ArrayList<String> passw = new ArrayList<String>();
		for (int i = 0; i< d.size(); i++)
		{
			doc1 = (Doctor) d.get(i);
			passw.add(doc1.getPassword());
		}
		for (int i = 0; i< n.size(); i++)
		{
			nur1 = (Nurse) n.get(i); 
			passw.add(nur1.getPassword());
		}	
		for (int i = 0; i< f.size(); i++)
		{
			fd1 = (FrontDesk) f.get(i);
			passw.add(fd1.getPassword());
		}
		for (int i = 0; i< p.size(); i++)
		{
			pt1 = (Patient) p.get(i);
			passw.add(pt1.getPassword());
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
