package sdf.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import sdf.base.BaseTest;
import sdf.pageobjects.CartPage;
import sdf.pageobjects.CheckOutPage;
import sdf.pageobjects.LoginPage;
import sdf.pageobjects.OrdersPage;
import sdf.pageobjects.ProductsPage;

public class MultipleTests extends BaseTest {
	
	String itemToOrder = "Adidas Original";
	
	@Test(priority = 1)
	public void placeOrderTest()
	{
		
		//login
		LoginPage lp=new LoginPage();
		lp.goToURL("https://rahulshettyacademy.com/client/#/auth/login");		
		lp.logIntoApplication("nautiahinav@gmail.com", "Pr@ctice1234");
		
		
		//select product
		ProductsPage pp=new ProductsPage();
		pp.selectProductToBuy(itemToOrder);
		pp.goToCart();
		
		
		//verify product added in the cart
		CartPage cp = new CartPage();
		boolean verify = cp.verifyItemIsAddedInTheCart(itemToOrder);
		Assert.assertTrue(verify);
		cp.checkOut();
		
		
		//Submit order and verify order is placed successfully
		CheckOutPage cop = new CheckOutPage();
		cop.submitOrder();
		boolean verify2 = cop.verifyOrderIsPlacedSuccessfully();
		Assert.assertTrue(verify2);
		
				
	}
	
	
	@Test(priority = 0, groups= {"Login Tests"})
	public void invalidLoginTest()
	{
		LoginPage lp=new LoginPage();
		lp.goToURL("https://rahulshettyacademy.com/client/#/auth/login");		
		lp.logIntoApplication("invalidusername", "invalidpassword");
	}
	
	
	@Test(priority = 2, dependsOnMethods= {"placeOrderTest"})
	public void verifyOrderIsMade()
	{
		LoginPage lp=new LoginPage();
		lp.goToURL("https://rahulshettyacademy.com/client/#/auth/login");		
		lp.logIntoApplication("nautiahinav@gmail.com", "Pr@ctice1234");
		CheckOutPage cop = new CheckOutPage();
		cop.goToOrders();
        OrdersPage op = new OrdersPage();
        String result = op.findProductInOrders(itemToOrder);
        Assert.assertTrue(result.equalsIgnoreCase(itemToOrder));
        
	}

}
