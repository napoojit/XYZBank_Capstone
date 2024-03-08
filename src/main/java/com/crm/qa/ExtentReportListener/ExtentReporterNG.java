package com.crm.qa.ExtentReportListener;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporterNG implements IReporter {
    private ExtentReports extent;

    // Implementation of the generateReport method from the IReporter interface
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
            String outputDirectory) {
        // Initialize ExtentReports object with the specified output directory and file name
        extent = new ExtentReports(outputDirectory + File.separator + "Extent.html", true);

        // Iterate through all test suites
        for (ISuite suite : suites) {
            // Get the results of each suite
            Map<String, ISuiteResult> result = suite.getResults();

            // Iterate through all test results within the suite
            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();

                // Build nodes for passed tests
                buildTestNodes(context.getPassedTests(), LogStatus.PASS);
                
                // Build nodes for failed tests
                buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
                
                // Build nodes for skipped tests
                buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
            }
        }

        // Flush and close the ExtentReports object to complete the report generation
        extent.flush();
        extent.close();
    }

    // Build nodes for individual tests within a result map
    private void buildTestNodes(IResultMap tests, LogStatus status) {
        ExtentTest test;

        // Check if there are any test results in the result map
        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                // Start a new test in the ExtentReports object with the test method name
                test = extent.startTest(result.getMethod().getMethodName());

                // Set the start and end times for the test
                test.setStartedTime(getTime(result.getStartMillis()));
                test.setEndedTime(getTime(result.getEndMillis()));

                // Assign test categories based on groups
                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);

                // Log test status and details (including any throwable/exception)
                if (result.getThrowable() != null) {
                    test.log(status, result.getThrowable());
                } else {
                    test.log(status, "Test " + status.toString().toLowerCase() + "ed");
                }

                // End the test in the ExtentReports object
                extent.endTest(test);
            }
        }
    }

    // Convert millis to Date object
    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
}
