package com.crm.qa.tests;


import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.ExcelReader;
import com.crm.qa.pages.HomePage;

//@Listeners(ExtentListener.class)
public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
@DataProvider
public Object[][] getData()
{
	ExcelReader reader =
          new ExcelReader(System.getProperty("user.dir"+" "+"/data"), "input.xlsx");
	
	return reader.getData("Login");
}
	@BeforeMethod
	public void setUp() {
	
		initialization();
	    loginPage=new LoginPage();
		
	}
	@Test(enabled=true)
	public void loginPageTitleTest() {
		logger.info("verify the login page ");
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title,"Free CRM software in the cloud powers sales and customer service");
		
	}
	@Test(enabled=true)
		public void crmLogoTest() {
			boolean flag = loginPage.validatecrmLogo();
			Assert.assertTrue(flag);
		}
	@Test(dataProvider="getData")
	public void loginTest() {
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
