import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class Mail {

	public static void main (String [] args) 
	{
		String recipient = "brcheong@iu.edu";
		String sender = "cheongbrian5563@gmail.com";
		String host = "localhost";
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.gmail", host);

		Session session = Session.getDefaultInstance (Properties);

		try {
		MimeMessage message = new MimeMessage (session);
		message.getFrom (new InternetAddress(from));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
		message.setSubject ("Forget Password Help");
		message.setText ("Your password is:\n\nCSCI240\n");
		Transport.send(message);
		System.out.println ("Sent message successfully!");
		} catch (MessagingException mex) {
		mex.printStackTrace();
		}
	}
}
