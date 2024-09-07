package com.OpenCart.Utility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProviders 1
	
	@DataProvider(name="LoginData")
	public String [][] getDatta() throws IOException
	{
		String path = "./testData/testData.xlsx"; // path for excel file from testData
		
		ExcelUtility xlutil = new ExcelUtility(path); // creating an object for Excel Utility
		
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1", 1);
		
		String logindata[][] = new String [totalrows][totalcols]; //created for two dimension array which can store rows and cols
		
		for(int i=1;i<=totalrows;i++) // 1 // read the data from excel storing in two dimensional array
		{
			for (int j=0;j<totalcols;j++) //0 i is rows and j is col
			{
				logindata[i-1][j] = xlutil.getCellData("Sheet1", i, j);  // 1,0
			}
		}
		
		return logindata; // returning two dimension array
		
		
		// Data providers 2 add here below for another data providers 
		
		
		
	}

}
