package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailtoFriendPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegestrationPage;

public class EmailtoFriendTest extends TestBases {


	HomePage homeObject;
	UserRegestrationPage registerObject;
	LoginPage loginObject;
	String emailfriend="abc@yahoo.fr";
	String message="this product may be intersed you";
	String productname="Apple MacBook Pro 13-inch";
	SearchPage searchobject;
	ProductDetailsPage detailsobject;
	EmailtoFriendPage emailobject;
	
	@Test(priority = 1,alwaysRun = true)
	public void usercanregistersuccssfuly()
	{
		homeObject = new HomePage(driver);
		homeObject.openresgistrationpage();
		registerObject = new UserRegestrationPage(driver);
		registerObject.userRegistration("amine", "abdelebir", "ccfb888@gmail.com", "123321");
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
	public void uregistredysercansendemailtofriend()
	{
	detailsobject.usersendemailtofrind();
	emailobject = new EmailtoFriendPage(driver);
	emailobject.usersendemailtofriend("abcd@ee.com","i love it");
	Assert.assertTrue(emailobject.confirmmsg.getText().contains("Your message has been sent."));
	}

	@Test(priority = 4)
	public void registredusercanlogout()
	{
		registerObject.userlogout();
	}


}
