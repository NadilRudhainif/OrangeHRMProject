package com.qa.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BaseTest;

public class LoginPageTest extends BaseTest {
	
	
	@Test(priority = 2)
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void urlTest() {
		System.out.println(loginPage.getLoginPageUrl());
		Assert.assertTrue(loginPage.getLoginPageUrl().contains("opensource-demo.orangehrmlive.com"));
	}

}
