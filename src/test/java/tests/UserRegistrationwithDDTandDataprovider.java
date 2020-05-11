package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegestrationPage;

public class UserRegistrationwithDDTandDataprovider extends TestBases {


	HomePage homeObject;
	UserRegestrationPage registerObject;
	LoginPage loginObject;


	@DataProvider(name="testdata")

	public static Object[][] userdata()
	{
		return new Object[][] {{"moatezzz","nabillll","test12300@gmail.com","123456"},
			{"ahmedddd","aliii","test45600@gmail.com","456789"}};


	}

	@Test(priority = 1,alwaysRun = true,dataProvider = "testdata")
	public void usercanregistersuccssfuly(String fname,String lname,String email,String password)
	{
		homeObject = new HomePage(driver);
		homeObject.openresgistrationpage();
		registerObject = new UserRegestrationPage(driver);
		registerObject.userRegistration(fname, lname, email, password);
		Assert.assertTrue(registerObject.successregnotif.getText().contains("Your registration completed"));
		registerObject.userlogout();
		homeObject.openloginpage();
		loginObject = new LoginPage(driver);
		loginObject.userlogin(email, password);
		Assert.assertTrue(registerObject.logoutlink.getText().equals("Log out"));
		registerObject.userlogout();
		
	}

	



}
