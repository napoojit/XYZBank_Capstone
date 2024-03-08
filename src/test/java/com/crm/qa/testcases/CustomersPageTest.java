package com.crm.qa.testcases;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import com.crm.qa.TestBase.TestBase;
import com.crm.qa.pages.CustomersPage;
import com.crm.qa.pages.CustomerLoginPage;

// Test class for CustomersPage
public class CustomersPageTest extends TestBase {
    CustomerLoginPage loginPage;
    CustomersPage customersPage;
    String Customers_username = prop.getProperty("Customers_username");

    // Constructor
    public CustomersPageTest() {
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
        customersPage = loginPage.ManagerLogin2();
    }

    // Test method to validate customer entry deletion
    @Test(priority=1)
    public void DeleteCustomerEntry() throws InterruptedException {
        customersPage.DeleteEntry(Customers_username);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
