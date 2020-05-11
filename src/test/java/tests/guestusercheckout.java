package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddTocardPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegestrationPage;

public class guestusercheckout extends TestBases {

	HomePage homeObject;
	UserRegestrationPage registerObject;
	LoginPage loginObject;

	OrderDetailsPage orderObeject;
	String productname="Apple MacBook Pro 13-inch";
	SearchPage searchobject;
	ProductDetailsPage detailsobject;

	AddTocardPage cardObject;
	CheckoutPage checkoutObject;

	
	@Test(priority = 1)

	public void usercansearchwithautosuggestion() throws InterruptedException      	
	{
		searchobject = new SearchPage(driver);
		searchobject.searchproductusingautosuggest("macb");
		detailsobject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsobject.productnamebreadcrumb.getText().equalsIgnoreCase(productname)); 
	}
	@Test(priority = 2)
	public void usercandaddtocard() throws InterruptedException
	{
		detailsobject = new ProductDetailsPage(driver);
		detailsobject.addtocardshop();
		Thread.sleep(1000);
		driver.navigate().to("https://demo.nopcommerce.com"+"/cart");

}
	@Test(priority = 3)
	public void checkoutproduct() throws InterruptedException
	{
		cardObject=new AddTocardPage(driver);
		cardObject.usercheckproduct();
		checkoutObject = new CheckoutPage(driver);
		checkoutObject.checkoutproduct("amine","abde","abde@ddd.com",
				"Tunisia","4171","123456789","Zarzis","hightech",productname,"avenue kornich");
		orderObeject = new OrderDetailsPage(driver);
		orderObeject.saveaspdforder();
		orderObeject.printorder();
	}
 
	

}


