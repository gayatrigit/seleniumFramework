package com.crm.qa.util;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class WaitUtility extends TestBase {

    private WebDriverWait wait;
    private Wait<WebDriver> fluentWait;

    public WaitUtility() 
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        fluentWait= new FluentWait<>(driver)
        		.withTimeout(Duration.ofSeconds(TestUtill.IMPLICIT_TIMEOUT))
        		.pollingEvery(Duration.ofSeconds(TestUtill.IMPLICIT_TIMEOUT))
        		.ignoring(NoSuchElementException.class);
        
    }

    public WebElement waitForVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean waitForInvisibility(WebElement element) {
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public boolean waitForTitle(String title) {
        return wait.until(ExpectedConditions.titleContains(title));
    }

    public boolean waitForUrl(String url) {
        return wait.until(ExpectedConditions.urlContains(url));
    }
    
    public WebElement waitForVisibilityOfElement(By element) {
        return fluentWait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

}