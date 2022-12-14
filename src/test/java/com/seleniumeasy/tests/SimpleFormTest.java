package com.seleniumeasy.tests;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.testng.annotations.Test;

import com.seleniumeasy.utils.ExcelReader;

public class SimpleFormTest 
{
	@Test
	public void AnnotationDemonstration()
	{
		System.out.println("Running Annotation Demonstartion test method");
	}
	
	@Test
	public void ReadExcelData()
	{
		String testCase = "Verify excel details are read";
		int counter = 0;
		ExcelReader reader = new ExcelReader(testCase);
		List<HashMap<String, String>> dataList = reader.GetExcelData();
		for (HashMap<String, String> data : dataList)
		{
			System.out.println("############### Test Data counter: "+ counter +" ###############");
			Set<Entry<String, String>> entries = data.entrySet();
			for (Entry<String, String> pair : entries)
			{
				System.out.println(pair.getKey() + " : " + pair.getValue());
			}
			System.out.println("#####################################################");
			counter++;
		}
	}
	
	
}
