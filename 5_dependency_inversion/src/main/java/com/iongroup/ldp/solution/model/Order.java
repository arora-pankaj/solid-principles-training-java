package com.iongroup.ldp.solution.model;

public abstract class Order {
  public Cart cart;

  public Order(Cart cart) {
    this.cart = cart;
  }

  public abstract void checkout() throws Exception;
}
