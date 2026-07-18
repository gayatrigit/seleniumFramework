package com.crm.qa.util;
import com.crm.qa.base.TestBase;

import org.testng.ITestContext;
import org.testng.ITestListener;

import org.testng.ITestResult;

import com.aventstack.extentreports.*;


public class ExtentListener implements ITestListener {

    ExtentReports extent =
            ExtentReportManager.getReportObject();

    ExtentTest test;

    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getMethod().getMethodName());
    }


    public void onTestSuccess(ITestResult result) {

        test.log(Status.PASS, "Test Passed");
    }
    
    public void onTestSkipped(ITestResult result) {

        test.skip("Test skipped");
    }


    public void onTestFailure(ITestResult result) {

        test.log(Status.FAIL, "Test Failed");
        test.fail(result.getThrowable());
        String testName = result.getMethod().getMethodName();

        TestUtill.captureScreenshot(testName, 
                TestBase.driver);

    }
    @Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


    public void onFinish(ITestContext context) {

        extent.flush();
    }
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	


	
}