package com.iongroup.ldp.solution;

import com.iongroup.ldp.solution.model.Cart;
import com.iongroup.ldp.solution.model.Order;
import com.iongroup.ldp.solution.model.PaymentDetails;
import com.iongroup.ldp.solution.model.PaymentDetails.PaymentMethod;
import com.iongroup.ldp.solution.model.PosCashOrder;
import com.iongroup.ldp.solution.model.PosCreditOrder;

public class RetailPointOfTheSale {

  public RetailPointOfTheSale(
      Cart cart, PaymentDetails paymentDetails, PaymentDetails.PaymentMethod paymentMethod)
      throws Exception {

    Order order;

    if (paymentMethod == PaymentMethod.Cash) {
      order = new PosCashOrder(cart);
    } else {
      order = new PosCreditOrder(cart, paymentDetails);
    }

    order.checkout();
  }
}
