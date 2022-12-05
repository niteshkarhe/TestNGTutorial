package com.seleniumeasy.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.seleniumeasy.utils.PropertiesHandler;
import com.seleniumeasy.waits.WebDriverWaits;

public class HomePage extends BasePage
{
	private String objectRepoPath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\seleniumeasy\\objectRepository\\homepage.properties";
	private WebDriver driver;
	private PropertiesHandler prop;
	private WebDriverWaits wait;
	
	public HomePage(WebDriver inputDriver)
	{
		driver = inputDriver;
		prop = new PropertiesHandler(objectRepoPath);
		wait = new WebDriverWaits(driver);
	}
	
	public void LaunchSeleniumEasyHomePage()
	{
		driver.get(GetUrl());
		String homeTitleOnUI = driver.getTitle();
		String homeTitleExpected = "Selenium Easy - Best Demo website to practice Selenium Webdriver Online";
		Assert.assertEquals(homeTitleOnUI, homeTitleExpected, "Title of SeleniumEasy is not displayed");
		if (homeTitleOnUI.equals(homeTitleExpected))
		{
			System.out.println("##### Result ###########: Home page displayed successfully");
		}
		else
		{
			System.out.println("##### Result ###########: Home page is not displayed");
		}
	}
	
	public void VerifyAllHeaderMenusAreDisplayed()
	{
		List<WebElement> menuElements = wait.GetElements(prop.GetProperty("home.header.menu.list.xpath"));
		for (int i=1; i<= menuElements.size(); i++)
		{
			String headerTextXpath = prop.GetProperty("home.header.menu.list.xpath") + "[" + i +  "]/a";
			String uiHeaderText = wait.GetTextOfElementWhenPresentInDOM(headerTextXpath);
			System.out.println(uiHeaderText);
		}
	}
}
