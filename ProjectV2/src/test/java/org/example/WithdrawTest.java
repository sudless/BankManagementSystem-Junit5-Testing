package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WithdrawTest {


    @Test
    public void testWithdraw() {

        BankService bankService = new BankService();
        BankAccount account = new CheckingAccount("SD2", 3000);
        bankService.addAccount(account);
        Assertions.assertNotNull(account);

        boolean successfulWithdraw = account.withdraw(500);
        assertTrue(successfulWithdraw);
        assertEquals(2500, account.getBalance(), 0);

    }
}
