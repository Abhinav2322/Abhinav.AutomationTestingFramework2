package sdf.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class LoginPage extends BasePage {

	
	
	/*
	WebElement emailBox=driver.findElement(By.id("userEmail")); //username textbox
	WebElement passwordBox=driver.findElement(By.id("userPassword")); //password textbox
	WebElement loginBtn=driver.findElement(By.id("login")); // login Button
	*/
	
	
	By emailBox = By.id("userEmail");
	By passwordBox = By.id("userPassword");
	By loginBTN = By.id("login");
			
	
	
	public void goToURL(String url)
	{
		driver.get(url);
		
	}
	
	public void logIntoApplication(String username, String password)
	{
		driver.findElement(emailBox).sendKeys(username);
		driver.findElement(passwordBox).sendKeys(password);
		driver.findElement(loginBTN).click();
		
	}
	
	
	
	
}
