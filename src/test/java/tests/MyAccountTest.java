package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegestrationPage;

public class MyAccountTest extends TestBases {
	

	HomePage homeObject;
	UserRegestrationPage registerObject;
	LoginPage loginObject;
	MyAccountPage MyaccountObject;
	String oldpassword="13131313";
	String newpassword="12121212";
	String lastname="calaa";
	String firstname="dabaa";
	String email="bavva220@gmail.com";

	
	@Test(priority = 1)
	public void usercanregistersuccssfuly()
	{
		homeObject = new HomePage(driver);
		homeObject.openresgistrationpage();
		registerObject = new UserRegestrationPage(driver);
		registerObject.userRegistration(firstname,lastname,email,oldpassword);
		Assert.assertTrue(registerObject.successregnotif.getText().contains("Your registration completed"));
	}
	
	@Test(priority = 2)
	
	public void registredusercanchangepassword()
	
	{	
		MyaccountObject = new MyAccountPage(driver);
		registerObject.openmyaccountpage();
		MyaccountObject.openchangepassword();
		MyaccountObject.changepassword(oldpassword, newpassword);
		System.out.println(MyaccountObject.passchanged.getText());
		Assert.assertTrue(MyaccountObject.passchanged.getText().contains("Password was changed"));
	}

	@Test(priority = 3)
	 public void registredusercanlogout()
	 {
		registerObject.userlogout();
	 }
	
	
	@Test(priority = 4)
	 public void registredusercanlogin()
	 {
		loginObject = new LoginPage(driver);
		homeObject.openloginpage();
		loginObject.userlogin(email, newpassword);
		Assert.assertTrue(registerObject.logoutlink.getText().equals("Log out"));
	 }

} 
