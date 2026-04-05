package sdf.driver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	
	// Prevent object creation
    private DriverFactory() {}

    public static WebDriver createDriver(String browser) {

        WebDriver driver=null;
        
        if(browser.equalsIgnoreCase("chrome"))
        {
        	System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe"); 
//- Selenium WebDriver needs to know where the browser driver executable is located on your system.


    		driver = new ChromeDriver();
        }
        
        if(browser.equalsIgnoreCase("edge"))
        {
        	System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");

    		driver = new EdgeDriver();
        }
        
        
        
        
        if(browser.equalsIgnoreCase("firefox"))
        {
        	System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        	driver = new FirefoxDriver();

        }
        
        //driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(1920, 1080));
        System.out.println(driver.manage().window().getSize());
        return driver;

}
}
