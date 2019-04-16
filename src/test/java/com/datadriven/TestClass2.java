package com.datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass2 {
	
	private WebDriver driver;
	private String baseUrl;
	// define an Excel Work Book
	Map<Integer, String> testResult;
	public static XSSFWorkbook book = null;
	public static XSSFSheet sheet = null;
	FileInputStream fs = null;

	
	@BeforeTest
	public void launch() throws IOException {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("http://way2automation.com/way2auto_jquery/index.php");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fs = new FileInputStream("I:\\suffin\\testsResults.xlsx");
		book = new XSSFWorkbook(fs);
		sheet = book.getSheetAt(0);

		testResult = new HashMap<Integer, String>();
	}
	
	@Test
	public void test1(){
	 
		try{
			
			Assert.assertTrue(false);
			testResult.put(0, "fail");
			}catch(Exception e){
				
				testResult.put(1, "fail");

				
			}
		 
		
	}
	
	@Test
	public void test2(){
		testResult.put(1, "fail");
		 
		
	}
	
	@Test
	public void test3(){
		
	 
			testResult.put(2, "pass");
			
		 
		
	}
	
	@AfterTest
	public void writeExcelResults() throws IOException {

		Set<Integer> map = testResult.keySet();

		int rowNum = 1;
		int cellNum = 3;

		for (Integer ke1 : map) {

			Row row = sheet.getRow(rowNum);
			String objArr = testResult.get(ke1);

			Cell cell = row.createCell(cellNum);
			cell.setCellValue(objArr);
			rowNum++;
		}

		FileOutputStream out = new FileOutputStream(new File("I:\\suffin\\testsResults.xlsx"));

		System.out.println("writing done");

		book.write(out);
		out.close();

	}

	
}
