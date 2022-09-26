package com.adeleye;

import java.util.ArrayList;


public class Customer {

  private String name;
  public static int accountID = 10000;
  private String accountNumber;
  private ArrayList<Double> transactions;


  public Customer(String name, double initialDeposit) {
    this.name = name;
    this.accountNumber = String.valueOf(accountID++);
    this.transactions = new ArrayList<Double>();
    addTransactions(initialDeposit);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  public String getAccountNumber(){
    return accountNumber;
  }

  public ArrayList<Double> getTransactions() {
    return transactions;
  }

  public void addTransactions(double amount) {
    this.transactions.add(amount);
  }
}
