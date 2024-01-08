package com.iongroup.ldp.solution.interfaces;

import com.iongroup.ldp.solution.model.Cart;
import com.iongroup.ldp.solution.model.PaymentDetails;

public interface IPaymentProcess {
   void processPayment(PaymentDetails paymentDetails, Cart cart) throws Exception;
}
