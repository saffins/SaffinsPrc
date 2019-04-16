package com.selenium.testsuite;

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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.Registrator;
import Utilities.ExcelReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class W2register {

	private WebDriver driver;
	private String baseUrl;
	// define an Excel Work Book
	Map<Integer, String> testResult;
	public static XSSFWorkbook book = null;
	public static XSSFSheet sheet = null;
	FileInputStream fs = null;

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

	@Test(dataProvider = "data")
	public void register(String name, String phone, String email, String city, String username, String pass) {

		Registrator w2 = new Registrator(driver);
		w2.doRegister(name, phone, email, city, username, pass);
		testResult.put(0, "pass");

	}

	@Test
	public void m1() {

		try {

			Assert.fail();
			testResult.put(1, "pass");

		} catch (AssertionError e) {
			testResult.put(1, "fail");

		}

	}

	@Test
	public void m2() {

		try {

			Assert.fail();
			testResult.put(2, "pass");

		} catch (AssertionError e) {
			testResult.put(2, "fail");

		}

	}

	@DataProvider
	public Object[][] data() throws IOException {

		new ExcelReader("I:\\suffin\\registrator.xlsx");

		int row = ExcelReader.getRow();
		int column = ExcelReader.getCol();

		Object[][] arr = new Object[row - 1][column];
		for (int i = 1; i < row; i++) {

			for (int j = 0; j < column; j++) {

				String data = ExcelReader.getData(i, j);
				arr[i - 1][j] = data;
			}

		}

		return arr;

	}

	public void write() throws IOException {

		// new ExcelReader("I:\\suffin\\registrator - Copy");
		//ExcelReader.write("I:\\suffin\\registrator - Copy");

		int row = ExcelReader.getRow();
		int column = ExcelReader.getCol();

	}

}
