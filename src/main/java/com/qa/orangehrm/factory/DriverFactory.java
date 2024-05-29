package com.qa.orangehrm.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	public WebDriver driver;
	public Properties prop;

	public WebDriver initDriver(Properties prop) {
		
		String browserName=prop.getProperty("browser");
		System.out.println("BrowserName ="+browserName);
		switch (browserName.toLowerCase()) {
		case "chrome":
			ChromeOptions	co=new ChromeOptions();
			co.addArguments("--incognito");
			 driver=new ChromeDriver(co);
			break;
		case "firefox":
			driver= new FirefoxDriver();
			break;
		case "edge":
			driver=new EdgeDriver();
			break;

		default:
			System.out.println("Please enter a valid browsername...");;
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}
	
	public Properties initProp() {
		prop=new Properties();
		FileInputStream fip = null;
		try {
			 fip = new FileInputStream("./src/test/resources/config.properties");
			 prop.load(fip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
			
	}

}
