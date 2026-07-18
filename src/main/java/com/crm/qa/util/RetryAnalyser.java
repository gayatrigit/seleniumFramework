package com.crm.qa.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class RetryAnalyser implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation,
							Class testClass, 
							Constructor testConstructor, 
							Method testMethod) {
		// TODO Auto-generated method stub
		annotation.setRetryAnalyzer(RetryAnalyser.class);
	}
//	//implements IRetryAnalyzer
//	int count = 0;
//    int maxRetry = 2;
//	@Override
//	public boolean retry(ITestResult result) {
//		 if (count < maxRetry) {
//	            count++;
//	            return true;   // Retry the failed test
//	        }
//		 
//		return false;
//	}

}
