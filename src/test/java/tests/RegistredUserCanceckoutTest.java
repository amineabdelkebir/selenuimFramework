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

public class RegistredUserCanceckoutTest extends TestBases {

	HomePage homeObject;
	UserRegestrationPage registerObject;
	LoginPage loginObject;

	OrderDetailsPage orderObeject;
	String productname="Apple MacBook Pro 13-inch";
	SearchPage searchobject;
	ProductDetailsPage detailsobject;

	AddTocardPage cardObject;
	CheckoutPage checkoutObject;

	@Test(priority = 1,alwaysRun = true)
	public void usercanregistersuccssfuly()
	{
		homeObject = new HomePage(driver);
		homeObject.openresgistrationpage();
		registerObject = new UserRegestrationPage(driver);
		registerObject.userRegistration("ahsseqq", "absssdelebir", "mmqqaa808@gmail.com", "123321");
		Assert.assertTrue(registerObject.successregnotif.getText().contains("Your registration completed"));
	}

	@Test(priority = 2)

	public void usercansearchwithautosuggestion() throws InterruptedException      	
	{
		searchobject = new SearchPage(driver);
		searchobject.searchproductusingautosuggest("macb");
		detailsobject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsobject.productnamebreadcrumb.getText().equalsIgnoreCase(productname)); 
	}
	@Test(priority = 3)
	public void usercandaddtocard() throws InterruptedException
	{
		detailsobject = new ProductDetailsPage(driver);
		detailsobject.addtocardshop();
		Thread.sleep(1000);
		driver.navigate().to("https://demo.nopcommerce.com"+"/cart");


	}

	@Test(priority = 4)
	public void usercancheckout() throws InterruptedException
	{
		cardObject=new AddTocardPage(driver);
		cardObject.usercheckproduct();
		checkoutObject = new CheckoutPage(driver);
		checkoutObject.registredusercheckoutproduct("Tunisia","avenue kornich","4171","123456789","Zarzis",productname);
		orderObeject = new OrderDetailsPage(driver);
		orderObeject.saveaspdforder();
		orderObeject.printorder();
	}

	@Test(priority = 5)
	public void registredusercanlogout()
	{
		registerObject.userlogout();
	}


}
