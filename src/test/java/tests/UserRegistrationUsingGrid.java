package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegestrationPage;

public class UserRegistrationUsingGrid extends TestBases2 {
 

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
		homeObject = new HomePage(getdriver());
		homeObject.openresgistrationpage();
		registerObject = new UserRegestrationPage(getdriver());
		registerObject.userRegistration(firstname,lastname,email,password);
		Assert.assertTrue(registerObject.successregnotif.getText().contains("Your registration completed"));
	}

	@Test(priority = 2)
	public void registredusercanlogout()
	{
		registerObject.userlogout();
	}


	@Test(priority = 3)
	public void registredusercanlogin()
	{
		homeObject.openloginpage();
		loginObject = new LoginPage(getdriver());
		loginObject.userlogin(email,password);
		Assert.assertTrue(registerObject.logoutlink.getText().equals("Log out"));
	}

}
