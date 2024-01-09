package com.iongroup.ldp.solution.model;

import com.iongroup.ldp.solution.implementations.NotificationServiceImpl;
import com.iongroup.ldp.solution.implementations.PaymentProcessorImpl;
import com.iongroup.ldp.solution.implementations.ReservationServiceImpl;
import com.iongroup.ldp.solution.interfaces.NotificationService;
import com.iongroup.ldp.solution.interfaces.PaymentProcessor;
import com.iongroup.ldp.solution.interfaces.ReservationService;

public class OnlineOrder extends Order {

  private final NotificationService notificationService;
  private final PaymentDetails paymentDetails;
  private final PaymentProcessor paymentProcessor;
  private final ReservationService reservationService;

  public OnlineOrder(Cart cart, PaymentDetails paymentDetails) {
    super(cart);
    this.paymentDetails = paymentDetails;
    this.paymentProcessor = new PaymentProcessorImpl();
    this.reservationService = new ReservationServiceImpl();
    this.notificationService = new NotificationServiceImpl();
  }

  @Override
  public void checkout() throws Exception {

    paymentProcessor.processCreditCard(paymentDetails, cart.getTotalAmount());

    reservationService.reserveInventory(cart.getItems());

    notificationService.notifyCustomerOrderCreated(cart);
  }
}
