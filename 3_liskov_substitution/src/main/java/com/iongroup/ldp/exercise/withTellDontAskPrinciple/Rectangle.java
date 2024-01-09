package com.iongroup.ldp.exercise.withTellDontAskPrinciple;

public class Rectangle extends Shape {
  private int width;
  private int height;

  public Rectangle(int width, int height) {
    this.width = width;
    this.height = height;
  }

  public int area() {
    return width * height;
  }
}
