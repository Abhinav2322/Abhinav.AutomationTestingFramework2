package sdf.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage{
	
	//list of all products
			//List<WebElement> products=driver.findElements(By.cssSelector(".col-sm-10"));
			By productcards = By.cssSelector(".col-sm-10");
			//initializing required product as we need to fetch it, based on user choice
			WebElement requiredProduct= null;
			
			//user choice for the product
			//String productToBuy = "Adidas Original";
			
			//Select the product
			public void selectProductToBuy(String productToBuy)
			{
				
			System.out.println("need to select "+productToBuy);
			
			//will wait for the elements to appear on the screen before acting on them
			wait.waitForElementsToAppear(productcards);

			
			List<WebElement> products= driver.findElements(productcards);
			System.out.println("multiple products found");
			for(WebElement product : products)
			{
			 	if( product.findElement(By.tagName("b")).getText().equalsIgnoreCase(productToBuy))
			 	{
			 		System.out.println("required product found");
			 		requiredProduct = product;
			 		WebElement reqPoductName=product.findElement(By.tagName("b"));
			 		System.out.println(reqPoductName.getText());
			 		break;
			 	}	
			}
			if (requiredProduct != null) {
				
			    requiredProduct.findElement(By.xpath(".//button[@style ='float: right;']")).click();
			
			}else {
				
			    System.out.println("Product not found.");
			}

			//wait for the success message to appear
			wait.waitForElementToAppear(By.cssSelector("#toast-container"));
			
			//wait for the overlay/ loading animation to disappear
			wait.waitForElementToDisappear(By.cssSelector(".ngx-spinner-overlay"));
			
			
			
			
			
			}
			
			public void goToCart()
			{
				//waiting for the "product added to cart popup to disappear"
				wait.waitForElementToDisappear(By.cssSelector("#toast-container"));
				gf.goToCartPage();
			}
		   
			
			


}
