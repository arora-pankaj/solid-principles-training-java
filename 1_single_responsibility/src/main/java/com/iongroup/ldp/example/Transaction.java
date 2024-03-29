package com.iongroup.ldp.example;

import java.time.LocalDate;

public class Transaction {
  private final LocalDate date;
  private final int amount;

  Transaction(LocalDate date, int amount) {
    this.date = date;
    this.amount = amount;
  }

  public LocalDate date() {
    return date;
  }

  public int amount() {
    return amount;
  }
}
