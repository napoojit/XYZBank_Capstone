package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.TestBase.TestBase;
import com.crm.qa.pages.WithdrawalPage1;
import com.crm.qa.pages.AddCustomerPage;
import com.crm.qa.pages.BankManagerNavigationPage;

public class BankManagerNavigationPageTest extends TestBase {
    BankManagerNavigationPage bankManagerPage;

    public BankManagerNavigationPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        try {
            bankManagerPage = new BankManagerNavigationPage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testBankManagerLogin() {
        // Perform Bank Manager Login
        AddCustomerPage accountPage = bankManagerPage.ManagerLogin();
        try {
            Thread.sleep(3000); // 3 seconds sleep
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Assertions
        Assert.assertNotNull(accountPage, "Bank Manager Login failed or did not navigate to the expected page.");
        // Add more assertions based on the expected behavior after Bank Manager Login
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
