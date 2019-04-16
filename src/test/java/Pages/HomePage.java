package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver){
		
		this.driver = driver;
		
	}

	
	public void bankManagerLogin(){
		
		driver.findElement(By.xpath("//div[@class='borderM box padT20']//div[2]//button")).click();
		
	}
}
