package com.iongroup.ldp.solution.model;

import com.iongroup.ldp.solution.interfaces.NotificationService;
import com.iongroup.ldp.solution.interfaces.PaymentProcessService;
import com.iongroup.ldp.solution.interfaces.ReservationService;

public class OnlineOrder extends Order {
  private final PaymentDetails paymentDetails;
  private final ReservationService reservationService;
  private final PaymentProcessService paymentProcessService;
  private final NotificationService notifier;

  public OnlineOrder(
      Cart cart,
      PaymentProcessService paymentProcessService,
      PaymentDetails paymentDetails,
      ReservationService reservationService,
      NotificationService notifier) {
    super(cart);
    this.paymentProcessService = paymentProcessService;
    this.paymentDetails = paymentDetails;
    this.reservationService = reservationService;
    this.notifier = notifier;
  }

  @Override
  public void checkout() throws Exception {
    paymentProcessService.processPayment(paymentDetails, cart);
    reservationService.reserveInventory(cart);
    notifier.notifyCustomer(cart);
  }
}
