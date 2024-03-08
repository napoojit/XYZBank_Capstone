package com.crm.qa.testcases;

import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.TestBase.TestBase;
import com.crm.qa.pages.WithdrawalPage1;
import com.crm.qa.pages.CustomerLoginPage;

// Test class for deposit functionality
public class DepositTest extends TestBase {
    CustomerLoginPage loginPage;
    WithdrawalPage1 accountPage;
    String AccountexistUser = prop.getProperty("AccontExistUser");
    int ValidAmount = Integer.valueOf(prop.getProperty("ValidAmount"));
    int InValidAmount = Integer.valueOf(prop.getProperty("InValidAmount")); // Define InValidAmount

    // Constructor
    public DepositTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        try {
            loginPage = new CustomerLoginPage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        accountPage = loginPage.CustomerLogin(AccountexistUser);
    }

    // Test method to verify deposit with a valid amount
    @Test(priority = 1)
    public void VerifyDepositWithValidAmount() {
        // Verify the deposit with a valid amount
        accountPage.ValidDeposit("Deposit Successful", ValidAmount);
    }

    // Test method to verify deposit with an invalid amount
    @Test(priority = 2)
    public void VerifyDepositWithInvalidAmount() {
        // Verify the deposit with an invalid amount
        accountPage.InValidDeposit(InValidAmount);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
