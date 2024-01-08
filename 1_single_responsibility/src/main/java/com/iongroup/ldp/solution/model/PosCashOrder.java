package com.iongroup.ldp.solution.model;

public class PosCashOrder extends Order {

  public PosCashOrder(Cart cart) {
    super(cart);
  }

  @Override
  public void checkout() throws Exception {
    // TODO save order record on database
  }
}
