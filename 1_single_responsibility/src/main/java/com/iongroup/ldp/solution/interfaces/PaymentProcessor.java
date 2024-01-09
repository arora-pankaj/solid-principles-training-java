package com.iongroup.ldp.solution.interfaces;

import com.iongroup.ldp.solution.model.PaymentDetails;

public interface PaymentProcessor {
  void processCreditCard(PaymentDetails paymentDetails, float amount) throws Exception;
}
