package com.adeleye;

import java.util.ArrayList;

public class Branch {

  private String branchName;
  private ArrayList<Customer> customerList;

  public Branch(String branchName, ArrayList<Customer> customerList) {
    this.branchName = branchName;
    this.customerList = new ArrayList<Customer>();
  }

  private int findCustomerIndex(String customerName) {
    for (int i = 0; i < this.customerList.size(); i++) {
      String nameLowered = this.customerList.get(i).getName().toLowerCase();
      if (nameLowered.equals(customerName.toLowerCase())) {
        return i;
      }
    }
    return -1;
  }

  public void addCustomer(String customerName, String customerAccountNumber,
      double initialDeposit) {
    if (findCustomerIndex(customerName) == -1) {
      Customer newCustomer = new Customer(customerName, customerAccountNumber);
      newCustomer.addTransactions(initialDeposit);
      System.out.println(customerName + " Added with deposit : " + initialDeposit + " added");
      return;
    }
    System.out.println("Customer with " + customerName + " already exists in branch");
  }

  public void addCustomerTransaction(String customerName, double amount) {
    int customerIndex = findCustomerIndex(customerName);
    if (customerIndex >= 0) {
      this.customerList.get(customerIndex).addTransactions(amount);
      System.out.println(amount + " added to customer " + customerName + " account");
    } else {
      System.out.println(customerName + " not found in branch");
    }
  }

  public void showCustomers(boolean showTransactions){
    for (int i = 0; i < this.customerList.size(); i++){
      System.out.println("Customer name: " + this.customerList.get(i).getName());
    }
  }
}
