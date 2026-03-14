package sdf.generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

	/*
    public static void takeScreenshotAndGetItsLocation(WebDriver driver, String testCaseName) throws IOException // defining a method which accepts a parameter as testcase name ,
    //takes a screenshot, stores it in our project folder somewhere and returns a string which is basically the location of that screenshot.
    {
    	TakesScreenshot ts = (TakesScreenshot)driver; //casting our driver to takesScreenshot interface so selenium can know it has to take SS
    	File scrnshotFile = ts.getScreenshotAs(OutputType.FILE); // takes a screenshot with ts and creates a file of screenshot
    	File file = new File("./screenshots" + testCaseName + ".png"); //defines a location, the name and extension.
    	FileUtils.copyFile(scrnshotFile, file); //copies the screenshotFile into file's location and gets the name and .png extension
    	//return file; // returns the file path
    }*/

	public static void takeScreenshotAndGetItsLocation(WebDriver driver, String testCaseName) throws IOException {
		// TODO Auto-generated method stub
		TakesScreenshot ts = (TakesScreenshot)driver; //casting our driver to takesScreenshot interface so selenium can know it has to take SS
    	File scrnshotFile = ts.getScreenshotAs(OutputType.FILE); // takes a screenshot with ts and creates a file of screenshot
    	File file = new File("./screenshots/" + testCaseName + ".png"); //defines a location, the name and extension.
    	FileUtils.copyFile(scrnshotFile, file);
		
	}
}
