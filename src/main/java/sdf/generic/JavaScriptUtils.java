package sdf.generic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import sdf.pageobjects.BasePage;

public class JavaScriptUtils {
	
	
	WebDriver driver;
	public JavaScriptUtils(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	
  public void safeClick(WebElement parent, By childlocator)
  {
	  
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  
	  //locate the element first
	// Always locate fresh element
	  WebElement element = wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(parent, childlocator));
	  
	  
	  JavascriptExecutor jse = (JavascriptExecutor) driver; // casting our driver to JavascriptExecutor type so it can use java script.
	  
	  jse.executeScript("arguments[0].scrollIntoView({block: 'center'});", element); /* executing the java script
	  this will be - "Run this JS code on the current page".
	  
	  arguments = list of inputs passed from Java to JS
	  arguments[0] = first argument → element
	  
	  Scroll the page until this element is visible
	  And specifically:
	  block: 'center' → place the element in the center of the screen
	  */
	  
	  
	  element = wait.until(ExpectedConditions.elementToBeClickable(childlocator));
 // waiting for that element to be clickable
	  
	  
	  try
	  {
		  System.out.println("normally clicking "+ element.getText());
		element.click();  // trying simple click 
	  }
	  catch (ElementClickInterceptedException e)
	  {
		  System.out.println("Click intercepted. Using JS click on the element "+ element.getText());
		  jse.executeScript("arguments[0].click();", element); // trying js click
	  }
	  
	  
  }
	
	 
	
	
}





/* public void safeClick(WebDriver driver, By locator) {
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

((JavascriptExecutor) driver).executeScript(
    "arguments[0].scrollIntoView({block: 'center'});", element);

wait.until(ExpectedConditions.elementToBeClickable(element));

try {
    element.click();
} catch (ElementClickInterceptedException e) {
    // fallback
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
}
}

*/