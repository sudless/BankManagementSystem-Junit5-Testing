package org.example;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SelectClasses;

@Suite
@SelectClasses({
        AddAccountTest.class,
        RemoveAccountTest.class})
public class AddRemoveAccountTestSuite {


}
