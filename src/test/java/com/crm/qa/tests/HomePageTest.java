package com.crm.qa.tests;

import static org.testng.Assert.assertTrue;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtill;

public class HomePageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	TestUtill testutil;
	ContactsPage contactPage;
	
public HomePageTest() {
	super();
}

@BeforeMethod
public void setUp() {
	initialization();
	testutil=new TestUtill();
	loginpage=new LoginPage();
	homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
}

@Test(enabled=false)
public void verifyHomePageTitleTest() {
	String homePageTitle=homepage.verifyHomePageTitle();
	Assert.assertEquals(homePageTitle,"CRMPRO","home page title is not correct");
}
@Test(enabled=false)
public void verifyUsernameTest() {
	testutil.switchToFrame();
	Assert.assertTrue(homepage.verifyUsername());
}

@Test(priority=1)
public void clickonContactsLinkTest() {
	testutil.switchToFrame();
 contactPage = homepage.clickOnContactsLink();
}

@AfterMethod
public void tearDown() {
	driver.quit();
}

}
