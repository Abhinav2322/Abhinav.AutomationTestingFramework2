package sdf.pageobjects;

import org.openqa.selenium.WebDriver;

import sdf.driver.DriverManager;
import sdf.generic.GenericFunctions;
import sdf.generic.WaitUtils;

public class BasePage {
	
	 WebDriver driver;
	WaitUtils wait;
	 GenericFunctions gf;
	
	public  BasePage()
	{
		this.driver=DriverManager.getDriver();
		this.wait = new WaitUtils(driver);
		this.gf = new GenericFunctions(driver);
	}
	
	

}
