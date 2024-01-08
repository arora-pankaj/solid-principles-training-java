package com.iongroup.ldp.violation.model;

import com.iongroup.ldp.violation.model.Cart.OrderItem;
import com.iongroup.ldp.violation.model.PaymentDetails.PaymentMethod;
import com.iongroup.ldp.violation.services.InventorySystem;
import com.iongroup.ldp.violation.services.PaymentGateway;
import com.iongroup.ldp.violation.utility.Logger;
import com.iongroup.ldp.violation.utility.exceptions.AvsMismatchException;
import com.iongroup.ldp.violation.utility.exceptions.InsufficientInventoryException;
import com.iongroup.ldp.violation.utility.exceptions.OrderException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Order {

  public void checkout(Cart cart, PaymentDetails paymentDetails, boolean notifyCustomer)
      throws Exception {
    if (paymentDetails.getPaymentMethod() == PaymentMethod.CreditCard) {
      chargeCard(paymentDetails, cart);
    }

    reserveInventory(cart);

    if (notifyCustomer) {
      notifyCustomer(cart);
    }
  }

  private void notifyCustomer(Cart cart) {
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

  private void reserveInventory(Cart cart) throws Exception {
    for (OrderItem item : cart.getItems()) {
      try {
        InventorySystem inventorySystem = new InventorySystem();
        inventorySystem.reserve(item.getSku(), item.getQuantity());
      } catch (InsufficientInventoryException ex) {
        throw new OrderException("Insufficient inventory for item " + item.getSku(), ex);
      } catch (Exception ex) {
        throw new OrderException("Problem reserving inventory", ex);
      }
    }
  }

  private void chargeCard(PaymentDetails paymentDetails, Cart cart) throws Exception {
    PaymentGateway paymentGateway = new PaymentGateway();

    try {
      paymentGateway.credentials = "account credentials";
      paymentGateway.cardNumber = paymentDetails.getCreditCardNumber();
      paymentGateway.expiresMonth = paymentDetails.getExpiresMonth();
      paymentGateway.expiresYear = paymentDetails.getExpiresYear();
      paymentGateway.nameOnCard = paymentDetails.getCardholderName();
      paymentGateway.amountToCharge = cart.getTotalAmount();

      paymentGateway.charge();
    } catch (AvsMismatchException ex) {
      throw new OrderException(
          "The card gateway rejected the card based on the address provided.", ex);
    } catch (Exception ex) {
      throw new OrderException("There was a problem with your card.", ex);
    }
  }
}
