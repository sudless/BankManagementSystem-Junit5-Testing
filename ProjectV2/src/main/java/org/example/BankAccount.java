package org.example;

public abstract class BankAccount {
    private final String accountNum;
    private double balance;

    public BankAccount(String accountNum, double initialBalance){
        this.accountNum = accountNum;
        this.balance= initialBalance;
    }

    public String getAccountNum(){
        return accountNum;
    }
    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
        }
    }

    public boolean withdraw(double amount){
        if(amount > 0 && amount <= balance){
            balance -= amount;
            return true;
        }
        return false;
    }

    public abstract void applyInterest();
}