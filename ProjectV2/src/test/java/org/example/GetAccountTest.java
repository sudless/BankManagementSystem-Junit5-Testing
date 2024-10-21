package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class GetAccountTest {
    private BankService bankService;
    private BankAccount account1;

    @BeforeEach
    public void setUp() {
        bankService = new BankService();
        account1 = new CheckingAccount("SD123", 1500);
        bankService.addAccount(account1);
    }

    @Test
    public void testGetExistingAccount() {
        BankAccount retrievedAccount = bankService.getAccount("SD123");

        assertSame(account1, retrievedAccount, "Retrieved account should be the same as the added account");
    }

    @Test
    public void testGetNonExistingAccount() {
        BankAccount nonExistentAccount = bankService.getAccount("SD999");
        assertNull(nonExistentAccount, "Should return null for a non-existent account number");
    }
}

