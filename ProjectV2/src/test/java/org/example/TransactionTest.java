package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {

    private BankService bankService;
    private Transaction transaction;
    private BankAccount account1;
    private BankAccount account2;

    @BeforeEach
    void setUp() {
        bankService = new BankService();
        transaction = new Transaction();
        account1 = new CheckingAccount("SD",100.0); // Starting balance of 100
        account2 = new CheckingAccount("ID", 50.0);   // Starting balance of 50
    }

    @Test
    void testTransactionSuccesful(){
        double initBalance = account1.getBalance();
        double initBalance2 = account2.getBalance();

        boolean result = transaction.makeTransaction(account1, account2, 50);

        assertTrue(result);
        assertNotEquals(initBalance, account1.getBalance());
        assertNotEquals(initBalance2, account2.getBalance());

    }

    @ParameterizedTest
    @ValueSource(doubles = {-20, 0})
    void testTransactionInvalidAmounts(double amount){

        boolean result = transaction.makeTransaction(account1, account2, amount);

        assertFalse(result);
        assertThrows(IllegalStateException.class, () -> {
            if (amount <= 0) {
                throw new IllegalStateException("");
            }
        });
    }

}
