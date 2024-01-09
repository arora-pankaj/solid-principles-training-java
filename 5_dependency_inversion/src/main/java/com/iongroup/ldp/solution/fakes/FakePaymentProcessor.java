package com.iongroup.ldp.solution.fakes;

import com.iongroup.ldp.solution.interfaces.PaymentProcessService;
import com.iongroup.ldp.solution.model.Cart;
import com.iongroup.ldp.solution.model.PaymentDetails;

public class FakePaymentProcessor implements PaymentProcessService {
  public float amountPassed = 0;
  public boolean wasCalled = false;

  @Override
  public void processPayment(PaymentDetails paymentDetails, Cart cart) {
    wasCalled = true;
    amountPassed = cart.getTotalAmount();
  }
}
