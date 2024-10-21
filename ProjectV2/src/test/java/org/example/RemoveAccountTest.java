package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RemoveAccountTest {

    @Test
    public void testRemoveAccount() {

        BankService bankService = new BankService();

        BankAccount account = new CheckingAccount("ID", 1000);
        bankService.addAccount(account);

        boolean isRemoved = bankService.removeAccount("ID");

        assertTrue(isRemoved);  // 3. assertTrue
        assertNull(bankService.getAccount("ID"));

    }


//    @ParameterizedTest
//    @ValueSource(strings = {"ID", "ID2", "ID3"})  // Sample account IDs to remove
//    public void removeAccountParameterized(String accountId) {
//        BankService bankService = new BankService();
//
//        // Add accounts with the same ID for testing
//        BankAccount account = new CheckingAccount(accountId, 1000);
//        bankService.addAccount(account);
//
//        // Remove the account using the parameterized accountId
//        boolean isRemoved = bankService.removeAccount(accountId);
//
//        // Assertions
//        assertTrue(isRemoved);  // Check if the account was removed
//        assertNull(bankService.getAccount(accountId));  // Ensure the account is no longer available
//
//        System.out.println("Account ID " + accountId + " removed");
//    }
}

