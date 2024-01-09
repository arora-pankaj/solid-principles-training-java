package com.iongroup.ldp.solution.implementations;

import com.iongroup.ldp.solution.interfaces.NotificationService;
import com.iongroup.ldp.solution.model.Cart;
import com.iongroup.ldp.solution.utility.Logger;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class NotificationServiceImpl implements NotificationService {
  @Override
  public void notifyCustomerOrderCreated(Cart cart) {
    String customerEmail = cart.getCustomerEmail();
    if (!customerEmail.isEmpty()) {
      Properties properties = System.getProperties();
      properties.setProperty("mail.smtp.host", "localhost");
      Session session = Session.getDefaultInstance(properties);
      MimeMessage message = new MimeMessage(session);

      try {
        message.setFrom(new InternetAddress("mail@example.com"));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(customerEmail));

        message.setSubject("Your order placed on " + new Date());
        message.setText("Your order details: \n " + cart);

        Transport.send(message);
        System.out.println("Message sent successfully.");
      } catch (Exception ex) {
        Logger.error("Problem sending notification email", ex);
      }
    }
  }
}
