package com.adeleye;

public class Main {

  public static void main(String[] args) {
    Branch branch = new Branch("London");
    branch.addCustomer("Sam",120.00);
    branch.addCustomer("Joe",220.00);
    branch.showCustomers(true);

  }
}