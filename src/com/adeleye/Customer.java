package com.adeleye;

import java.util.ArrayList;

public class Customer {
  private String name;
  private String accountNumber;
  private ArrayList<Double> transactions;


  public Customer(String name, String accountNumber) {
    this.name = name;
    this.accountNumber = accountNumber;
    this.transactions = new ArrayList<Double>();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public ArrayList<Double> getTransactions() {
    return transactions;
  }

  public void addTransactions(double amount) {
    this.transactions.add(amount);
  }
}
