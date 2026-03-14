package sdf.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckOutPage extends BasePage {

	
	//WebElement countryDropDown = driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
	By countryDropDownLocator = By.xpath("//input[@placeholder='Select Country']");
	By countryDropDownOptionsLocator = By.cssSelector(".list-group-item ");
	By successmessagelocator = By.xpath("//*[text()=' Thankyou for the order. ']");
	public void submitOrder()
	{
		driver.findElement(countryDropDownLocator).sendKeys("Ind");
		//storing the options in a list
		
		//will wait for the dropdown options appear on the screen before acting on them
		wait.waitForElementsToAppear(countryDropDownOptionsLocator);
		
		List<WebElement> countryDDOptions=driver.findElements(countryDropDownOptionsLocator);
		
		
		
		
		//iterating over the list and matching the text with required input and then clicking on it.
		for(WebElement option : countryDDOptions)
		{
			if(option.getText().equalsIgnoreCase("India"))
			{
				option.click();
				break;
			}
		}
		
		
		//clicking on order
		driver.findElement(By.cssSelector(".action__submit ")).click();
	}
	
	public boolean verifyOrderIsPlacedSuccessfully()
	{
		
		wait.waitForElementToAppear(successmessagelocator);
		String successMessage = driver.findElement(successmessagelocator).getText();
		
		boolean sucessMessageIsDisplayed = successMessage.contains("THANKYOU");
		
		return sucessMessageIsDisplayed;
		
	}
	
	
	public void goToOrders()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		gf.goToOrdersPage();
	}
	
}

