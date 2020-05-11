package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegestrationPage;

public class UserRegistrationwithDDTproprietesFile extends TestBases {
	
	
	HomePage homeObject;
	UserRegestrationPage registerObject;
	LoginPage loginObject;
	String fn=LoadProperties.userdata.getProperty("firstname");
	String ln=LoadProperties.userdata.getProperty("lastname");
	String em=LoadProperties.userdata.getProperty("email");
	String pass=LoadProperties.userdata.getProperty("password");
	
	@Test(priority = 1,alwaysRun = true)
	public void usercanregistersuccssfuly()
	{
		homeObject = new HomePage(driver);
		homeObject.openresgistrationpage();
		registerObject = new UserRegestrationPage(driver);
		registerObject.userRegistration(fn,ln,em,pass);
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
		loginObject.userlogin(em	,pass);
		Assert.assertTrue(registerObject.logoutlink.getText().equals("Log out"));
	 }

}
