package com.iongroup.ldp.solution;

import com.iongroup.ldp.solution.interfaces.Movable;
import com.iongroup.ldp.solution.interfaces.Speakable;

public class SheriffWoody extends Toy implements Movable, Speakable {
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
    System.out.println("Woody is walking.");
  }

  @Override
  public void speak() {
    System.out.println("Woody is speaking.");
  }

  @Override
  public String toString() {
    return "The " + color + " Sheriff Woody toys's price is " + price + "$";
  }
}
