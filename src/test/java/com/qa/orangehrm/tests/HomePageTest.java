package com.qa.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BaseTest;
import com.qa.orangehrm.constants.AppConstants;
import com.qa.orangehrm.pages.HomePage;

public class HomePageTest extends BaseTest{
	
	HomePage homePage;
	@BeforeClass
	public void doLoginToHomePage() {
		homePage=loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}	
	@Test
	public void adminPageTest() {
		Assert.assertTrue(homePage.selectAdmin("admin", AppConstants.LONG_TIME_OUT));
	}
	

}
