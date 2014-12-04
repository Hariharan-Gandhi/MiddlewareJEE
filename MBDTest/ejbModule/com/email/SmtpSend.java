/********************************************************************************/
/* D E S C R I P T I O N    O F    T H E    P R O G R A M                       */
/********************************************************************************/
/* This program sends an Email to the customer from the Omazon admin Gmail ID   */
/* using the SMTP Protocol. 													*/
/********************************************************************************/
/* DEVELOPERS:																	*/
/********************************************************************************/
/* Hariharan Gandhi, Master Student, Technical University of Darmstadt          */
/* Harini Gunabalan, Master Student, Technical University of Darmstadt          */															
/********************************************************************************/
package com.email;
import java.util.Properties;
import java.util.Date;

import javax.mail.*;
import javax.mail.internet.*;

import com.sun.mail.smtp.*;

public class SmtpSend {

	public void sendEmail(String recepient, String body){ 
		
		String  to, subject = null, from = null, 
				cc = null, bcc = null;
			String mailhost = null;
			String mailer = "smtpsend";	
			String user = null, password = null;
			boolean debug = false;
			boolean verbose = false;
			boolean auth = false;
			String prot = "smtps";

		    user = "omazon.mw";
		    password = "omazon@123";	
		    mailhost = "smtp.gmail.com";
		    auth = true;
		    
			try {
				
				to = recepient;			//Email Recipient 
				subject = "Omazon";
			    Properties props = System.getProperties();

			    if (mailhost != null)
				props.put("mail." + prot + ".host", mailhost);
			    if (auth)
				props.put("mail." + prot + ".auth", "true");
			    Session session = Session.getInstance(props, null);
			    if (debug)
				session.setDebug(true);

			    Message msg = new MimeMessage(session);
			    if (from != null)
				msg.setFrom(new InternetAddress(from));
			    else
				msg.setFrom();

			    msg.setRecipients(Message.RecipientType.TO,
							InternetAddress.parse(to, false));
			    if (cc != null)
				msg.setRecipients(Message.RecipientType.CC,
							InternetAddress.parse(cc, false));
			    if (bcc != null)
				msg.setRecipients(Message.RecipientType.BCC,
							InternetAddress.parse(bcc, false));

			    msg.setSubject(subject);

/* Email Body */				
			    String text = "Dear Customer,\n \nThanks for using Omazon. Update about your Shipment:\n\n" + "\""+body + "\""+"\n\n Regards,\nOmazon Customer Service Team";
			    
				msg.setText(text);
			    

			    msg.setHeader("X-Mailer", mailer);
			    msg.setSentDate(new Date());	    
			    
			    SMTPTransport t =
				(SMTPTransport)session.getTransport(prot);
			    try {
				if (auth)
				    t.connect(mailhost, user, password);
				else
				    t.connect();
				t.sendMessage(msg, msg.getAllRecipients());
			    } finally {
				if (verbose)
				    System.out.println("Response: " +
								t.getLastServerResponse());
				t.close();
			    }

			    System.out.println("\nMail was sent successfully.");

			} catch (Exception e) {
			    if (e instanceof SendFailedException) {
				MessagingException sfe = (MessagingException)e;
				if (sfe instanceof SMTPSendFailedException) {
				    SMTPSendFailedException ssfe =
						    (SMTPSendFailedException)sfe;
				    System.out.println("SMTP SEND FAILED:");
				    if (verbose)
					System.out.println(ssfe.toString());
				    System.out.println("  Command: " + ssfe.getCommand());
				    System.out.println("  RetCode: " + ssfe.getReturnCode());
				    System.out.println("  Response: " + ssfe.getMessage());
				} else {
				    if (verbose)
					System.out.println("Send failed: " + sfe.toString());
				}
				Exception ne;
				while ((ne = sfe.getNextException()) != null &&
					ne instanceof MessagingException) {
				    sfe = (MessagingException)ne;
				    if (sfe instanceof SMTPAddressFailedException) {
					SMTPAddressFailedException ssfe =
							(SMTPAddressFailedException)sfe;
					System.out.println("ADDRESS FAILED:");
					if (verbose)
					    System.out.println(ssfe.toString());
					System.out.println("  Address: " + ssfe.getAddress());
					System.out.println("  Command: " + ssfe.getCommand());
					System.out.println("  RetCode: " + ssfe.getReturnCode());
					System.out.println("  Response: " + ssfe.getMessage());
				    } else if (sfe instanceof SMTPAddressSucceededException) {
					System.out.println("ADDRESS SUCCEEDED:");
					SMTPAddressSucceededException ssfe =
							(SMTPAddressSucceededException)sfe;
					if (verbose)
					    System.out.println(ssfe.toString());
					System.out.println("  Address: " + ssfe.getAddress());
					System.out.println("  Command: " + ssfe.getCommand());
					System.out.println("  RetCode: " + ssfe.getReturnCode());
					System.out.println("  Response: " + ssfe.getMessage());
				    }
				}
			    } else {
				System.out.println("Got Exception: " + e);
				if (verbose)
				    e.printStackTrace();
			    }
			}		
		
	}

}
