package sdf.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OrdersPage extends BasePage {
	
	By orderNamesLocator = By.xpath("//table[contains(@class,'table-hover')]//tbody/tr/td[2]");
	
	public String findProductInOrders(String orderedItem)
	{
		
		wait.waitForElementsToAppear(orderNamesLocator);
		List<WebElement> OrderNamesElements = driver.findElements(orderNamesLocator);
		
		for(WebElement myOrder : OrderNamesElements)
		{
			System.out.println(myOrder.getText());
			 if(myOrder.getText().equalsIgnoreCase(orderedItem))
			 {
				 System.out.println("found this in orders ->"+myOrder.getText());
				 return myOrder.getText();
			 }
			 
		}
		return "not found";
		
	}

}
