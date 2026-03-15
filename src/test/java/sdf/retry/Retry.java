package sdf.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{

	
	int count = 0;
	int maxretries = 1;
	
	@Override
	public boolean retry(ITestResult result) {
		
		//logic to return true, meaning to make rerun failed test
		if(count<maxretries)
		{
			count++;
			return true;
		}
			
			
		
		return false;// by default it returns false . meaning it wont rerun / retry any failed tests. We want our failed tests to rerun then  
		//we will have to give a logic inside this method which will define if we want to rerun, how many times we want to rerun.

}
	
}


//now we just need to identify a test which is flaky (passes sometimes, fails on other -  mostly due to unforeseen issues)
//there we will define one attribute on the @Test annotation (retryAnalyzer = classname ) in our case (retryAnalyzer = Retry.class)
