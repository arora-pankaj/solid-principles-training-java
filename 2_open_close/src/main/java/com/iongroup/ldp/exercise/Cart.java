package com.iongroup.ldp.exercise;

import java.util.ArrayList;
import java.util.List;

public class Cart {

  private final List<OrderItem> items;

  public Cart() {
    this.items = new ArrayList<>();
  }

  public void add(OrderItem orderItem) {
    items.add(orderItem);
  }

  public float totalAmount() {

    float total = 0;

    for (OrderItem orderItem : items) {
      if (orderItem.getSku().startsWith("EACH")) {
        total += orderItem.getQuantity() * 2;
      } else if (orderItem.getSku().startsWith("WEIGHT")) {
        // quantity is in grams, price is per kg
        total += (float) (orderItem.getQuantity() * 6) / 1000;
      } else if (orderItem.getSku().startsWith("SPECIAL")) {
        // $0.40 each; 3 for a $1.00
        total += (float) (orderItem.getQuantity() * .4);
        int setsOfThree = orderItem.getQuantity() / 3;
        total -= (float) (setsOfThree * .2);
      }
      // more rules are coming!
    }

    return total;
  }
}
