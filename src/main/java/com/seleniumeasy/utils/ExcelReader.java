package com.seleniumeasy.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{
	private String testName;
	private String excelPath = System.getProperty("user.dir") + "\\src\\main\\resources\\";
	private String configPath = System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties";
	
	public ExcelReader(String inputTestName)
	{
		testName = inputTestName;
		excelPath = excelPath + new PropertiesHandler(configPath).GetProperty("excelfilename");
	}
	
	public List<HashMap<String, String>> GetExcelData()
	{
		List<HashMap<String, String>> testData = new ArrayList<HashMap<String, String>>();
		try
		{
			FileInputStream file = new FileInputStream(new File(excelPath));
			Workbook workbook = new XSSFWorkbook(file);
			Sheet sheet = workbook.getSheetAt(0);
			List<String> columnNames = new ArrayList<String>();
			Iterator<Row> rows = sheet.iterator();
			Row firstRow = rows.next();
			
			Iterator<Cell> cell = firstRow.cellIterator();
			int k=0;
			int column = 0;
			while(cell.hasNext())
			{
				Cell value = cell.next();
				columnNames.add(value.getStringCellValue());
				if(value.getStringCellValue().equalsIgnoreCase("Testcase"))
				{
					column=k;
				}
				k++;
			}
			
			while(rows.hasNext())
			{
				HashMap<String, String> rowData = new HashMap<String, String>();
				int columnIndex = 0;
				Row r = rows.next();
				if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testName))
				{
					Iterator<Cell> cellN = r.cellIterator();
					while(cellN.hasNext())
					{
						Cell cellValue = cellN.next();
						if(cellValue.getCellType()==CellType.STRING)
						{
							rowData.put(columnNames.get(columnIndex), cellValue.getStringCellValue());
						}
						else if (cellValue.getCellType() == CellType.NUMERIC)
						{
							String cellData = NumberToTextConverter.toText(cellValue.getNumericCellValue());
							rowData.put(columnNames.get(columnIndex), cellData);
						}
						columnIndex++;
					}
					testData.add(rowData);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return testData;
	}
}
