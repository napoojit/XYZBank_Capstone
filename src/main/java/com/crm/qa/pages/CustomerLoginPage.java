package com.crm.qa.pages;


import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.TestBase.TestBase;

// Class representing the Page Object Model for the Customer Login page
public class CustomerLoginPage extends TestBase {

    // Page Factory - Object Repository
    @FindBy(xpath="//button[normalize-space()='Customer Login']")
    WebElement Customer_Login;

    @FindBy(xpath="//button[normalize-space()='Bank Manager Login']")
    WebElement Manager_Login;

    // Initializing the Page Objects using PageFactory
    public CustomerLoginPage() throws IOException {
        PageFactory.initElements(driver, this);
    }

    // Actions:

    // Method to get the title of the page
    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    // Method to perform Customer Login and navigate to WithdrawalPage1
    public WithdrawalPage1 CustomerLogin(String username) {
        Customer_Login.click();
        
        // Locate the dropdown element using the provided XPath
        WebElement dropdownElement = driver.findElement(By.xpath(prop.getProperty("dropdown")));

        // Create a Select object for interacting with the dropdown
        Select dropdown = new Select(dropdownElement);

        // Select an option from the dropdown by visible text
        dropdown.selectByVisibleText(username);
        
        // Click the login button using the provided XPath
        String path = prop.getProperty("Login");
        driver.findElement(By.xpath(path)).click();
        
        // Return a new instance of WithdrawalPage1
        return new WithdrawalPage1();
    }

    // Method to perform Customer Login and navigate to CustomerTransactionPage
    public CustomerTransactionPage CustomerLogin1(String username) {
        Customer_Login.click();
        WebElement dropdownElement = driver.findElement(By.xpath(prop.getProperty("dropdown")));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(username);
        String path = prop.getProperty("Login");
        driver.findElement(By.xpath(path)).click();
        return new CustomerTransactionPage();
    }

    // Method to perform Bank Manager Login and navigate to AddCustomerPage
    public AddCustomerPage ManagerLogin() {
        Manager_Login.click();
        return new AddCustomerPage();
    }

    // Method to perform Bank Manager Login and navigate to OpenAccountPage
    public OpenAccountPage ManagerLogin1() {
        Manager_Login.click();
        return new OpenAccountPage();
    }

    // Method to perform Bank Manager Login and navigate to CustomersPage
    public CustomersPage ManagerLogin2() {
        Manager_Login.click();
        return new CustomersPage();
    }

}