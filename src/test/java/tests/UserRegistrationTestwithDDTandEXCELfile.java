package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegestrationPage;

public class UserRegistrationTestwithDDTandEXCELfile extends TestBases {
	
	
	HomePage homeObject;
	UserRegestrationPage registerObject;
	LoginPage loginObject;
	 
	@DataProvider(name="excelfile")
	
	  public Object  userregisterdata() throws IOException
	//Object[][] 
	{
		
		ExcelReader ER =new ExcelReader();
		return ER.getExcelData();
		
	}
	
	@Test(alwaysRun = true,dataProvider = "excelfile")
	public void usercanregistersuccssfuly(String fname,String lname,String email,String password)
	{
		homeObject = new HomePage(driver);
		homeObject.openresgistrationpage();
		registerObject = new UserRegestrationPage(driver);
		registerObject.userRegistration(fname,lname,email,password);
		Assert.assertTrue(registerObject.successregnotif.getText().contains("Your registration completed"));
		registerObject.userlogout();
		homeObject.openloginpage();
		loginObject = new LoginPage(driver);
		loginObject.userlogin(email, password);
		Assert.assertTrue(registerObject.logoutlink.getText().equals("Log out"));
	
	}
	
}
