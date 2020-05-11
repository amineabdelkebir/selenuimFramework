package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBases{

	String productname="Apple MacBook Pro 13-inch";
	SearchPage searchobject;
	ProductDetailsPage detailsobject;
	@Test 
	public void usercansearchproduct()
	{
		searchobject = new SearchPage(driver);
		detailsobject = new ProductDetailsPage(driver);
		searchobject.productsearch(productname);
		searchobject.openproductsdetailspage();
		Assert.assertTrue(detailsobject.productnamebreadcrumb.getText().equalsIgnoreCase(productname));
	}
}
