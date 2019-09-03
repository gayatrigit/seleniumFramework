package com.crm.qa.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtill;

public class TestBase {
	public static Properties prop;
	 public static WebDriver driver;
	
	public TestBase(){
	try {
		prop=new Properties();
		FileInputStream fis=new FileInputStream("./Property/config.properties");
		prop.load(fis);
	}
	
	catch(FileNotFoundException e) {}
	catch(IOException e) {}
	}
	

	public static void initialization() {
		String browserTest = prop.getProperty("browser");
		if(browserTest.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","./drivers/c.exe");
			driver=new ChromeDriver();
			
		}
		else if(browserTest.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
			 driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtill.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtill.IMPLICIT_TIMEOUT,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
		
	}






