package com.crm.qa.util;


/*************************************** PURPOSE **********************************

 - This class implements the WebDriverEventListener, which is included under events.
 The purpose of implementing this interface is to override all the methods and define certain useful  Log statements 
 which would be displayed/logged as the application under test is being run.

 Do not call any of these methods, instead these methods will be invoked automatically
 as an when the action done (click, findBy etc). 

 */

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.crm.qa.TestBase.TestBase;

// WebEventListener class implements WebDriverEventListener to listen to WebDriver events
public class WebEventListener extends TestBase implements WebDriverEventListener {

    // Method executed before navigating to a URL
    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("Before navigating to: '" + url + "'");
    }

    // Method executed after navigating to a URL
    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("Navigated to:'" + url + "'");
    }

    // Method executed before changing the value of an element
    public void beforeChangeValueOf(WebElement element, WebDriver driver) {
        System.out.println("Value of the:" + element.toString() + " before any changes made");
    }

    // Method executed after changing the value of an element
    public void afterChangeValueOf(WebElement element, WebDriver driver) {
        System.out.println("Element value changed to: " + element.toString());
    }

    // Method executed before clicking on an element
    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("Trying to click on: " + element.toString());
    }

    // Method executed after clicking on an element
    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("Clicked on: " + element.toString());
    }

    // Method executed before navigating back to the previous page
    public void beforeNavigateBack(WebDriver driver) {
        System.out.println("Navigating back to the previous page");
    }

    // Method executed after navigating back to the previous page
    public void afterNavigateBack(WebDriver driver) {
        System.out.println("Navigated back to the previous page");
    }

    // Method executed before navigating forward to the next page
    public void beforeNavigateForward(WebDriver driver) {
        System.out.println("Navigating forward to the next page");
    }

    // Method executed after navigating forward to the next page
    public void afterNavigateForward(WebDriver driver) {
        System.out.println("Navigated forward to the next page");
    }

    // Method executed on an exception during test execution
    public void onException(Throwable error, WebDriver driver) {
        System.out.println("Exception occurred: " + error);
        try {
            TestUtil.takeScreenshotAtEndOfTest();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method executed before finding an element by a given method
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Trying to find Element By : " + by.toString());
    }

    // Method executed after finding an element by a given method
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Found Element By : " + by.toString());
    }

    // Other methods that are not overridden
    public void beforeScript(String script, WebDriver driver) {
    }

    public void afterScript(String script, WebDriver driver) {
    }

    public void beforeAlertAccept(WebDriver driver) {
    }

    public void afterAlertAccept(WebDriver driver) {
    }

    public void afterAlertDismiss(WebDriver driver) {
    }

    public void beforeAlertDismiss(WebDriver driver) {
    }

    public void beforeNavigateRefresh(WebDriver driver) {
    }

    public void afterNavigateRefresh(WebDriver driver) {
    }

    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
    }

    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
    }

    public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
    }

    public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
    }

    public void afterSwitchToWindow(String arg0, WebDriver arg1) {
    }

    public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
    }

    public void beforeGetText(WebElement arg0, WebDriver arg1) {
    }

    public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
    }
}
