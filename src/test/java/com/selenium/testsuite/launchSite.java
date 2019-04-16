package com.selenium.testsuite;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.AddCustomer;
import Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class launchSite {
	
	 private WebDriver driver;
	  private String baseUrl;
	  //define an Excel Work Book
	  HSSFWorkbook workbook;
	  //define an Excel Work sheet
	  HSSFSheet sheet;
	  //define a test result data object
	  Map<String, Object > testresultdata   = new  HashMap<String, Object >();
	
	  @BeforeTest
	  public void launch(){
		  
		  WebDriverManager.chromedriver().setup();
		  
		 driver = new ChromeDriver();
		  driver.get("http://way2automation.com/way2auto_jquery/index.php");
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	  }
	  
	  @Test
	  public void login() throws InterruptedException{
		  
		  
			HomePage hp = new HomePage(driver);
			hp.bankManagerLogin();
			Thread.sleep(2000);
		  
		 
		 
		  
		  
	  }
	  
	  @Test
	  public void addCustomer(){
		  
		  AddCustomer c = new AddCustomer(driver);
		  c.addCustButton();
		  c.addCustomer("safin", "kh", "380055");
		 c.addCustomer();
		  
	  }
	  
	  @AfterClass
	  public void after(){
		  
		  Set<String> keyset = testresultdata.keySet();
		  
		  
			  
			  
			  
		  
		  
	  }
	  
	  
	  
	  
	  

}
