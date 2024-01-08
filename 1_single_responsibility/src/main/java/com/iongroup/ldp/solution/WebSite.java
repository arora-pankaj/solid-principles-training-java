package com.iongroup.ldp.solution;

import com.iongroup.ldp.solution.model.Cart;
import com.iongroup.ldp.solution.model.OnlineOrder;
import com.iongroup.ldp.solution.model.PaymentDetails;

public class WebSite {

  public WebSite(Cart cart, PaymentDetails paymentDetails) throws Exception {
    new OnlineOrder(cart, paymentDetails).checkout();
  }
}
