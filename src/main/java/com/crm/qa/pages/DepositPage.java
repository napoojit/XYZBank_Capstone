package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.TestBase.TestBase;

// Class representing the Page Object Model for the Deposit Page
public class DepositPage extends TestBase {

    // Page Factory - Object Repository
    @FindBy(xpath="//button[@ng-click='deposit()']")
    private WebElement depositButton;

    @FindBy(xpath="//input[@placeholder='amount']")
    private WebElement amountField;

    @FindBy(xpath="//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath="//span[@class='error ng-binding']")
    private WebElement message;

    // Initializing the Page Objects using PageFactory
    public DepositPage() {
        PageFactory.initElements(driver, this);
    }

    // Method to enter a deposit amount in the amount field
    public void enterDepositAmount(int amount) {
        amountField.clear();
        amountField.sendKeys(String.valueOf(amount));
    }

    // Method to submit the deposit
    public void submitDeposit() {
        submitButton.click();
    }

    // Method to perform the deposit action with a specified amount
    public void depositAmount(int amount) {
        depositButton.click();
        amountField.clear();
        amountField.sendKeys(String.valueOf(amount));
        submitButton.click();
    }

    // Method to get the message displayed on the page
    public String getMessage() {
        return message.getText();
    }
}
