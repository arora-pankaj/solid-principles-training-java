package com.iongroup.ldp.violation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CartTest {

  private Cart cart;

  @BeforeEach
  public void Setup() {
    cart = new Cart();
  }

  @Test
  public void ZeroWhenEmpty() {
    assertEquals(0, cart.totalAmount());
  }

  @Test
  public void EachItem() {
    cart.Add(new OrderItem("EACH_WIDGET", 1));
    assertEquals(2, cart.totalAmount());
  }

  @Test
  public void WeightItem() {
    cart.Add(new OrderItem("WEIGHT_PEANUTS", 500));
    assertEquals(3, cart.totalAmount());
  }

  @Test
  public void SpecialItemRegular() {
    cart.Add(new OrderItem("SPECIAL_CANDYBAR", 6));
    assertEquals(2, cart.totalAmount());
  }

  @Test
  public void SpecialItemFloat() {
    cart.Add(new OrderItem("SPECIAL_CANDYBAR", 2));
    assertEquals(0.8f, cart.totalAmount());
  }
}
