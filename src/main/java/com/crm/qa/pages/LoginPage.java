package com.crm.qa.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtill;

public class LoginPage extends TestBase {

	

	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='input-group-btn']")
	WebElement loginBTN;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBTN;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	public LoginPage() {
	PageFactory.initElements(driver,this);	
	}
	
	public String validateLoginPageTitle() {
	return driver.getTitle();
	}
	
	public boolean validatecrmLogo() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		TestUtill.sleepTest();
		loginBTN.click();
		
		return new HomePage();
	}
	
	
	
}
