package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import com.crm.qa.TestBase.TestBase;
import com.crm.qa.pages.WithdrawalPage1;
import com.crm.qa.pages.CustomerLoginPage;

// Test class for Withdrawal functionality
public class WithdrawalTest extends TestBase {
    CustomerLoginPage loginPage;
    WithdrawalPage1 accountPage;
    String AccountexistUser = prop.getProperty("AccontExistUser");
    String AccountNot_existUser = prop.getProperty("AccontNot_ExistUser");
    int ValidAmount = Integer.valueOf(prop.getProperty("ValidAmount"));
    int InValidAmount = Integer.valueOf(prop.getProperty("InValidAmount"));
    String Successfull = prop.getProperty("Successfull");
    String inSufficient = prop.getProperty("inSufficient");
    int InSufficient_Amount = Integer.valueOf(prop.getProperty("InSufficient_Amount"));

    // Constructor
    public WithdrawalTest() {
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

    // Test method to verify withdrawal with a valid amount
    @Test(priority = 1)
    public void VerifyWithdrawWithValidAmount() throws InterruptedException {
        accountPage.ValidWithdraw(Successfull, ValidAmount);
    }

    // Test method to verify withdrawal with an invalid amount
    @Test(priority = 2)
    public void VerifyWithdrawWithInvalidAmount() throws InterruptedException {
        accountPage.InValidWithdraw(InValidAmount);
    }

    // Test method to verify withdrawal with insufficient balance
    @Test(priority = 3)
    public void VerifyWithdrawWithInsufficientBalance() throws InterruptedException {
        accountPage.ValidWithdraw(inSufficient, InSufficient_Amount);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
