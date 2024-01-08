package com.iongroup.ldp.violation.withTellDontAskPrinciple;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class AreaCalculatorTest {
  @Test
  public void CalculateSquareArea() {
    Square square = new Square(4);
    assertEquals(16, square.area());
  }

  @Test
  public void CalculateRectangleArea() {
    Rectangle rectangle = new Rectangle(4, 5);
    assertEquals(20, rectangle.area());
  }

  @Test
  public void CalculateIsSubstitutableForArea() {

    List<Shape> shapes = new ArrayList<>();

    shapes.add(new Square(3));
    shapes.add(new Rectangle(3, 4));
    shapes.add(new Triangle(3, 5));

    double[] areas = new double[3];

    for (Shape shape : shapes) {
      if (shape instanceof Square) {
        areas[0] = (((Square) shape).area());
      } else if (shape instanceof Rectangle) {
        areas[1] = (((Rectangle) shape).area());
      } else if (shape instanceof Triangle) {
        areas[2] = (((Triangle) shape).area());
      }
    }

    assertEquals(areas[0], 9, 0);
    assertEquals(areas[1], 12, 0);
    assertEquals(areas[2], 7.5, 0);
  }
}
