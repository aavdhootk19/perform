package com.searce.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetDataFromExcel {

	
public static XSSFWorkbook wb;
	
	public static XSSFSheet sheet;

	public static Object[][] getData(String file,String sheetName) throws Exception
	{
	File fil=new File(file); //excel sheet path from where we can fetch the data

	//Create an object of FileInputStream class to read excel file
	FileInputStream fis=new FileInputStream(fil);

	// complete excel sheet will be loaded by XSSFWorkbook 
	wb=new XSSFWorkbook(fis);

	sheet=wb.getSheet(sheetName);     //loaded the specific excel sheet
	int row=sheet.getLastRowNum();   // give number of rows present in excel sheet
	//System.out.println(row);

	int cellNum=sheet.getRow(0).getLastCellNum();//give number of column present in excel sheet
	//System.out.println(cellNum);
	Object[][] data=new Object[row][cellNum];   // store number of rows and column present in excel sheet
	//Create a loop over all the rows of excel file to read it
	for(int i=0;i<row;i++)
	{
	//Create a loop to print cell values in a row
	for(int k=0;k<cellNum;k++)
	{
	data[i][k]=sheet.getRow(i+1).getCell(k).toString(); //Test data storing in data[][] variable
	}
	}

	return data;

	}

	
}
