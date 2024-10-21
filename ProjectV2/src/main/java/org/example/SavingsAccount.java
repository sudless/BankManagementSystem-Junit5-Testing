package org.example;

public class SavingsAccount extends BankAccount{

    private final double interestRate;

    public SavingsAccount(String accountNum, double initialBalance, double interestRate){
        super(accountNum, initialBalance);
        this.interestRate= interestRate;
    }

    @Override
    public void applyInterest() {
        double interest = getBalance() * (interestRate / 100);
        deposit(interest);
    }
    public int getInterestRate(){
        return (int)interestRate;
    }
}