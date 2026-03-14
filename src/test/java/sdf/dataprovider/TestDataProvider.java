package sdf.dataprovider;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
	
	@DataProvider(name="items")
	public Object[][] getItems()
	{
		return new Object[][]
				{
			
			{"adidas original"},
			{"zara coat 3"}
			
				};
	}
	
	
	
	
	

}
