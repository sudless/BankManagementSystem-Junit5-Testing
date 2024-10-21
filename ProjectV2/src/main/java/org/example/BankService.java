package org.example;

import java.util.ArrayList;
import java.util.List;


public class BankService {
    private final List<BankAccount> accounts = new ArrayList<>();

    public boolean addAccount(BankAccount account){

        for(BankAccount acc: accounts){
            if(acc.getAccountNum().equals(account.getAccountNum())){
                return false;
            }
        }
        accounts.add(account);
        return true;
    }

    public boolean removeAccount(String accountId) {
        // Loop through the accounts list to find the account with the given ID
        for (BankAccount account : accounts) {
            if (account.getAccountNum().equals(accountId)) {
                accounts.remove(account); // Remove the account
                return true; // Return true if the account was found and removed
            }
        }
        return false; // Return false if the account was not found
    }

    public BankAccount getAccount(String accountNum){
        for(BankAccount account: accounts){
            if(account.getAccountNum().equals(accountNum)){
                return account;
            }
        }
        return null;
    }



    public void applyInterestToSavings(){
        for(BankAccount account: accounts){
            if(account instanceof SavingsAccount){
                account.applyInterest();
            }
        }
    }
}
