package com.crm.qa.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;


public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Users/Poojitha/eclipse/XYZ_Bank/src/main/java/com/crm/qa/config/config.properties");
			prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	public static void initialization() {
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
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}
	

	@AfterMethod
	public void teardownBrowser() {
		driver.quit();
	}
}