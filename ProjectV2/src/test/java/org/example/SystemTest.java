package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;


public class SystemTest {

    private BankService bankService;



    @BeforeEach
    public void setUp() {

        bankService = new BankService();

        bankService.addAccount(new CheckingAccount("SD", 1000));
        bankService.addAccount(new SavingsAccount("ID", 2000, 3));

    }


    @Test
    public void testInterestCalculation() {
        SavingsAccount account = (SavingsAccount) bankService.getAccount("ID");
        Assertions.assertNotNull(account);

        account.applyInterest();
        double expectedBalance = 2000 + ((double) (2000 * account.getInterestRate()) / 100);
        assertEquals(expectedBalance, account.getBalance());

    }


}
