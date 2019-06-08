package msg.user.control.computation;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
@Stateless
public class ComputationProcessor {

    @Asynchronous
    public void sendEmail(final String emailAddress,final String firstName, final String userName,final String userPassword) {
        final String username = "jbugsteam@gmail.com";
        final String password = "qwertyui12345!";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("catalinciurean1996@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(emailAddress));
            message.setSubject("Welcome to Jbugs");
            message.setText("Dear " +firstName +","
                    + "\n\n You're new account has been created. You can start using our application with the credentials" +
                    " that you'll find in this email"
                    +"\n\n" + "We're strongly suggesting you to change you're password when you log in for the first time in our application"
                    +"\n\n"+"Username: "+userName
                    +"\n\n"+"Password: "+userPassword
                    +"\n\n"
                    +"\n\n"
                    +"\n\n"+"Thank you,"
                    +"\n\n"+"Jbugs Administrator");




            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}