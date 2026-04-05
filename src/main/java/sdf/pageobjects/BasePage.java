package sdf.pageobjects;

import org.openqa.selenium.WebDriver;

import sdf.driver.DriverManager;
import sdf.generic.GenericFunctions;
import sdf.generic.JavaScriptUtils;
import sdf.generic.WaitUtils;

public class BasePage {
	
	WebDriver driver;
	protected WaitUtils wait; // protected because if we dont specify any access modifier , this will stay package-private, meaning
	//it would only be accessible to classes within this package. making it protected makes it accessible to all sub classes of this class in any
	//package
	 GenericFunctions gf;
	 
	
	public  BasePage()
	{
		this.driver=DriverManager.getDriver();
		this.wait = new WaitUtils(driver);
		this.gf = new GenericFunctions(driver);
		
	}
	
	

}
