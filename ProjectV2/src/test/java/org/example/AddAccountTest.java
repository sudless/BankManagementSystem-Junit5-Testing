package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class AddAccountTest {

    private BankService bankService;

    @BeforeEach
    public void setUp() {

        bankService = new BankService();
    }

    @Test
    public void testAddAccount() {

        BankAccount newAccount = new CheckingAccount("SD2", 3000);
        boolean isAdded = bankService.addAccount(newAccount);
        BankAccount retrievedAccount = bankService.getAccount("SD2");

        assertTrue(isAdded);

        Assertions.assertNotNull(retrievedAccount);
        assertEquals(3000, retrievedAccount.getBalance());
    }

    @Test
    public void testAddingDuplicateAccount() {
        BankAccount newAccount = new CheckingAccount("SD2", 3000);
        bankService.addAccount(newAccount);
        BankAccount dupeAccount = new CheckingAccount("SD2", 3000);
        boolean isAdded = bankService.addAccount(dupeAccount);

        assertFalse(isAdded);

    }

}
