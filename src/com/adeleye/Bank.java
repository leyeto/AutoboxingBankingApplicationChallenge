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

  public void addBranch(String branchName) {
    if (findBranchIndex(branchName) >= 0) {
      System.out.println("Branch already exists");
    } else {
      Branch newBranch = new Branch(branchName);
      branchList.add(newBranch);
    }
  }

  public void newCustomer(String customerName, double initialDeposit, String branchName) {
    int branchIndex = findBranchIndex(branchName);
    if (branchIndex >= 0
        && this.branchList.get(branchIndex).customerExists(customerName) == false) {
      this.branchList.get(branchIndex).addCustomer(customerName,initialDeposit);
    } else {
      System.out.println("Branch does not exist OR customer already exists");
    }
  }

  public void showTransactions(String bankName,boolean showTransactions){
    int branchIndex = findBranchIndex(bankName);
    if(branchIndex >=0){
      this.branchList.get(branchIndex).showCustomers(showTransactions);

    }else {
      System.out.println(bankName + " not found in " + bankName);
    }
  }

}
