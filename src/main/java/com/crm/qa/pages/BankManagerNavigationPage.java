package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.TestBase.TestBase;

// Class representing the Page Object Model for the Bank Manager Navigation page
public class BankManagerNavigationPage extends TestBase {

    // Page Factory - Object Repository
    @FindBy(xpath="//button[normalize-space()='Bank Manager Login']")
    WebElement Manager_Login;

    // Initializing the Page Objects using PageFactory
    public BankManagerNavigationPage() throws IOException {
        PageFactory.initElements(driver, this);
    }

    // Actions:

    // Method to get the title of the page
    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    // Method to perform Bank Manager Login and navigate to AddCustomerPage
    public AddCustomerPage ManagerLogin() {
        Manager_Login.click();
        return new AddCustomerPage();
    }

    // Placeholder method, needs proper implementation
    public WithdrawalPage1 BankManagerLogin1(String string) {
        // TODO Auto-generated method stub
        return null;
    }
}
