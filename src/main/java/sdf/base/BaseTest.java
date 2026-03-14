package sdf.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import sdf.driver.DriverFactory;
import sdf.driver.DriverManager;
import org.apache.commons.io.FileUtils;


public class BaseTest {

	WebDriver driver;
	
	
	@BeforeMethod(alwaysRun=true)// executes before every @test
    public void setUp() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("src/test/resources/GlobalData.properties");
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
        driver = DriverFactory.createDriver(browserName); //using the method from DriverFactory class so we can invoke our browser
        //dynamically, meaning we can get the test to run in any browser we want.
        
        //in back end it only does , WebDriver driver = new ChromeDriver(), which we can see in the DriverFactory class.
        
        //till this point browser is invoked
        DriverManager.setDriver(driver); 
    }

    @AfterMethod(alwaysRun=true) //executes after every @test
    public void tearDown() {
        DriverManager.getDriver().quit();
        DriverManager.unload();
    }
    
    

    
    
    
    
}
