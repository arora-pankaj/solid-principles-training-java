package com.iongroup.ldp.exercise.services;

import com.iongroup.ldp.exercise.utility.exceptions.AvsMismatchException;

public class PaymentGateway {

  public String cardNumber;
  public String credentials;
  public String expiresMonth;
  public String expiresYear;
  public String nameOnCard;
  public float amountToCharge;

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public String getCredentials() {
    return credentials;
  }

  public void setCredentials(String credentials) {
    this.credentials = credentials;
  }

  public String getExpiresMonth() {
    return expiresMonth;
  }

  public void setExpiresMonth(String expiresMonth) {
    this.expiresMonth = expiresMonth;
  }

  public String getExpiresYear() {
    return expiresYear;
  }

  public void setExpiresYear(String expiresYear) {
    this.expiresYear = expiresYear;
  }

  public String getNameOnCard() {
    return nameOnCard;
  }

  public void setNameOnCard(String nameOnCard) {
    this.nameOnCard = nameOnCard;
  }

  public float getAmountToCharge() {
    return amountToCharge;
  }

  public void setAmountToCharge(float amountToCharge) {
    this.amountToCharge = amountToCharge;
  }

  public void charge() throws AvsMismatchException {
    // TODO implementation for deducting the amount
  }

  public void dispose() {}
}
