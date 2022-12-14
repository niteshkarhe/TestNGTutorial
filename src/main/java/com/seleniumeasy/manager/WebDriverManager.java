package com.seleniumeasy.manager;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;


import com.seleniumeasy.utils.PropertiesHandler;

public class WebDriverManager
{	
	private WebDriver driver = null;
	
	protected WebDriver InitializeDriver()
	{
		String configFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties";
		String browserName = new PropertiesHandler(configFilePath).GetProperty("browser");
		
		if (browserName.equals("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized", "disable-popup-blocking", "disable-infobars");
			driver =  new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			return driver;
		}
		else if (browserName.equals("firefox"))
		{
			return new FirefoxDriver();
		}
		return null;
	}
	
	@AfterMethod
	public void TearDown()
	{
		System.out.println("Running After Method");
		driver.close();
	}
	
	@BeforeMethod
	public void SetUp()
	{
		System.out.println("Running Before Method");
	}
	
	@BeforeSuite
	public void BeforeSuite()
	{
		System.out.println("Running Before Suite");
	}
	
	@AfterSuite()
	public void ClassTearDown()
	{
		System.out.println("Running After Suite");
		driver.quit();
	}
	
	@BeforeTest
	public void BeforeTest()
	{
		System.out.println("Running Before Test");
	}
	
	@AfterTest
	public void AfterTest()
	{
		System.out.println("Running After Test");
	}
	
	@BeforeClass
	public void BeforeClass()
	{
		System.out.println("Running Before Class");
	}
	
	@AfterClass
	public void AfterClass()
	{
		System.out.println("Running After Class");
	}
}
