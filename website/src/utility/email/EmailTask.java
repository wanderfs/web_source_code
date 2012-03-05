package utility.email;

import java.util.ArrayList;

/**
 * for sending emails asynchronously.
 * add specified constants to send from iweishi by default.
 * @author Sen
 */
public class EmailTask implements Runnable {

    private static final String IWEISHI_EMAIL_SMTP = "smtp.gmail.com";
    private static final String IWEISHI_EMAIL_PASSWORD = "csyale402";
    private static final String IWEISHI_EMAIL_ADDRESS = "iweishi2010@gmail.com";

    private EmailSender email;

    public EmailTask(EmailSender email) {
        this.email = email;
    }

    public EmailTask(EmailMessage email) {
        ArrayList<String> r = new ArrayList<String>();
        r.add(email.getRecipient());
        this.email = new EmailSender(r, IWEISHI_EMAIL_SMTP, email.getSubject(), email.getContent(), IWEISHI_EMAIL_ADDRESS, IWEISHI_EMAIL_PASSWORD);
    }

    public EmailTask(String recipient, String subject, String content) {
        ArrayList<String> r = new ArrayList<String>();
        r.add(recipient);
        email = new EmailSender(r, IWEISHI_EMAIL_SMTP, subject, content, IWEISHI_EMAIL_ADDRESS, IWEISHI_EMAIL_PASSWORD);
    }

    @Override
    public void run() {
        email.postMail();
    }
}
