import java.io.*;
import java.util.Scanner;

public class Patient implements User, Serializable {

	private String username;
	private String password;
	private String name;
	//public Date appointment = new Date();
	private String diagnosis;
	private String prescription;
	private float bill = 0;

	public static void main (String args[])
	{
		Patient u1 = new Patient();
		//u1.setUsername ("brcheong");
		//u1.setPassword ("Hello");
		//System.out.println (u1.getUsername() + " " + u1.getPassword());
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

	//public void setAppointment (Date appointment)
	//{
	//	this.appointment = appointment;
	//}

	public void addBill(float amount)
	{
		this.bill += amount;
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

	/*public printPrescription()
	{
		String pres;
		//pres = 	
		
	}*/

	public float getBill()
	{
		return bill;
	}

	public void paymedical_bill()
	{
		if (this.bill == 0)
		{
			System.out.println ("You don't have any medical bills at the moment! Thanks for checking with us.");
		}
		else
		{
			System.out.println ("Your medical bill total is $" + this.bill + ", would you like to pay the total amount? (1. Yes  2. No)");
			Scanner input = new Scanner(System.in);
			int choice = input.nextInt();
			if (choice == 1)
			{
				System.out.println ("Thank you! You have successfully paid your medical bills.");
				this.bill = 0;
			}

			if (choice == 2)
			{
				System.out.println ("Please enter the amount that you would like to pay:\n");
				float amount = input.nextFloat(); 			
				bill -= amount;
				System.out.println ("Payment successful. Your current medical bill balance is $" + bill + ". Thank you!\n");				
			}
		}

	}

}	
