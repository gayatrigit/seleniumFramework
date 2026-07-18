package com.crm.qa.base;
import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.crm.qa.util.TestUtill;

public class TestBase {
	public static Properties prop;
	 public static WebDriver driver;
	 public static Logger logger = LogManager.getLogger(TestBase.class);
	
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
			//System.setProperty("webdriver.chrome.driver","./drivers/c.exe");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if(browserTest.equals("firefox")) {
			//System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtill.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtill.IMPLICIT_TIMEOUT));
		
		driver.get(prop.getProperty("url"));
	}
		
	}






