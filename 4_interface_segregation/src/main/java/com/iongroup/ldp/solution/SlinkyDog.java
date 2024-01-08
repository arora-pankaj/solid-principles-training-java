package com.iongroup.ldp.solution;

import com.iongroup.ldp.solution.interfaces.Movable;

public class SlinkyDog extends Toy implements Movable {
  private int price;
  private String color;

  @Override
  public void setPrice(int price) {
    this.price = price;
  }

  @Override
  public void setColor(String color) {
    this.color = color;
  }

  @Override
  public void move() {
    System.out.println("Slinky is walking.");
  }

  @Override
  public String toString() {
    return "The " + color + " Slinky Dog toys's price is " + price + "$";
  }
}
