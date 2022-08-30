package com.newtours.demoaut.utility;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hslf.model.Sheet;
import org.openqa.selenium.OutputType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.TakesScreenshot;
import com.newtours.demoaut.base.Browser;

public class Utility extends Browser {
	
	public Utility() {
		super();
	}
	
	static  String dataFile =System.getProperty("user.dir")+"\\resource\\Data.xlsx";
	static Workbook book;
	static Sheet sheet;
	public static String getDataFromXL(String sheet,int row,int col)
	{
	String value="";
	try
	{
	Workbook w = WorkbookFactory.create(new FileInputStream(dataFile));
	value = w.getSheet(sheet).getRow(row).getCell(col).toString();
	} catch (Exception e)
	{
	e.printStackTrace();
	}
	return value ;
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	public static void main(String args[]) {
		System.out.println(dataFile);
	}
}
