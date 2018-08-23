package com.http.mail;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail {

    public void SendpdfMail() throws MessagingException {

      //  String host = "smtp.gmail.com";
        String Password = "vikas@2402";
        String from = "rtam_tool@bell.ca";
        String toAddress = "vikas.bhartiya@cgi.com";
        String port="25";
        String filename = "C:/Multivu_Downstream_Response.pdf";
        // Get system properties
        Properties props = System.getProperties();
       // props.put("mail.smtp.host", host);
      //  props.put("mail.smtps.auth", "true");
        props.put("mail.smtp.port", 25);
        props.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(props, null);

        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress(from));

        message.setRecipients(Message.RecipientType.TO, toAddress);

        message.setSubject("MultiVu Sanity test");

        BodyPart messageBodyPart = new MimeBodyPart();

        messageBodyPart.setText("Please find attached file for sanity test");

        Multipart multipart = new MimeMultipart();

        multipart.addBodyPart(messageBodyPart);

        messageBodyPart = new MimeBodyPart();

        DataSource source = new FileDataSource(filename);

        messageBodyPart.setDataHandler(new DataHandler(source));

        messageBodyPart.setFileName(filename);

        multipart.addBodyPart(messageBodyPart);

        message.setContent(multipart);

        try {
            Transport tr = session.getTransport("smtps");
            tr.connect(from,toAddress);
            tr.sendMessage(message, message.getAllRecipients());
            System.out.println("Mail Sent Successfully");
            tr.close();

        } catch (SendFailedException sfe) {

            System.out.println(sfe);
            sfe.printStackTrace();
        }
    }
}
