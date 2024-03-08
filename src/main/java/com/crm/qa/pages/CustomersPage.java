package com.crm.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.TestBase.TestBase;

// Class representing the Page Object Model for the Customers Page
public class CustomersPage extends TestBase {

    // Page Factory - Object Repository
    @FindBy(xpath="/html/body/div/div/div[2]/div/div[1]/button[3]")
    public WebElement Customer_button;

    @FindBy(xpath="//input[@placeholder='Search Customer']")
    WebElement SearchBox;

    @FindBy(xpath="//button[@ng-click='deleteCust(cust)']")
    WebElement Delete;

    // Initializing the Page Objects using PageFactory
    public CustomersPage(){
        PageFactory.initElements(driver, this);
    }

    // Method to delete a customer entry based on the provided username
    public void DeleteEntry(String username) throws InterruptedException {
        // Click on the Customer button to access customer-related options
        Customer_button.click();

        // Enter the username in the search box
        SearchBox.sendKeys(username);

        // Click the Delete button to delete the customer entry
        Delete.click();

        // Print a message indicating successful deletion
        System.out.println("Deleted customer details successfully");
    }
}
