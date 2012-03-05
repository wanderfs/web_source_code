/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utility.email;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import logic.link.MyAuth;

/**
 *
 * @author Franklin
 */
public class EmailSender {
        //
        private String smtp;
        private String message;
        private String from;
        private String subject;
        private String password;
        private ArrayList<String> recipients;

        public EmailSender(ArrayList<String> recipients, String smtp, String subject, String message , String from, String key){
            this.from = from;
            this.message = message;
            this.smtp = smtp;
            this.subject = subject;
            this.recipients = recipients;
            this.password = key;
        }

	public void postMail()
	{
        try {
            boolean debug = false;
            //String smtp = "smtp.gmail.com";
            //Set the host smtp address
            Properties props = new Properties();
            props.put("mail.smtp.host", this.smtp);
            props.put("mail.smtp.auth", "true");
            MyAuth myauth = new MyAuth(this.from, password);
            Session session = Session.getDefaultInstance(props, myauth);
            if (this.smtp.indexOf("smtp.gmail.com") >= 0) {
                props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.setProperty("mail.smtp.socketFactory.fallback", "false");
                props.setProperty("mail.smtp.port", "465");
                props.setProperty("mail.smtp.socketFactory.port", "465");
            } //Session session = Session.getDefaultInstance(props, null);
            session.setDebug(debug);
            // create a message
            Message msg = new MimeMessage(session);
            // set the from and to address
            InternetAddress addressFrom = new InternetAddress(this.from);
            msg.setFrom(addressFrom);
            InternetAddress[] addressTo = new InternetAddress[this.recipients.size()];
            for (int i = 0; i < this.recipients.size(); i++) {
                addressTo[i] = new InternetAddress(this.recipients.get(i));
            }
            msg.setRecipients(Message.RecipientType.TO, addressTo);
            // Optional : You can also set your custom headers in the Email if you Want
            //msg.addHeader("MyHeaderName", "myHeaderValue");
            // Setting the Subject and Content Type
            msg.setSubject(this.subject);
            msg.setContent(this.message, "text/plain");
            System.out.println(this.message);
            //Transport transport=session.getTransport();
            //transport.connect("smtp.gmail.com" , 25, "iweishi2010","csyale402");
            Transport.send(msg);
            //transport.close();
            //Transport.send(msg);
        }
        //	public static void main(String[] args) throws MessagingException {
        //		// TODO Auto-generated method stub
        //
        //		SenderTest test = new SenderTest();
        //		ArrayList<String> mailAddress = new ArrayList<String>();
        //		mailAddress.add("franklinsxx@gmail.com");
        //		String msg = "Hello World!";
        //		String sub = "Welcome from IWeiShi.cn";
        //		String from = "iweishi2010@gmail.com";
        //		String smtp = "smtp.gmail.com";
        //		System.out.println("Begin Sending...");
        //		postMail(mailAddress, smtp, sub, msg, from);
        //		System.out.println("End Sending...");
        //	}
        catch (MessagingException ex) {
            Logger.getLogger(EmailSender.class.getName()).log(Level.SEVERE, null, ex);
        }
	}


//	public static void main(String[] args) throws MessagingException {
//		// TODO Auto-generated method stub
//
//		SenderTest test = new SenderTest();
//		ArrayList<String> mailAddress = new ArrayList<String>();
//		mailAddress.add("franklinsxx@gmail.com");
//		String msg = "Hello World!";
//		String sub = "Welcome from IWeiShi.cn";
//		String from = "iweishi2010@gmail.com";
//		String smtp = "smtp.gmail.com";
//		System.out.println("Begin Sending...");
//		postMail(mailAddress, smtp, sub, msg, from);
//		System.out.println("End Sending...");
//	}

}
