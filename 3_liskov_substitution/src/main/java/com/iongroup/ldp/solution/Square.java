package com.iongroup.ldp.solution;

public class Square extends Shape {
  private final int side;

  public Square(int side) {
    this.side = side;
  }

  @Override
  public double area() {
    return side * side;
  }
}
