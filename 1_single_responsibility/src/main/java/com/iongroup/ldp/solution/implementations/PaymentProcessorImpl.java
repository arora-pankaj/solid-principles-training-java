package com.iongroup.ldp.solution.implementations;

import com.iongroup.ldp.solution.interfaces.PaymentProcessor;
import com.iongroup.ldp.solution.model.PaymentDetails;
import com.iongroup.ldp.solution.services.PaymentGateway;
import com.iongroup.ldp.solution.utility.Exceptions.AvsMismatchException;
import com.iongroup.ldp.solution.utility.Exceptions.OrderException;

public class PaymentProcessorImpl implements PaymentProcessor {

  @Override
  public void processCreditCard(PaymentDetails paymentDetails, float amount) throws Exception {
    PaymentGateway paymentGateway = new PaymentGateway();

    try {
      paymentGateway.credentials = "account credentials";
      paymentGateway.cardNumber = paymentDetails.getCreditCardNumber();
      paymentGateway.expiresMonth = paymentDetails.getExpiresMonth();
      paymentGateway.expiresYear = paymentDetails.getExpiresYear();
      paymentGateway.nameOnCard = paymentDetails.getCardholderName();
      paymentGateway.amountToCharge = amount;

      paymentGateway.charge();
    } catch (AvsMismatchException ex) {
      throw new OrderException(
          "The card gateway rejected the card based on the address provided.", ex);
    } catch (Exception ex) {
      throw new OrderException("There was a problem with your card.", ex);
    }
  }
}
