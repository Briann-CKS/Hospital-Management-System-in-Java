import java.io.*;

public class Patient implements User, Serializable {

	public String username;
	public String password;
	public String name;
	//public Date appointment = new Date();
	public String diagnosis;
	public String prescription;
	public int bill = 0;

	public static void main (String args[])
	{
		Patient u1 = new Patient();
		u1.setUsername ("brcheong");
		u1.setPassword ("Hello");
		System.out.println (u1.getUsername() + " " + u1.getPassword());
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

	//public void setAppointment (Date appointment)
	//{
	//	this.appointment = appointment;
	//}

	public void addBill(int amount)
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

	public int getBill()
	{
		return bill;
	}

	/*public void paymedical_bill()
	{
		if (this.bill == 0)
		{
			System.out.println ("You have paid your medical bills! Thanks for your cooperation.");
		}
		else
		{
			System.out.println ("Your medical bill total is $" + this.bill + ", would you like to pay the total amount? (y or n)");
		}

	}*/

}	
