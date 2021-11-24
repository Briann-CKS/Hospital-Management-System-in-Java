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
		Doctor doc1 = new Doctor ("brcheong", "Bcks020502", "Brian");
		doc.add(doc1);
		Doctor doc2 = new Doctor ();
		doc2 = doc.get(0);
		System.out.println(doc2.getUsername());
		//account.mainMenu ();
	}

	public Hospital ()
	{
		//loadUser();
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
	}

	//public void saveUser
	
}
