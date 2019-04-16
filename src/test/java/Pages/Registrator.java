package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Registrator {
	
	WebDriver driver;
	
	public Registrator(WebDriver driver){
		
		this.driver = driver;
		
	}
	
	public void doRegister(String name, String phone, String  email, String city, String username, String pass){
		
		driver.findElement(By.name("name")).sendKeys(name);
		driver.findElement(By.name("phone")).sendKeys(phone);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("city")).sendKeys(city);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).perform();
		
		action.sendKeys(username).perform();
		
		action.sendKeys(Keys.TAB).perform();
		
		action.sendKeys(pass).perform();
		

		
		 
	}

}
