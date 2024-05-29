package com.qa.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.orangehrm.constants.AppConstants;
import com.qa.orangehrm.utils.ElementUtil;

public class HomePage {
	
	private ElementUtil eleUtil;
	private WebDriver driver;
	
	
	By searchBar=By.xpath("//input[@placeholder=\"Search\"]");
	By adminButton=By.xpath("//span[text()='Admin']");
	By adminUsermanagementHeader=By.xpath("//div[@class='oxd-topbar-header-title']");

	public HomePage(WebDriver driver) {
		eleUtil=new ElementUtil(driver);
		this.driver=driver;
	}
	
	public String getHomePageUrl() {
		return eleUtil.waitForURL(AppConstants.HOMEPAGE_URL_VALUE, AppConstants.MEDIUM_TIME_OUT);
	}
	public String getHomePageTitle() {
		return eleUtil.getTitle();
	}
	public boolean selectAdmin(String value,int time) {
		eleUtil.waitForElement(searchBar,time);
		eleUtil.doActionSendKeys(searchBar,value);
		eleUtil.doActionClick(adminButton);
		return eleUtil.waitForElement(adminUsermanagementHeader, time).isDisplayed();
		

		
	}

}
