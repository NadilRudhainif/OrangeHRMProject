package com.qa.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.orangehrm.constants.AppConstants;
import com.qa.orangehrm.utils.ElementUtil;

public class LoginPage {
	
	private ElementUtil eleUtil;
	private WebDriver driver;
	
	By OrangeHrmLogo=By.xpath("//img[@alt='company-branding']");
	By usernameTextField=By.xpath("//input[@name='username']");
	By passwordTextField=By.xpath("//input[@name='password']");
	By loginBtn=By.xpath("//button[@type='submit']");
	By forgotpwd=By.xpath("//p[text()='Forgot Your Password? ']");
	
	public LoginPage(WebDriver driver) {
		eleUtil=new ElementUtil(driver);
	}
	public String getLoginPageUrl() {
		return eleUtil.waitForURL(AppConstants.URL_FRACTION_VALUE,AppConstants.SHORT_TIME_OUT);
	}
	public boolean forgotpwdIsPresent() {
		return eleUtil.elementIsDisplayed(forgotpwd);
	}
	public HomePage doLogin(String usernme,String pwd) {
		eleUtil.waitForElement(usernameTextField, AppConstants.MEDIUM_TIME_OUT);
		eleUtil.doSendKeys(usernameTextField,usernme);
		eleUtil.doSendKeys(passwordTextField,pwd);
		eleUtil.doClick(loginBtn);
		return new HomePage(driver);
	}
	
	
	

}
