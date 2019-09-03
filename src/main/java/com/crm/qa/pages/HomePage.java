package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtill;

public class HomePage extends TestBase {

	@FindBy(xpath="//font[contains(text(),'User: Naveen K')]")
	WebElement usernameLabel;
	
	@FindBy(xpath="//a[.='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement TasksLink;
	
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	public boolean verifyUsername() {
		return usernameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		TestUtill.sleepTest();
		 contactsLink.click();
		return new ContactsPage();
		 
	}
	
	public Dealpage clickOnDealsLink() {
		dealsLink.click();
		return new Dealpage();
	}
	
	public TaskPage clickOnTasksLink() {
		TasksLink.click();
		return new TaskPage();
	}
	
	
	public void clickOnNewContacts() {
		Actions action=new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactsLink.click();
	}
	
	
	
	
	
	
	
	
	
	
}
 