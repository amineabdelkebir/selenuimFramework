package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ComparePage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddproducttoCampareTest extends TestBases{

	String firproductname="Apple MacBook Pro 13-inch";
	String secproductname="Asus N551JK-XO076H Laptop";

	ProductDetailsPage detailsObject; 
	HomePage homeObject;
	ComparePage compareObject;
	SearchPage searchObject;


	/*
	homeObject = new HomePage(driver);
	searchObject = new SearchPage(driver);
	detailsObject = new ProductDetailsPage(driver);
	 */

	@Test(priority = 1)

	public void usercansearchproductn1() throws InterruptedException
	{
		homeObject = new HomePage(driver);
		searchObject = new SearchPage(driver);
		searchObject.searchproductusingautosuggest("Apple MacBook Pro 13-inch");
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.addtocompare();
		Assert.assertTrue(detailsObject.productnamebreadcrumb.getText().contains(firproductname)); 
		Thread.sleep(3000);

	}

	@Test(priority = 2)

	public void usercansearchwithautosuggestion() throws InterruptedException      	
	{
		searchObject = new SearchPage(driver);
		searchObject.searchproductusingautosuggest("Asus N551JK-XO076H Laptop");
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.addtocompare();
		Assert.assertTrue(detailsObject.productnamebreadcrumb.getText().contains(secproductname)); 
		Thread.sleep(3000);
	}
	@Test(priority = 3)

	public void usercancampareproduct() throws InterruptedException
	{
		driver.navigate().to("https://demo.nopcommerce.com/"+"compareproducts");
		Thread.sleep(3000);
		compareObject = new ComparePage(driver);
		compareObject.compareproduct();
		Assert.assertTrue(compareObject.firstprod.getText().contains("Apple MacBook Pro 13-inch"));
		Assert.assertTrue(compareObject.secondprod.getText().contains("Asus N551JK-XO076H Laptop"));

	}
	@Test(priority = 4)
	public void clearcomparelist()
	{
		System.out.println("complete");
		compareObject.clearcomparelist();
	}
}
