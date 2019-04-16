package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCustomer {
	
	WebDriver driver;
	
	public AddCustomer(WebDriver driver){
		
		
		this.driver = driver;
	}
	
	public void addCustButton(){
		
		
		driver.findElement(By.xpath("//*[@ng-class='btnClass1']")).click();
	}
	
	
	
	public void addCustomer(String fname, String lname, String postCode){
		
		driver.findElement(By.xpath("//*[@placeholder='First Name']")).sendKeys(fname);
		driver.findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys(lname);
		driver.findElement(By.xpath("//*[@placeholder='Post Code']")).sendKeys(postCode);
	
		
	}
	
	public void addCustomer(){
		
		driver.findElement(By.cssSelector(".btn.btn-default")).click();

		
	}

}
