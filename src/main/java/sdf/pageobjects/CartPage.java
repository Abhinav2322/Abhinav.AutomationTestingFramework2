package sdf.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CartPage extends BasePage{

	//now we will create a list of webelements which will be the cart items list.
			//List<WebElement> cartItems=driver.findElements(By.cssSelector(".cartSection h3"));
			By cartItemsLocator = By.cssSelector(".cartSection h3");
			
	//Checkout Button		
			//checking out the product. following is one css selector and one xpath that we can use
			//.totalRow button and //*[text()='Checkout']
			
		 	//driver.findElement(By.cssSelector(".totalRow button")).click();
	//WebElement checkOutBtn = driver.findElement(By.xpath("//*[text()='Checkout']"));	
	By checkOutBtnLocator = By.xpath("//*[text()='Checkout']");
			
	public boolean verifyItemIsAddedInTheCart(String productToBuy)
	{
		System.out.println("navigated to cart page successfully");
		
		//waiting for the elements to appear before acting on them
		wait.waitForElementsToAppear(cartItemsLocator);
		
		List<WebElement> cartItems = driver.findElements(cartItemsLocator);
		boolean match = false;
		//to verify if the product is present in the cart, we will add a validation and print a message
				for(WebElement cartItem : cartItems)
				{
				 	/*if( cartItem.getText().equalsIgnoreCase(productToBuy))
				 	{
				 		
				 		System.out.println("product added to cart successfully");
				 		break;
				 	}*/
					
					 match = cartItem.getText().equalsIgnoreCase(productToBuy);
					
					
					//will use a testNG assertTrue, it accepts a boolean value, continues the execution if its true, if not then throws an AssertionError.
					//Assert.assertTrue(match);
	}
				
				return match;		
}
	
	
	public void checkOut()
	{
		driver.findElement(checkOutBtnLocator).click();
	}
	
	
}