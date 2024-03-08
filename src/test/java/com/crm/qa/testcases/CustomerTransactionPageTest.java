package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import com.crm.qa.TestBase.TestBase;
import com.crm.qa.pages.CustomerTransactionPage;
import com.crm.qa.pages.CustomerLoginPage;

// Test class for CustomerTransactionPage
public class CustomerTransactionPageTest extends TestBase {
    CustomerLoginPage loginPage;
    CustomerTransactionPage customerTransactionPage;

    String date = prop.getProperty("ValidationDate");
    String Startdate = prop.getProperty("StartDate");
    String Enddate = prop.getProperty("EndDate");
    String AccountexistUser = prop.getProperty("AccontExistUser");

    // Constructor
    public CustomerTransactionPageTest() {
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
        customerTransactionPage = loginPage.CustomerLogin1(AccountexistUser);
    }

    // Test method to verify deposit with a valid amount
    @Test(priority=1)
    public void Verify_Deposit_With_ValidAmount() {
        customerTransactionPage.Filter(Startdate, Enddate);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
