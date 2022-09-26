package com.adeleye;

import java.util.ArrayList;

public class Bank {

  private String bankName;
  private ArrayList<Branch> branchList;

  public Bank(String bankName) {
    this.bankName = bankName;
    this.branchList = new ArrayList<Branch>();
  }

  public int findBranchIndex(String branchName) {
    for (int i = 0; i < this.branchList.size(); i++) {
      Branch currentBranch = this.branchList.get(i);
      if (currentBranch.getBranchName().equalsIgnoreCase(branchName)) {
        return i;
      }
    }
    return -1;
  }

  public Branch findBranch(String branchName) {
    for (int i = 0; i < this.branchList.size(); i++) {
      Branch branch = this.branchList.get(i);
      if (branch.getName().equalsIgnoreCase(branchName)) {
        return branch;
      }
    }
    return null;
  }

  public boolean addBranch(String branchName) {
    if (findBranchIndex(branchName) >= 0) {
      System.out.println("Branch already exists");
      return false;
    } else {
      Branch newBranch = new Branch(branchName);
      branchList.add(newBranch);
      return true;
    }
  }

  public boolean newCustomer(String customerName, double initialDeposit, String branchName) {
    Branch customerBranch = findBranch(branchName);
    if (customerBranch != null) {
      return customerBranch.addCustomer(customerName, initialDeposit);
    } else {
      System.out.println("Branch does not exist OR customer already exists");
      return false;
    }
  }

  public boolean showTransactions(String branchName, boolean showTransactions) {
    int branchIndex = findBranchIndex(branchName);
    if (branchIndex >= 0) {
      this.branchList.get(branchIndex).showCustomers(showTransactions);
      return true;

    } else {
      System.out.println(bankName + " not found in " + bankName);
      return false;
    }
  }

}
