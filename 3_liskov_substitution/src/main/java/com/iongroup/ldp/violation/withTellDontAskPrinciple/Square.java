package com.iongroup.ldp.violation.withTellDontAskPrinciple;

public class Square extends Shape {
  private int side;

  public Square(int side) {
    this.side = side;
  }

  public int area() {
    return side * side;
  }
}