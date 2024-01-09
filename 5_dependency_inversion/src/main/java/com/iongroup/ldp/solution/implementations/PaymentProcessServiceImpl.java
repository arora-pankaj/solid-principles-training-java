package com.iongroup.ldp.solution.implementations;

import com.iongroup.ldp.solution.interfaces.PaymentProcessService;
import com.iongroup.ldp.solution.model.Cart;
import com.iongroup.ldp.solution.model.PaymentDetails;
import com.iongroup.ldp.solution.services.PaymentGateway;
import com.iongroup.ldp.solution.utility.Exceptions.AvsMismatchException;
import com.iongroup.ldp.solution.utility.Exceptions.OrderException;

public class PaymentProcessServiceImpl implements PaymentProcessService {
  @Override
  public void processPayment(PaymentDetails paymentDetails, Cart cart) throws Exception {
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
      throw new AvsMismatchException(
          "The card gateway rejected the card based on the address provided.", ex);
    } catch (Exception ex) {
      throw new OrderException("There was a problem with your card.", ex);
    }
  }
}
