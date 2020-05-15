package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegestrationPage;

public class UserRegistrationTest extends TestBases {
	
	
	HomePage homeObject;
	UserRegestrationPage registerObject;
	LoginPage loginObject;
	
	@Test(priority = 1,alwaysRun = true)
	public void usercanregistersuccssfuly()
	{
		homeObject = new HomePage(driver);
		homeObject.openresgistrationpage();
		registerObject = new UserRegestrationPage(driver);
		registerObject.userRegistration("amindsssdde", "abdelssebir", "b22888822b@gmail.com", "123321");
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
		loginObject.userlogin("bbb@gmail.com", "123321");
		Assert.assertTrue(registerObject.logoutlink.getText().equals("Log out"));
	 }

}
