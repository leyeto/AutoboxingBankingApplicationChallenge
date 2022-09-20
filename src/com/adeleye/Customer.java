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
}
