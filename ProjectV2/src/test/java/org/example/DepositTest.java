package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DepositTest {

    private BankService bankService;

    @Test
    public void testDeposit() {

        BankService bankService = new BankService();

        BankAccount account = new CheckingAccount("SD", 1000);
        bankService.addAccount(account);

        Assertions.assertNotNull(account);

        account.deposit(500);
        assertEquals(1500, account.getBalance());
    }

    @ParameterizedTest
    @ValueSource(doubles = {500, 1000})
    public void testDepositParameterized(double amount) {

        BankService bankService = new BankService();
        BankAccount account = new CheckingAccount("SD", 1000);
        bankService.addAccount(account);
        BankAccount retrievedAccount = bankService.getAccount("SD");
        Assertions.assertNotNull(retrievedAccount);

        account.deposit(amount);

        double expectedBalance = 1000 + amount;
        assertEquals(expectedBalance, retrievedAccount.getBalance());

    }


}
