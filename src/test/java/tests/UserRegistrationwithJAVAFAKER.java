package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegestrationPage;

public class UserRegistrationwithJAVAFAKER extends TestBases {


	HomePage homeObject;
	UserRegestrationPage registerObject;
	LoginPage loginObject;
	Faker fakedata= new Faker();
	String firstname= fakedata.name().firstName();
	String lastname= fakedata.name().lastName();
	String email= fakedata.internet().emailAddress();
	String password= fakedata.number().digits(8).toString();

	@Test(priority = 1,alwaysRun = true)
	public void usercanregistersuccssfuly()
	{
		homeObject = new HomePage(driver);
		homeObject.openresgistrationpage();
		registerObject = new UserRegestrationPage(driver);
		registerObject.userRegistration(firstname,lastname,email,password);
		Assert.assertTrue(registerObject.successregnotif.getText().contains("Your registration completed"));
	}

	@Test(dependsOnMethods = "usercanregistersuccssfuly")
	public void registredusercanlogout()
	{
		registerObject.userlogout();
	}


	@Test(dependsOnMethods = "registredusercanlogout")
	public void registredusercanlogin()
	{
		homeObject.openloginpage();
		loginObject = new LoginPage(driver);
		loginObject.userlogin(email,password);
		Assert.assertTrue(registerObject.logoutlink.getText().equals("Log out"));
	}

}
