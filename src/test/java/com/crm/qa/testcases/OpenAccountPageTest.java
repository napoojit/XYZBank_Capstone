package com.crm.qa.testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import com.crm.qa.TestBase.TestBase;
import com.crm.qa.pages.CustomerLoginPage;
import com.crm.qa.pages.OpenAccountPage;

// Test class for Open Account functionality
public class OpenAccountPageTest extends TestBase {
    CustomerLoginPage loginPage;
    OpenAccountPage openAccountPage;
    String OpenAccount_username = prop.getProperty("OpenAccount_username");

    // Constructor
    public OpenAccountPageTest() {
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
        openAccountPage = loginPage.ManagerLogin1();
    }

    // Test method to open an account
    @Test(priority = 1)
    public void OpenAccount() throws InterruptedException {
        // Click on the Open Account button and add a customer
        openAccountPage.OpenAccount_button.click();
        openAccountPage.AddCustomer(OpenAccount_username);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
