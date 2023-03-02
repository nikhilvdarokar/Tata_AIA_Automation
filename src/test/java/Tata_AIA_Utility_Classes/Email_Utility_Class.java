package Tata_AIA_Utility_Classes;

import java.net.MalformedURLException;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.ImageHtmlEmail;


public class Email_Utility_Class {
	
	public static void emailsend() throws EmailException {
		
		  String ExtentReport = (System.getProperty("user.dir") +"./Reports/Tata_Aia_Reports.html");

		  ImageHtmlEmail email = new ImageHtmlEmail();
		  
		  email.setHostName("mail.myserver.com");
		  email.addTo("jdoe@somewhere.org", "John Doe");
		  email.setFrom("me@apache.org", "Me");
		  email.setSubject("Test email with inline image");
		  
		  // set the html message
		  email.setHtmlMsg(ExtentReport);

		  // set the alternative message
		  email.setTextMsg("Your email client does not support HTML messages");

		  // send the email
		  email.send();
		
	}

}
