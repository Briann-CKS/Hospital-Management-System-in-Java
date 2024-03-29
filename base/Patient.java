import java.io.*;
import java.util.Scanner;
import java.util.*;

// Start patient class
public class Patient implements User, Serializable {

	private String username;
	private String password;
	private String name;
	protected String diagnosis;
	protected String prescription;
	protected float bill = 0.0f;
	public ArrayList <Appointment> appointment = new ArrayList <Appointment>();

	public static void main (String args[])
	{
		Patient u1 = new Patient();
	}

	public Patient()
	{
		this.diagnosis = "";
		this.prescription = "";
		this.bill = (float) 0.0;
	}

        public void setUsername (String username)
        {
                this.username = username;
        }

        public void setPassword (String password)
        {
                this.password = password;
        }

        public void setName (String name)
        {
                this.name = name;
        }

	public void setDiagnosis (String diagnosis)
	{
		this.diagnosis = diagnosis;
	}

	public void setPrescription (String prescription)
	{
		this.prescription = prescription;
	}

	public void addBill(float amount)
	{
		this.bill += amount;
	}

	public void addAppointment (Appointment app) 
	{
		this.appointment.add(app);
	}

	public void printPAppointment ()
	{
		System.out.println ("\nAppointment details:\n");
		for (int i = 0; i < appointment.size(); i++)
		{
			System.out.println (i+1 + ")");
			appointment.get(i).printAppointment();
		}

	}

        public String getUsername ()
        {
                return username;
        }

        public String getPassword()
        {
                return password;
        }

        public String getName()
        {
                return name;
        }

	public String getDiagnosis()
	{
		return diagnosis;
	}

	public String getPrescription()
	{
		return prescription;
	}

	public float getBill()
	{
		return bill;
	}

	public void paymedical_bill()
	{
		if (this.bill == 0)
		{
			System.out.println ("You don't have any medical bills at the moment! Thanks for checking with us.\n");
		}
		else
		{
			String b = String.format("%.2f", this.bill);
			System.out.println ("Your medical bill total is $" + b + ", would you like to pay the total amount? (1. Yes  2. No)");
			Scanner input = new Scanner(System.in);
			int choice = input.nextInt();
			if (choice == 1)
			{
				System.out.println ("Thank you! You have successfully paid your medical bills.");
				this.bill = (float) 0.0;
			}

			if (choice == 2)
			{
				System.out.println ("Please enter the amount that you would like to pay:\n");
				float amount = input.nextFloat(); 			
				if (amount > this.bill)
				{
					System.out.println ("You have successfully paid your medical bill in the full amount!\n");	
					float change = (float) (amount - this.bill);
					String schange = String.format ("%.2f", change);
					this.bill = (float) 0.0;
					System.out.println ("Your change of $" + schange + " has been transferred to your bank account.\n");
				}
				else
				{
					this.bill -= amount;
					b = String.format ("%.2f", this.bill);
					System.out.println ("Payment successful. Your current medical bill balance is $" + b + ". Thank you!\n");				
				}
			}
		}

	}
} // end patient class
