package com.adeleye;

import java.util.ArrayList;

public class Branch {

  private String branchName;
  private ArrayList<Customer> customerList;

  public Branch(String branchName) {
    this.branchName = branchName;
    this.customerList = new ArrayList<Customer>();
  }

  public String getBranchName() {
    return branchName;
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

  private Customer findCustomer(String customerName) {
    for (int i = 0; i < this.customerList.size(); i++) {
      Customer checkedCustomer = this.customerList.get(i);
      if (checkedCustomer.getName().equalsIgnoreCase(customerName)) {
        return checkedCustomer;
      }
    }
    return null;
  }

  public boolean customerExists(String customerName) {
    if (findCustomerIndex(customerName) >= 0) {
      return true;
    }
    return false;
  }

  public boolean addCustomer(String customerName, double initialDeposit) {
    if (findCustomerIndex(customerName) == -1) {
      Customer newCustomer = new Customer(customerName, initialDeposit);
      this.customerList.add(newCustomer);
      System.out.println(customerName + " Added with deposit : " + initialDeposit + " added");
      return true;
    }
    System.out.println("Customer with " + customerName + " already exists in branch");
    return false;
  }

  public boolean addCustomerTransaction(String customerName, double amount) {
    int customerIndex = findCustomerIndex(customerName);
    if (customerIndex >= 0) {
      this.customerList.get(customerIndex).addTransactions(amount);
      System.out.println(amount + " added to customer " + customerName + " account");
      return true;
    } else {
      System.out.println(customerName + " not found in branch");
      return false;

    }
  }

  public void showCustomers(boolean showTransactions) {
    System.out.println("Branch " + this.branchName);
    for (int i = 0; i < this.customerList.size(); i++) {
      Customer customer = this.customerList.get(i);
      System.out.println((i + 1) + ". Customer name: " + customer.getName()
          + "\nAccount Number: " + customer.getAccountNumber()
      );
      if (showTransactions) {
        ArrayList<Double> transactions = customer.getTransactions();
        for (int j = 0; j < transactions.size(); j++) {
          System.out.println("[" + (j + 1) + "] Amount => " + transactions.get(j));
        }
      }
      System.out.println("\n");
    }
  }

  public String getName() {
    return branchName;
  }
}
