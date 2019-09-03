package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtill;

public class ContactsPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage ;
	TestUtill testutil;
	ContactsPage contactpage;
	String sheetName="Test";
	
	
public ContactsPageTest() {
	super();
}
@BeforeMethod
public void setUp() {
	initialization();
	testutil=new TestUtill();
	contactpage=new ContactsPage();
	loginpage=new LoginPage();
	homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	testutil.switchToFrame();
	contactpage=homepage.clickOnContactsLink();
}
@Test(enabled=false)
public void verifyContactsPageLabel() {
	Assert.assertTrue(contactpage.verifyContactsLabel(),"contacts label is missing in the page");
}
@Test(enabled=false)
public void selectSingleContactsTest() {

	contactpage.selectContactsByName("Aaron Frank");
}

@Test(enabled=false)
public void selectMultipleContactsTest() {
	contactpage.selectContactsByName("Aaron Frank");
	contactpage.selectContactsByName("abc abc");
}

@DataProvider 
public Object[][] getCRMestTData() {
Object data[][]=TestUtill.getTestData(sheetName);
return data;
}
@Test(priority=4)
public void validateCreateNewContact(String title,String firstName,String lastName,String company) {
	homepage.clickOnNewContacts();
	contactpage.createNewContact("Mr.","tom","donald","google");
	contactpage.createNewContact(title, firstName, lastName, company);
}
@AfterTest
public void tearDown() {
	driver.quit();
}
}
