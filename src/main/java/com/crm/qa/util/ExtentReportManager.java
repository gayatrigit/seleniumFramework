package com.crm.qa.util;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    static ExtentReports extent;

    public static ExtentReports getReportObject() {

        String path = System.getProperty("user.dir") 
                + "/test-output/ExtentReport.html";

        ExtentSparkReporter spark =
                new ExtentSparkReporter(path);

        spark.config().setReportName("Automation Test Results");
        spark.config().setDocumentTitle("Test Execution Report");

        extent = new ExtentReports();
        extent.attachReporter(spark);

        extent.setSystemInfo("Tester", "Gayathri");
        extent.setSystemInfo("Environment", "QA");

        return extent;
    }
}