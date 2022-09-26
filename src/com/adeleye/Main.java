package com.adeleye;

public class Main {

  public static void main(String[] args) {
    Bank bank = new Bank("Shooter Bank");
    bank.addBranch("London");
    bank.newCustomer("Sam Hook", 1200, "London");
    bank.showTransactions("London",true);


  }
}