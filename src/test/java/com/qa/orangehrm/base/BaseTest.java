package com.qa.orangehrm.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.orangehrm.factory.DriverFactory;
import com.qa.orangehrm.pages.HomePage;
import com.qa.orangehrm.pages.LoginPage;

public class BaseTest {
	
	protected DriverFactory df;
	protected Properties prop;
	protected LoginPage loginPage;
	protected WebDriver driver;
	
	@BeforeTest
	public void setup() {
		df=new DriverFactory();
		prop=df.initProp();
		driver=df.initDriver(prop);
		loginPage=new LoginPage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
