package org.example;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        WithdrawTest.class,
        DepositTest.class})
public class DepositWithdrawTestSuite {
    

}
