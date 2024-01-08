package com.iongroup.ldp.solution;

public class Triangle extends Shape {
  private final int base;
  private final int height;

  public Triangle(int base, int height) {
    this.base = base;
    this.height = height;
  }

  @Override
  public double area() {
    return 0.5 * base * height;
  }
}
