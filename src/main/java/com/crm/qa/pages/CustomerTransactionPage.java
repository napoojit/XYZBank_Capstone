package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.TestBase.TestBase;

// Class representing the Page Object Model for the Customer Transaction Page
public class CustomerTransactionPage extends TestBase {

    // Page Factory - Object Repository
    @FindBy(xpath="//button[normalize-space()='Transactions']")
    WebElement Transaction_button;

    @FindBy(xpath="//input[@id='start']")
    WebElement StartDate;

    @FindBy(xpath="//input[@id='end']")
    WebElement EndDate;

    @FindBy(xpath="//*[@id=\"anchor0\"]/td[1]")
    WebElement Validation;

    @FindBy(xpath = "//body//div[@class='ng-scope']//div[@class='ng-scope']//div[2]")
    WebElement pageclick;

    // Initializing the Page Objects using PageFactory
    public CustomerTransactionPage(){
        PageFactory.initElements(driver, this);
    }

    // Method to get the title of the page
    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    // Method to filter transactions based on start and end dates
    public void Filter(String startDate, String endDate){
        // Click on the Transactions button to access transaction-related options
        Transaction_button.click();

        // Enter the start date in the StartDate input field
        StartDate.sendKeys(startDate);

        // Enter the end date in the EndDate input field
        EndDate.sendKeys(endDate);

        // Click on any other part of the page to apply the filter
        pageclick.click();
    }
}
