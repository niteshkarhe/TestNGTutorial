package com.seleniumeasy.tests;

import org.testng.annotations.Test;

import com.seleniumeasy.manager.WebDriverManager;
import com.seleniumeasy.pages.HomePage;

public class HomeTest extends WebDriverManager
{
	@Test
	public void VerifySeleniumEasyHomePageIsDisplayedTest()
	{
		HomePage home = new HomePage(InitializeDriver());
		home.LaunchSeleniumEasyHomePage();
	}
	
	@Test
	public void VerifySeleniumEasyHomeHeaderMenus()
	{
		HomePage home = new HomePage(InitializeDriver());
		home.LaunchSeleniumEasyHomePage();
		home.VerifyAllHeaderMenusAreDisplayed();
	}
}
