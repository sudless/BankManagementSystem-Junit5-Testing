package org.example;

public class Transaction {


    BankService bankService;

    public boolean makeTransaction(BankAccount account1, BankAccount account2, double amount){
        double balance1 = account1.getBalance();
        if(amount <= 0){
           System.out.println("Amount you entered: "+ amount + " is lower or equal to 0!");
            return false;
        }else if(balance1 >= amount){
            account2.deposit(amount);
            account1.withdraw(amount);
            return true;
        }
        else{
            return false;
        }
    }

}