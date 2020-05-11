package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.Producttowishlistpage;
import pages.SearchPage;

public class Addwishlisttest extends TestBases {


	String productname="Apple MacBook Pro 13-inch";
	SearchPage searchobject;
	ProductDetailsPage detailsobject;
	Producttowishlistpage wishObject;
	HomePage homeObject;

	@Test(priority = 1)

	public void usercansearchwithautosuggestion() throws InterruptedException      	
	{	homeObject = new HomePage(driver);
		searchobject = new SearchPage(driver);
		searchobject.searchproductusingautosuggest("macb");
		detailsobject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsobject.productnamebreadcrumb.getText().equalsIgnoreCase(productname)); 
	} 
	@Test(priority = 2)

	public void usercanaddtowishlist()
	{
		detailsobject = new ProductDetailsPage(driver); 
		detailsobject.addtowishlist();
		driver.navigate().to("https://demo.nopcommerce.com/"+"/wishlist");
		wishObject = new Producttowishlistpage(driver);
		Assert.assertTrue(wishObject.headerwishlist.isDisplayed());
		Assert.assertTrue(wishObject.prodcutname.getText().contains(productname));

	}
	@Test(priority = 3)
	public void usercanremovefromwish()
	{

		wishObject = new Producttowishlistpage(driver)	;
		wishObject.usercanremovfromwishlist();
		Assert.assertTrue(wishObject.confirmmsg.getText().contains("empty"));
	}


}

