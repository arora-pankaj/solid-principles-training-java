package com.iongroup.ldp.exercise.utility;

public class Logger {

  public static void error(String message, Exception exception) {
    System.out.println(message);
    exception.printStackTrace();
  }
}
