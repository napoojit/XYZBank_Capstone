package com.crm.qa.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;

// TestBase class is used to provide common setup and teardown operations for test cases
public class TestBase {

    // WebDriver instance to interact with the browser
    public static WebDriver driver;

    // Properties instance to manage configuration properties
    public static Properties prop;

    // Constructor to initialize properties from config file
    public TestBase() {
        try {
            // Load configuration properties from the file
            prop = new Properties();
            FileInputStream ip = new FileInputStream("/Users/Poojitha/eclipse/XYZ_Bank/src/main/java/com/crm/qa/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method for initializing the WebDriver and opening the browser
    public static void initialization() {
        // Retrieve the browser name from configuration
        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")) {
            // Set ChromeDriver path
            System.setProperty("webdriver.chrome.driver", "//Users//Poojitha//drivers//chromedriver-mac-x64//chromedriver");

            // Initialize ChromeDriver
            driver = new ChromeDriver();
        } else if (browserName.equals("Edge")) {
            // Set EdgeDriver path
            System.setProperty("webdriver.edge.driver", "/Users/Poojitha/Selinium_Java/msedgedriver");

            // Initialize EdgeDriver
            driver = new EdgeDriver();
        }

        // Maximize the browser window
        driver.manage().window().maximize();

        // Delete all cookies
        driver.manage().deleteAllCookies();

        // Set the page load timeout
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

        // Set the implicit wait timeout
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Open the specified URL from configuration
        driver.get(prop.getProperty("url"));
    }

    // Teardown method to quit the browser after each test method
    @AfterMethod
    public void teardownBrowser() {
        driver.quit();
    }
}
