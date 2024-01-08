package com.iongroup.ldp.training;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BirdTest {
  private ByteArrayOutputStream consoleContent = new ByteArrayOutputStream();
  private final Bird bird = new Bird();

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(consoleContent));
  }

  @Test
  void run() {
    bird.run();
    assertEquals("Bird is running", consoleContent.toString());
  }

  @Test
  void fly() {
    bird.fly();
    assertEquals("Bird is flying", consoleContent.toString());
  }
}
