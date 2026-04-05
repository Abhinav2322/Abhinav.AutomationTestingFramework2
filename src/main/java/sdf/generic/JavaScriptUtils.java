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
	

	
	
	
	
	public static void scrollIntoView(WebDriver driver, By locator) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    WebElement element = wait.until(
	        ExpectedConditions.presenceOfElementLocated(locator)
	    );

	    ((JavascriptExecutor) driver).executeScript(
	        "arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});",
	        element
	    );
	}
	
	 
	
	
}





