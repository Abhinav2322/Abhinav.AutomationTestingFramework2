package sdf.listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import sdf.driver.DriverManager;
import sdf.generic.ScreenshotUtils;

public class Listeners implements ITestListener{
	

	
	@Override
	public void onTestStart(ITestResult result) {}

	@Override
	public void onTestSuccess(ITestResult result) {}

	@Override
	public void onTestFailure(ITestResult result) {
	//screenshot
		
		
		System.out.println("listener triggered");
		WebDriver driver = DriverManager.getDriver();
		try {
			String testName = result.getMethod().getMethodName()+ "_" + result.getMethod().getCurrentInvocationCount();
			ScreenshotUtils.takeScreenshotAndGetItsLocation(driver, testName );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
	

	@Override
	public void onTestSkipped(ITestResult result) {}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

	@Override
	public void onStart(ITestContext context) {}

	@Override
	public void onFinish(ITestContext context) {}	
	
	
	

}
