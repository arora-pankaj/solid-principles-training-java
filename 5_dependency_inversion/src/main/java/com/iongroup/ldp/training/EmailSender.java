package com.iongroup.ldp.training;

public class EmailSender {
  public void send(Email email) {
    System.out.print(
        "To:"
            + email.getTo()
            + ", Subject: "
            + email.getSubject()
            + ", Message: "
            + email.getMessage());
  }
}