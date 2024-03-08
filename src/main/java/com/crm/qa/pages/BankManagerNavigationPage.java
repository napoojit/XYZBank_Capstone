package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.crm.qa.TestBase.TestBase;

public class BankManagerNavigationPage extends TestBase {
	@FindBy(xpath="//button[normalize-space()='Bank Manager Login']")
	WebElement Manager_Login;
	
	
	//Initializing the Page Objects:
	public BankManagerNavigationPage() throws IOException {
	    PageFactory.initElements(driver, this);
	}

	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	
	}
		
	public AddCustomerPage ManagerLogin()
	{
		Manager_Login.click();
		return new AddCustomerPage();
	}


	public WithdrawalPage1 BankManagerLogin1(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}