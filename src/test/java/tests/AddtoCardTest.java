package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddTocardPage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddtoCardTest extends TestBases{

	String productname="Apple MacBook Pro 13-inch";
	SearchPage searchobject;
	ProductDetailsPage detailsobject;
	AddTocardPage cardObject;


	@Test(priority = 1)	
	public void usercansearchwithautosuggestion() throws InterruptedException      	
	{
		searchobject = new SearchPage(driver);
		searchobject.searchproductusingautosuggest("macb");
		detailsobject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsobject.productnamebreadcrumb.getText().equalsIgnoreCase(productname)); 
		
		
	}
	@Test(priority =2)
	public void usercandaddtocard() throws InterruptedException
	{
		detailsobject = new ProductDetailsPage(driver);
		detailsobject.addtocardshop();
		Thread.sleep(1000);
		driver.navigate().to("https://demo.nopcommerce.com"+"/cart");
		//cardObject.updquntproduct("3");
		//System.out.println("product name :"+cardObject.prodname.getText()+" total price = "+cardObject.totalprice.getText());
		
	}
	@Test(priority =3)
	public void usercancancelshopping()
	{
		cardObject=new AddTocardPage(driver);
		cardObject.clearcard();
	}
}
