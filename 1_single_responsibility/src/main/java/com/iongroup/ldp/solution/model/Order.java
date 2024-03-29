package com.iongroup.ldp.solution.model;

public abstract class Order {

  protected Cart cart;

  protected Order(Cart cart) {
    this.cart = cart;
  }

  public abstract void checkout() throws Exception;
}
