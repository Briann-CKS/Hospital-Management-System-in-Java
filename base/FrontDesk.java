import java.io.*;
import java.util.*;

public class FrontDesk extends Admin implements Serializable {

	public ArrayList<String> memo = new ArrayList<String>();
	private String username;
	private String password;
	private String name;	
	Usertype type = Usertype.FRONTDESK;

	public static void main (String args[])
	{
		FrontDesk fd = new FrontDesk();
	}

	public FrontDesk ()
	{
		super();
		this.username = "Unknown";
		this.password = "Unknown";
		this.name = "Unknown";
	}

	public FrontDesk (String username, String password, String name)
	{
		super();
		this.username = username;
		this.password = password;
		this.name = name;
	}

	public void setMemo (String message)
	{
		this.memo.add(message);
	}

	public void deleteMemo (int num)
	{
		int ind = num - 1;
		if (this.memo.size() >= num)
		{
			memo.remove(ind);
			System.out.println ("Memo has been deleted!\n");
		}
		else 
		{
			System.out.println ("Cannot find the memo you intend to delete. Sorry!\n");
		}
	}

	public void readMemo ()
	{
		System.out.println ("You have " + memo.size() + " memo(s): \n");
		for (int i = 0; i < memo.size(); i++)
		{
			System.out.println (i+1 + ") " + memo.get(i));
		}
		System.out.println ("");
		if (memo.size() > 10)
		{
			System.out.println ("Looks like you have quite a few notifications stored in your account. Clearing some old messages will help you organize better!\n");
		}
	}
}
