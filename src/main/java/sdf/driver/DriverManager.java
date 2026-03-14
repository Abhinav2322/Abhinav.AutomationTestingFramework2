package sdf.driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	
private static ThreadLocal<WebDriver> driver = new ThreadLocal<>(); //initializing a threadlocal type of webdriver
	
	public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance); //and storing the argument(driver received from basetest , to the threadlocal)
    }

    public static WebDriver getDriver() {
        return driver.get();
        
    }

    public static void unload() {
        driver.remove();
    }
}
