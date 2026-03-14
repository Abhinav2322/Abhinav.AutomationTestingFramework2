package sdf.generic;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	WebDriver driver;
	WebDriverWait wait;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /*public WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }*/
    
    
    public void waitForElementToAppear(WebElement e)
    {
    	wait.until(ExpectedConditions.visibilityOf(e));
    }
    
    public void waitForElementToAppear(By locator)
    {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    public void waitForElementsToAppear(By locator)
    {
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
    
    public void waitForElementToDisappear(WebElement e1)
    {
    	wait.until(ExpectedConditions.invisibilityOf(e1));
    }
    
    public void waitForElementToDisappear(By locator1)
    {
    	wait.until(ExpectedConditions.invisibilityOfElementLocated(locator1));
    }
    
    

}
