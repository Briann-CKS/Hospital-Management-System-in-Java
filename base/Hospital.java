import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class Hospital extends User implements Serializable{

	public static Vector <User> vec = new Vector<User>();	

	public static void main (String[] args){
		Hospital account = new Hospital();
		account.mainMenu (vec);
	}

	public Hospital ()
	{
		loadUser();
	}

	public void loadUser()
	{
		try{
		FileInputStream users_file = new FileInputStream("Users.dat");
		ObjectInputStream inputU = new ObjectInputStream(users_file);
		vec = (Vector) inputU.readObject();
		inputU.close();
		} catch (IOException e) {
			System.out.println (e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println (e.getMessage());
		}
	}

	//public void saveUser
	
}
