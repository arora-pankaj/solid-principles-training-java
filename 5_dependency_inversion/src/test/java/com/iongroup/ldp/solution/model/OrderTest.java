package com.iongroup.ldp.solution.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.iongroup.ldp.solution.fakes.FakeNotificationService;
import com.iongroup.ldp.solution.fakes.FakePaymentProcessor;
import com.iongroup.ldp.solution.fakes.FakeReservationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderTest {
  private final FakePaymentProcessor paymentProcessor = new FakePaymentProcessor();
  private final FakeReservationService reservationService = new FakeReservationService();
  private final FakeNotificationService notificationService = new FakeNotificationService();
  private final Cart cart = new Cart();
  private final PaymentDetails paymentDetails = new PaymentDetails();

  @BeforeEach
  public void setup() {
    paymentDetails.setPaymentMethod(PaymentDetails.PaymentMethod.CreditCard);
  }

  @Test
  public void sendTotalAmountToPaymentProcessor() throws Exception {
    cart.setTotalAmount(500);

    OnlineOrder order =
        new OnlineOrder(
            cart, paymentProcessor, paymentDetails, reservationService, notificationService);

    order.checkout();

    assertTrue(paymentProcessor.wasCalled);
    assertEquals(cart.getTotalAmount(), paymentProcessor.amountPassed, 0);
  }

  @Test
  public void notFailWhenSendingNotification() throws Exception {
    cart.setCustomerEmail("someone@somewhere.com");

    OnlineOrder order =
        new OnlineOrder(
            cart, paymentProcessor, paymentDetails, reservationService, notificationService);

    order.checkout();

    assertTrue(notificationService.wasCalled);
  }

  @Test
  public void notFailWhenReservingInventory() throws Exception {
    OnlineOrder order =
        new OnlineOrder(
            cart, paymentProcessor, paymentDetails, reservationService, notificationService);

    order.checkout();

    assertTrue(reservationService.wasCalled);
  }
}
