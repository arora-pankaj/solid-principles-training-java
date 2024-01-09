package com.iongroup.ldp.example;

import java.util.List;

public interface TransactionRepository {
  void add(Transaction transaction);

  List<Transaction> all();
}
