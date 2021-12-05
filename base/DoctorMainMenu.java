import java.io.*;
import java.util.Scanner;
import java.util.Vector;
import java.util.Formatter;

public class DoctorMainMenu implements Serializable {

	private Doctor doc1 = new Doctor();
	private Nurse nur1 = new Nurse();
	private FrontDesk fd1 = new FrontDesk();
	private Patient pt1 = new Patient();
	Scanner str = new Scanner (System.in);
	Scanner gen = new Scanner (System.in);

	public static void main (String args[])
	{
		new DoctorMainMenu ();
	}

	public DoctorMainMenu() {
	}

	public DoctorMainMenu (Doctor d1, Vector d, Vector n, Vector f, Vector p)
	{
		boolean keep_going = true;
		System.out.println ("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
		System.out.println ("Welcome to the Doctor Menu!\n");
		System.out.println ("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
		
		while (keep_going)
		{
			System.out.println ("Please enter your choice: \n");
			System.out.println ("1. Read Notification\n2. Delete a notification\n3. View A Patient's Info\n4. Make a diagnosis for a patient\n5. Set prescription for a patient\n6. Write a note to an admin\n7. Check all upcoming appointments\n8. Delete past appointment record\n9. Sign out\n");
			Scanner input = new Scanner(System.in);
			int choice  = input.nextInt();
			
			if (choice == 1)
			{
				if (d1.notification.size() == 0)
				{
					System.out.println ("\nYou don't have any new messages at the moment.\n");
				}
				else
				{
					d1.readNotification();
					if (d1.notification.size() > 10)
					{
						System.out.println ("Looks like you have quite a few notifications stored in your account. Clearing some old messages will help you organize better!\n");
					}			
				}
			}

			else if (choice == 2)
			{
				if (d1.notification.size() == 0)
				{
					System.out.println ("\nYou don't have any new messages at the moment.\n");
				}
				else
				{
					d1.readNotification();
					System.out.println("Please select a message to be deleted.");
					Scanner input1 = new Scanner (System.in);
					int num = input1.nextInt();
					d1.deleteNotification(num);
				}
			}

			else if (choice == 3)
			{
				Formatter fo = new Formatter();
				System.out.println (fo.format("%-5s%-15s%-22s", "No.", "Username", "Full Name")); 
				for (int i = 0; i < p.size(); i++)	
				{
					pt1 = (Patient) p.get(i);
					fo = new Formatter();
					System.out.println (fo.format("%-5s%-15s%-22s", i+1 + ")", pt1.getUsername(), pt1.getName()));
				}

				System.out.println ("\nWhich patient info would you like to view?\n");
				int num = gen.nextInt();
				pt1 = (Patient) p.get(num-1);
				System.out.println ("Name: " + pt1.getName());
				if (pt1.getDiagnosis().equals(""))
				{
					System.out.println ("Diagnosis: " + "None at the moment");
				}
				else
				{
					System.out.println ("Diagnosis: " + pt1.getDiagnosis());
				}
				if (pt1.getPrescription().equals(""))
				{
					System.out.println ("Past Prescriptions: " + "None at the moment");
				}
				else
				{
					System.out.println ("Past Prescriptions: " + pt1.getPrescription());
				}	
				System.out.println ("");
			}
			else if (choice == 4)
			{
				listPatient (p);
				System.out.println ("Please select a patient to add a diagnosis:");	
				int diagp = gen.nextInt();
				if (diagp > p.size() || diagp < 1)
                                {
                                       	System.out.println ("\nSorry, no patient found for the number you entered!\n");
                               	}
                               	else
                               	{
					pt1 = (Patient) p.get(diagp - 1);
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
						System.out.println ("Past Prescription: " + "None at the moment");
					}
					else
					{
						System.out.println ("Past Prescription: " + pt1.getPrescription());
					}	
					System.out.println ("\nWhat diagnosis do you want to make for " + pt1.getName() + "?");
					String ndiag = str.nextLine();
					pt1.setDiagnosis(ndiag);
					System.out.println ("\nDiagnosis has been updated successfully!\n");
				}
			}
			else if (choice == 5)
			{
				listPatient (p);
                                System.out.println ("Please select a patient to add a prescription:");
                                int diagp = gen.nextInt();
                                if (diagp > p.size() || diagp < 1)
                                {
                                        System.out.println ("\nSorry, no patient found for the number you entered!\n");
                                }
                                else
                                {
					String npres;
                                        pt1 = (Patient) p.get(diagp - 1);
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
                                                System.out.println ("Past Prescription: " + "None at the moment");
                                        }
                                        else
                                        {
						System.out.println ("Past Prescription: " + pt1.getPrescription());
                                        }
					if (pt1.getPrescription().equals(""))
					{
						System.out.println ("\nWhat do you want to add to " + pt1.getName() + "'s prescription?");
                                        	npres = str.nextLine();
						pt1.setPrescription(npres);
                                       		System.out.println ("\nPrescription has been updated successfully!\n");
					}
                                        else
					{
						System.out.println ("\nDo you want to add a prescription or change the prescription for " + pt1.getName() + "?\n\n1. Add a prescription\n2. Change the prescription\n");
						int aoc = gen.nextInt();
						if (aoc == 1)
						{
							System.out.println ("\nWhat do you want to add to the current prescription?");
                                        		npres = str.nextLine();
							String naddpres = pt1.getPrescription() + ", " + npres;
							pt1.setPrescription(naddpres);
                                        		System.out.println ("\nPrescription has been added successfully!\n");
						}
						else if (aoc == 2)
						{
							System.out.println ("\nWhat is the new prescription?");
                                	        	npres = str.nextLine();
							pt1.setPrescription(npres);
                                        		System.out.println ("\nPrescription has been updated successfully!\n");
						}
						else
						{
							System.out.println ("\nInvalid option! Try again next time!\n");
						}
					}			
				}
			}
			else if (choice == 6)
			{
				String not;
				System.out.println ("Which type of admin do you want to send a note to?\n");
				System.out.println ("1. Doctor\n2. Nurse\n3. Front Desk\n");
				int type = gen.nextInt();
				if (type == 1)
				{
					listDoctor(d);
					System.out.println ("\nPlease select a doctor:");
					int ch = gen.nextInt();
					if (ch > d.size() || ch < 1)
                                	{
                                        	System.out.println ("\nSorry, no doctor found for the number you entered!\n");
                                	}
                                	else
                                	{
						doc1 = (Doctor) d.get(ch-1);
						System.out.println ("Please enter the note you want to send to " + doc1.getName() + ":");
						not = str.nextLine();
						not = not + "	- from Doctor " + d1.getName();
						doc1.setNotification(not);
						System.out.println ("\nYour note was sent successfully!\n");
					}	
				} 
				else if (type == 2)
				{
					listNurse(n);
                                        System.out.println ("\nPlease select a nurse:");
                                        int ch = gen.nextInt();
					if (ch > n.size() || ch < 1)
                                	{
                                	        System.out.println ("\nSorry, no nurse found for the number you entered!\n");
                                	}
                                	else
                                	{
						nur1 = (Nurse) n.get(ch-1);
						System.out.println ("Please enter the note you want to send to " + nur1.getName() + ":");
                                        	not = str.nextLine();
                                        	not = not + "	- from Doctor " + d1.getName();
						nur1.setNote(not);
                                        	System.out.println ("\nYour note was sent successfully!\n");	
					}
				}
				else if (type == 3)
				{
					listFrontDesk(f);
                                        System.out.println ("\nPlease select a front desk:");
                                        int ch = gen.nextInt();
					if (ch > f.size() || ch < 1)
                                	{
                                	        System.out.println ("\nSorry, no front desk found for the number you entered!\n");
                                	}
                                	else
                                	{
						fd1 = (FrontDesk) f.get(ch-1);
						System.out.println ("Please enter the note you want to send to " + fd1.getName() + ":");
                                        	not = str.nextLine();
						not = not + "	- from Doctor " + d1.getName();
                                        	fd1.setMemo(not);
                                        	System.out.println ("\nYour note was sent successfully!\n");	
					}
				}
				else
				{
					System.out.println ("\nNot a valid choice! Try again next time.\n");
				}

			}
			else if (choice == 7)
			{
				if (d1.appointment.size() == 0)
				{
					System.out.println ("You don't have any appointments scheduled at the moment!\n"); 
				}
				else
				{
					d1.printDAppointment();
				}
			}
			else if (choice == 8)
			{
				if (d1.appointment.size() == 0)
				{
					System.out.println ("You don't have any appointments scheduled at the moment!\n");
				}
				else
				{
					d1.printDAppointment();
					System.out.println ("Please select a past appointment record to be deleted:");
					int da = gen.nextInt();
					if (da > d1.appointment.size() || da < 1)
					{
						System.out.println ("\nThe appointment record you entered could not be found!\n");
					}
					else
					{
						d1.appointment.remove(da-1);
						System.out.println ("\nThe appointment record was deleted successfully!\n");
					}
				}
			}
			else if (choice == 9)
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

	public void listPatient(Vector p)
	{
		System.out.println ("\nPatients");
		Formatter fo = new Formatter();
		System.out.println (fo.format("%-5s%-15s%-22s", "No.", "Username", "Full Name")); 
		for (int i = 0; i < p.size(); i++)	
		{
			fo = new Formatter();
			pt1 = (Patient) p.get(i);
			System.out.println (fo.format("%-5s%-15s%-22s", i+1 + ")", pt1.getUsername(), pt1.getName()));
		}
		System.out.println ("");
	}

	public void listNurse (Vector n)
	{
		System.out.println ("\nNurses");
		Formatter fo = new Formatter();
		System.out.println (fo.format("%-5s%-15s%-22s", "No.", "Username", "Full Name")); 
		for (int i = 0; i < n.size(); i++)	
		{
			nur1 = (Nurse) n.get(i);
			fo = new Formatter();
			System.out.println (fo.format("%-5s%-15s%-22s", i+1 + ")", nur1.getUsername(), nur1.getName()));
		}	
		System.out.println ("");
	}

	public void listDoctor (Vector d)
	{
		System.out.println ("\nDoctors");
		Formatter fo = new Formatter();
		System.out.println (fo.format("%-5s%-15s%-22s%-15s", "No.", "Username", "Full Name", "Specialty")); 
		for (int i = 0; i < d.size(); i++)	
		{
			doc1 = (Doctor) d.get(i);
			fo = new Formatter();
			System.out.println (fo.format("%-5s%-15s%-22s%-15s", i+1 + ")", doc1.getUsername(), doc1.getName(), doc1.getSpecialty()));
		}
		System.out.println ("");
	}

	public void listFrontDesk(Vector f)
	{
		System.out.println ("\nFront Desks");
		Formatter fo = new Formatter();
		System.out.println (fo.format("%-5s%-15s%-22s", "No.", "Username", "Full Name")); 
		for (int i = 0; i < f.size(); i++)	
		{
			fo = new Formatter();
			fd1 = (FrontDesk) f.get(i);
			System.out.println (fo.format("%-5s%-15s%-22s", i+1 + ")", fd1.getUsername(), fd1.getName()));
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
			System.out.println ("Diagnosis: " + "None at the moment");
		}
		else
		{
			System.out.println ("Diagnosis: " + pt1.getDiagnosis());
		}
		if (pt1.getPrescription().equals(""))
		{
			System.out.println ("Current Prescriptions: " + "None at the moment");
		}
		else
		{
			System.out.println ("Current Prescriptions: " + pt1.getPrescription());
		}	
		System.out.println (""); 
	}
}
