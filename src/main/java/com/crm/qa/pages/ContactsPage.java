package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtill;

public class ContactsPage extends TestBase{

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabels;
	
	@FindBy(id="first_name")
	WebElement firstname;
	@FindBy(id="surname")
	WebElement lastname;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	//(//a[text()='Aaron Frank'])[1]//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@type='checkbox']
	
	public ContactsPage() {
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyContactsLabel() {
		return contactsLabels.isDisplayed();
	}
	
	public void selectContactsByName(String name) {
		TestUtill.sleepTest();
	driver.findElement(By.xpath("(//a[text()='"+name+"'])[1]//parent::td[@class='datalistrow']"
			+ "//preceding-sibling::td[@class='datalistrow']//input[@type='checkbox']")).click();	
	}
	
	public void createNewContact(String title,String fname,String lname,String comp) {
		Select select=new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		company.sendKeys(comp);
		saveBtn.click();
		
	}
	
}
