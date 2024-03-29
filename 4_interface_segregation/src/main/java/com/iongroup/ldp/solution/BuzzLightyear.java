package com.iongroup.ldp.solution;

import com.iongroup.ldp.solution.interfaces.Flyable;
import com.iongroup.ldp.solution.interfaces.Movable;
import com.iongroup.ldp.solution.interfaces.Speakable;

public class BuzzLightyear extends Toy implements Movable, Flyable, Speakable {
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
    System.out.println("Buzz is walking.");
  }

  @Override
  public void fly() {
    System.out.println("Buzz is flying.");
  }

  @Override
  public void speak() {
    System.out.println("Buzz is speaking.");
  }

  @Override
  public String toString() {
    return "The " + color + " Buzz Lightyear toys's price is " + price + "$";
  }
}
