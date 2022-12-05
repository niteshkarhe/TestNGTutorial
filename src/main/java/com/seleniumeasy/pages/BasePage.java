package com.seleniumeasy.pages;

import com.seleniumeasy.utils.PropertiesHandler;

public class BasePage 
{
	private String configPath = System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties";
	private PropertiesHandler configProp;
	
	public BasePage()
	{
		configProp = new PropertiesHandler(configPath);
	}
	
	protected String GetUrl()
	{
		return configProp.GetProperty("url");
	}
}
