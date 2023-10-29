/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.Session;
import javax.mail.Transport;

/**
 *
 * @author SONY
 */
public class SendEmail {

    /**
     *
     * @return
     */
    public String getRandom(){
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }
    
    /**
     *
     * @param user
     * @return
     */
    public boolean sendEmail(User user){
        boolean test = false;
        String toEmail = user.getEmail();
        String fromEmail = "s.shivnaran@gmail.com";
        //String password = "efmwluwnodlrdrqn";
            Properties pr = new Properties();   //Properties is a class in Java that represents a collection of key-value pairs, typically used for configuration settings.
            //SMTP Server's information are set 
            pr.setProperty("mail.smtp.host","smtp.gmail.com");
            pr.setProperty("mail.smtp.port","587");
            pr.setProperty("mail.smtp.auth","true");
            pr.setProperty("mail.smtp.starttls.enable","true");
            //pr.put("mail.smtp.socketFactory.port", "587");
            //pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            
            //get session . creating session object is the basis for establishing an email session using the JavaMailAPI
            Session session = Session.getDefaultInstance(pr,
                new javax.mail.Authenticator(){
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(
                                "s.shivnaran@gmail.com", "efmwluwnodlrdrqn");// Specify the Username and the PassWord
                    }
            });
        try
        {
            // MimeMessage object. MIME - Multipurpose Internet Mail Extensions
            MimeMessage message = new MimeMessage(session);

            // Set From Field: adding senders email to from field.
            message.setFrom(new InternetAddress(fromEmail)); //create, parse, and manipulate email addresses in a format that adheres to internet standards

            // Set To Field: adding recipient's email to from field.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

            message.setSubject("User Email Verification");
            message.setText("Registered Successfully . Please verify your account using this code : "+user.getCode());

            // Send email.
            Transport.send(message);
            test=true;
        }
        catch (MessagingException mex)
        {
            mex.printStackTrace();
        }   
        return test;
    }
}
