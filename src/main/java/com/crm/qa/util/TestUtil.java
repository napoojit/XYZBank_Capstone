package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.TestBase.TestBase;

// TestUtil class provides utility methods used across the test framework
public class TestUtil extends TestBase {

    // Constants for timeout values
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 20;

    // Path to the test data sheet
    public static String TESTDATA_SHEET_PATH = "/Users/Poojitha/eclipse/BsgAxisSolutions/src/main/java/com/crm/qa/testdata/FreeCrmTestData.xlsx";

    // Workbook and sheet instances for handling Excel data
    static Workbook book;
    static Sheet sheet;

    // JavaScript Executor instance for executing JavaScript code
    static JavascriptExecutor js;

    // Method to switch to the main panel frame
    public void switchToFrame() {
        driver.switchTo().frame("mainpanel");
    }

    // Method to read test data from Excel sheet
    public static Object[][] getTestData(String sheetName) {
        FileInputStream file = null;
        try {
            // Load the Excel file
            file = new FileInputStream(TESTDATA_SHEET_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            // Create a Workbook instance
            book = WorkbookFactory.create(file);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Get the specified sheet
        sheet = book.getSheet(sheetName);

        // Create a 2D array to store test data
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        // Iterate through rows and columns to populate the data array
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
            }
        }
        return data;
    }

    // Method to capture a screenshot at the end of a test
    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }

    // Method to display runtime information using jQuery Growl
    public static void runTimeInfo(String messageType, String message) throws InterruptedException {
        js = (JavascriptExecutor) driver;

        // Check for jQuery on the page and add it if needed
        js.executeScript("if (!window.jQuery) {"
                + "var jquery = document.createElement('script'); jquery.type = 'text/javascript';"
                + "jquery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';"
                + "document.getElementsByTagName('head')[0].appendChild(jquery);" + "}");
        Thread.sleep(5000);

        // Use jQuery to add jquery-growl to the page
        js.executeScript("$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery.growl.js')");

        // Use jQuery to add jquery-growl styles to the page
        js.executeScript("$('head').append('<link rel=\"stylesheet\" "
                + "href=\"https://the-internet.herokuapp.com/css/jquery.growl.css\" " + "type=\"text/css\" />');");
        Thread.sleep(5000);

        // Display the message based on the message type
        if (messageType.equals("error")) {
            js.executeScript("$.growl.error({ title: 'ERROR', message: '" + message + "' });");
        } else if (messageType.equals("info")) {
            js.executeScript("$.growl.notice({ title: 'Notice', message: 'your notice message goes here' });");
        } else if (messageType.equals("warning")) {
            js.executeScript("$.growl.warning({ title: 'Warning!', message: 'your warning message goes here' });");
        } else
            System.out.println("no error message");
        Thread.sleep(5000);
    }
}
