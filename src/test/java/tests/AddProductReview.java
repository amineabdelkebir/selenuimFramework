package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailtoFriendPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductReviewsPage;
import pages.SearchPage;
import pages.UserRegestrationPage;

public class AddProductReview extends TestBases {

	HomePage homeObject;
	UserRegestrationPage registerObject;
	LoginPage loginObject;
	String emailfriend="abc@yahoo.fr";
	String message="this product may be intersed you";
	String productname="Apple MacBook Pro 13-inch";
	SearchPage searchobject;
	ProductDetailsPage detailsobject;
	EmailtoFriendPage emailobject;
	ProductReviewsPage reviewObject;
	@Test(priority = 1,alwaysRun = true)
	public void usercanregistersuccssfuly()
	{
		homeObject = new HomePage(driver);
		homeObject.openresgistrationpage();
		registerObject = new UserRegestrationPage(driver);
		registerObject.userRegistration("amine", "abdelebir", "ppppb80088@gmail.com", "123321");
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
	public void registredusercanaddreview()
	{	detailsobject.registreduseraddreview();
		reviewObject = new ProductReviewsPage(driver);
		reviewObject.rgistredusersendreview("for mac", "thank you for your service");
		Assert.assertTrue(reviewObject.confirmsendreview.getText()
				.contains("Product review is successfully added."));
	}

	@Test(priority = 4)
	public void registredusercanlogout()
	{
		registerObject.userlogout();
	}
}
