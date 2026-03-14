package sdf.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import sdf.base.BaseTest;
import sdf.pageobjects.CartPage;
import sdf.pageobjects.CheckOutPage;
import sdf.pageobjects.LoginPage;
import sdf.pageobjects.ProductsPage;

public class PlaceOrderTest extends BaseTest{
	
	@Test
	public void placeOrderTest()
	{
		
		//login
		LoginPage lp=new LoginPage();
		lp.goToURL("https://rahulshettyacademy.com/client/#/auth/login");		
		lp.logIntoApplication("nautiahinav@gmail.com", "Pr@ctice1234");
		
		
		//select product
		ProductsPage pp=new ProductsPage();
		pp.selectProductToBuy("Adidas Original");
		pp.goToCart();
		
		
		//verify product added in the cart
		CartPage cp = new CartPage();
		boolean verify = cp.verifyItemIsAddedInTheCart("Adidas Original");
		Assert.assertTrue(verify);
		cp.checkOut();
		
		
		//Submit order and verify order is placed successfully
		CheckOutPage cop = new CheckOutPage();
		cop.submitOrder();
		boolean verify2 = cop.verifyOrderIsPlacedSuccessfully();
		Assert.assertTrue(verify2);
		
		
				
	}

}
