package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBases {
	
	String productname="Apple MacBook Pro 13-inch";
	SearchPage searchobject;
	ProductDetailsPage detailsobject;
	
	
	HomePage homeobject;
	ProductDetailsPage productobject;
@Test(priority = 1)
	public void usercanchangecurrency() 
	{
		homeobject = new HomePage(driver);
		productobject = new ProductDetailsPage(driver);
		homeobject.changecurrency();
		
		
		} 
@Test(priority = 2)
	
	public void usercansearchwithautosuggestion() throws InterruptedException      	
	{
		searchobject = new SearchPage(driver);
		searchobject.searchproductusingautosuggest("macb");
		detailsobject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsobject.productnamebreadcrumb.getText().equalsIgnoreCase(productname));
		Assert.assertTrue(detailsobject.productprice.getText().contains("Ђ"));
		System.out.println(detailsobject.productprice.getText());
	}
	}
