package sdf.generic;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;





public class GenericFunctions{
	
	WebDriver driver;
	By cartbuttonlocator;
	By orderbuttonlocator;
	
	
	public GenericFunctions(WebDriver driver)
	{
		this.driver=driver;
		this.cartbuttonlocator = By.cssSelector("button[routerlink='/dashboard/cart']");
		this.orderbuttonlocator = By.cssSelector("button[routerlink='/dashboard/myorders']");
	}
	
	
	
	public void goToCartPage()
	{
		
		driver.findElement(cartbuttonlocator).click();
		//((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(cartbuttonlocator));
		//added JavascriptExecutor for CI stability, click action failing normally
	}
	
	
	public void goToOrdersPage()
	{

		driver.findElement(orderbuttonlocator).click();
	}
	
	

}
