package com.iongroup.ldp.solution.model;

import com.iongroup.ldp.solution.implementations.ImplNotificationService;
import com.iongroup.ldp.solution.implementations.ImplPaymentProcessor;
import com.iongroup.ldp.solution.implementations.ImplReservationService;
import com.iongroup.ldp.solution.interfaces.INotificationService;
import com.iongroup.ldp.solution.interfaces.IPaymentProcessor;
import com.iongroup.ldp.solution.interfaces.IReservationService;

public class OnlineOrder extends Order {

  private INotificationService notificationService;
  private PaymentDetails paymentDetails;
  private IPaymentProcessor paymentProcessor;
  private IReservationService reservationService;

  public OnlineOrder(Cart cart, PaymentDetails paymentDetails) {
    super(cart);
    this.paymentDetails = paymentDetails;
    this.paymentProcessor = new ImplPaymentProcessor();
    this.reservationService = new ImplReservationService();
    this.notificationService = new ImplNotificationService();
  }

  @Override
  public void checkout() throws Exception {

    paymentProcessor.processCreditCard(paymentDetails, cart.getTotalAmount());

    reservationService.reserveInventory(cart.getItems());

    notificationService.notifyCustomerOrderCreated(cart);

    // TODO save order record on database
  }
}
