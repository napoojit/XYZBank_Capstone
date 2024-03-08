package com.crm.qa.pages;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.crm.qa.TestBase.TestBase;

// Class representing the Page Object Model for the Add Customer page
public class AddCustomerPage extends TestBase {

    // Page Factory - Object Repository
    @FindBy(xpath="//button[normalize-space()='Add Customer']")
    WebElement AddCustomer_button;

    @FindBy(xpath="//input[@placeholder='First Name']")
    WebElement Customer_Name;

    @FindBy(xpath="//input[@placeholder='Last Name']")
    WebElement Customer_LastName;

    @FindBy(xpath="//input[@placeholder='Post Code']")
    WebElement Post_code;

    @FindBy(xpath="//button[@type='submit']")
    WebElement Submit;

    // Initializing the Page Objects using PageFactory
    public AddCustomerPage() {
        PageFactory.initElements(driver, this);
    }

    // Actions:

    // Method to get the title of the page
    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    // Method to get the text from an alert message
    public String getAlertMessageText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    // Method to accept an alert
    public void getAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    // Method to add a customer with provided details
    public AddCustomerPage AddCustomer(String fname, String Lname, String postcode) {
        AddCustomer_button.click();
        Customer_Name.clear();
        Customer_Name.sendKeys(String.valueOf(fname));
        Customer_LastName.clear();
        Customer_LastName.sendKeys(String.valueOf(Lname));
        Post_code.clear();
        Post_code.sendKeys(String.valueOf(postcode));
        Submit.click();
        return new AddCustomerPage();
    }

    // Static method to assert if actual text contains expected partial text
    public static void assertContains(String actualText, String expectedPartialText) {
        Assert.assertTrue(actualText.contains(expectedPartialText), "Actual text does not contain expected partial text");
    }
}
