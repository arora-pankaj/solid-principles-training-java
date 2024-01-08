package com.iongroup.ldp.solution.model;

import com.iongroup.ldp.solution.interfaces.INotification;
import com.iongroup.ldp.solution.interfaces.IPaymentProcess;
import com.iongroup.ldp.solution.interfaces.IReservation;

public class OnlineOrder extends Order {
  private final PaymentDetails paymentDetails;
  private final IReservation reservation;
  private final IPaymentProcess paymentProcess;
  private final INotification notifier;

  public OnlineOrder(
      Cart cart,
      IPaymentProcess paymentProcess,
      PaymentDetails paymentDetails,
      IReservation reservation,
      INotification notifier) {
    super(cart);
    this.paymentProcess = paymentProcess;
    this.paymentDetails = paymentDetails;
    this.reservation = reservation;
    this.notifier = notifier;
  }

  @Override
  public void checkout() throws Exception {
    paymentProcess.processPayment(paymentDetails, cart);
    reservation.reserveInventory(cart);
    notifier.notifyCustomer(cart);
  }
}
