package com.iongroup.ldp.solution.model;

import com.iongroup.ldp.solution.implementations.ImplPaymentProcessor;
import com.iongroup.ldp.solution.interfaces.IPaymentProcessor;

public class PosCreditOrder extends Order {

  private PaymentDetails paymentDetails;
  private IPaymentProcessor paymentProcessor;

  public PosCreditOrder(Cart cart, PaymentDetails paymentDetails) {
    super(cart);
    this.paymentDetails = paymentDetails;
    this.paymentProcessor = new ImplPaymentProcessor();
  }

  @Override
  public void checkout() throws Exception {
    paymentProcessor.processCreditCard(paymentDetails, cart.getTotalAmount());
    // TODO save order record on database
  }
}
