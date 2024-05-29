package com.qa.orangehrm.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	private WebDriver driver;
	public ElementUtil(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getElement(By locators) {
		return driver.findElement(locators);
	}
	public void doClick(By locators) {
		getElement(locators).click();
	}
	
	public void doSendKeys(By locators,String value) {
		getElement(locators).sendKeys(value);
	}
	public boolean elementIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	
	//************ActionMethods**************
	
	public void doActionClick(By locator) {
		Actions action = new Actions(driver);
		action.click(getElement(locator)).build().perform();
	}
	public void doActionSendKeys(By locator,String value) {
		Actions action = new Actions(driver);
		action.sendKeys(getElement(locator),value).build().perform();
	}

	
	//**************WAIT******************
	
	
	public WebElement waitForElement(By locator,int time) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	
	public String waitForURL(String fractionURL,int time) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time));
		try {
			 if(wait.until(ExpectedConditions.urlContains(fractionURL))){
				 return driver.getCurrentUrl();
			 }
			 else {
				 System.out.println("URL is not present");
				 return null;
			 }
		}
		catch (Exception e) {
			System.out.println("URL is not present");
			 return null;
		}
	}
	public String waitForTitle(String titleValue,long time) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time));
		try {
			 if(wait.until(ExpectedConditions.titleIs(titleValue))){
				 return driver.getTitle();
			 }
			 else {
				 System.out.println("Title is not present");
				 return null;
			 }
		}
		catch (Exception e) {
			System.out.println("Title is not present");
			 return null;
		}
		
	}
	
	
	
}
