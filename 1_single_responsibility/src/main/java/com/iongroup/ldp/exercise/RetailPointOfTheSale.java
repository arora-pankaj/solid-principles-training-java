package com.iongroup.ldp.exercise;

import com.iongroup.ldp.exercise.model.Cart;
import com.iongroup.ldp.exercise.model.Order;
import com.iongroup.ldp.exercise.model.PaymentDetails;
import com.iongroup.ldp.exercise.model.PaymentDetails.PaymentMethod;
import com.iongroup.ldp.exercise.utility.Logger;

public class RetailPointOfTheSale {

  public RetailPointOfTheSale(Cart cart) {
    try {
      new Order().checkout(cart, posPaymentDetails(), false);
    } catch (Exception e) {
      Logger.error("Problem booking cart order", e);
    }
  }

  private static PaymentDetails posPaymentDetails() {
    PaymentDetails paymentDetails = new PaymentDetails();

    paymentDetails.setPaymentMethod(PaymentMethod.Cash);

    return paymentDetails;
  }
}
