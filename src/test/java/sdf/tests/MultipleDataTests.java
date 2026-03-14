package sdf.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import sdf.base.BaseTest;
import sdf.dataprovider.TestDataProvider;
import sdf.pageobjects.CartPage;
import sdf.pageobjects.CheckOutPage;
import sdf.pageobjects.LoginPage;
import sdf.pageobjects.ProductsPage;

public class MultipleDataTests extends BaseTest {
	
	@Test(dataProvider = "items", dataProviderClass = TestDataProvider.class, groups= {"Place Multiple Orders"})
	public void placeMultipleOrders(String item)
	{
		//login
				LoginPage lp=new LoginPage();
				lp.goToURL("https://rahulshettyacademy.com/client/#/auth/login");		
				lp.logIntoApplication("nautiahinav@gmail.com", "Pr@ctice1234");
				
				
				//select product
				ProductsPage pp=new ProductsPage();
				//pp.selectProductToBuy("Adidas Original");
				pp.selectProductToBuy(item);
				pp.goToCart();
				
				
				//verify product added in the cart
				CartPage cp = new CartPage();
				//boolean verify = cp.verifyItemIsAddedInTheCart("Adidas Original");
				boolean verify = cp.verifyItemIsAddedInTheCart(item);
				Assert.assertTrue(verify);
				cp.checkOut();
				
				
				//Submit order and verify order is placed successfully
				CheckOutPage cop = new CheckOutPage();
				cop.submitOrder();
				boolean verify2 = cop.verifyOrderIsPlacedSuccessfully();
				Assert.assertTrue(verify2);
	}

}
