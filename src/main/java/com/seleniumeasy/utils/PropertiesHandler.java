package com.seleniumeasy.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHandler 
{
	private String filePath;
	
	public PropertiesHandler(String inputFilePath)
	{
		filePath = inputFilePath;
	}
	
	public String GetProperty(String propName)
	{
		String value = "";
		
		try
		{
			Properties prop = LoadPropertiesFile();
			value = prop.get(propName).toString();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return value;
	}
	
	private Properties LoadPropertiesFile()
	{
		Properties prop = new Properties();
		FileInputStream fis = null;
		try 
		{
			fis = new FileInputStream(new File(filePath));
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		try 
		{
			prop.load(fis);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return prop;
	}
}
