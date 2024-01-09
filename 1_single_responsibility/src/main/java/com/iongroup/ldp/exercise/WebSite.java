package com.iongroup.ldp.exercise;

import com.iongroup.ldp.exercise.model.Cart;
import com.iongroup.ldp.exercise.model.Order;
import com.iongroup.ldp.exercise.model.PaymentDetails;
import com.iongroup.ldp.exercise.model.PaymentDetails.PaymentMethod;
import com.iongroup.ldp.exercise.utility.Logger;

public class WebSite {

  public WebSite(Cart cart) {
    try {
      new Order().checkout(cart, onlinePaymentDetails(), true);
    } catch (Exception e) {
      Logger.error("Problem booking cart order", e);
    }
  }

  private static PaymentDetails onlinePaymentDetails() {
    PaymentDetails paymentDetails = new PaymentDetails();

    paymentDetails.setPaymentMethod(PaymentMethod.CreditCard);
    paymentDetails.setCardholderName("");
    paymentDetails.setCreditCardNumber("");
    paymentDetails.setExpiresYear("");
    paymentDetails.setExpiresMonth("");

    return paymentDetails;
  }
}
