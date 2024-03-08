package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.io.IOException;
import com.crm.qa.TestBase.TestBase;
import com.crm.qa.pages.WithdrawalPage1;
import com.crm.qa.pages.CustomerLoginPage;

// Test class for CustomerLoginPage
public class CustomerLoginTest extends TestBase {
    CustomerLoginPage loginPage;
    WithdrawalPage1 accountPage;
    String AccountexistUser = prop.getProperty("AccontExistUser");
    String AccountNot_existUser = prop.getProperty("AccontNot_ExistUser");

    // Constructor
    public CustomerLoginTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        loginPage = new CustomerLoginPage();
        accountPage = new WithdrawalPage1();
    }

    // Test method to validate customer login with existing account
    @Test(priority=1)
    public void customerlogin() {
        loginPage.CustomerLogin(AccountexistUser);
        String name = accountPage.verifyCustomerName();
        AssertJUnit.assertEquals(AccountexistUser, name);
    }
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}