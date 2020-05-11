package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegestrationPage;

public class UserRegistrationwithDDTandjsonFile extends TestBases {


	HomePage homeObject;
	UserRegestrationPage registerObject;
	LoginPage loginObject;

	@Test(priority = 1,alwaysRun = true)
	public void usercanregistersuccssfuly() throws FileNotFoundException, IOException, ParseException
	{ JsonDataReader jsonReader = new JsonDataReader();
		jsonReader.jsonreader();
		
		homeObject = new HomePage(driver);
		homeObject.openresgistrationpage();
		registerObject = new UserRegestrationPage(driver);
		registerObject.userRegistration(jsonReader.firstname,jsonReader.lastname,jsonReader.email,jsonReader.password);
		Assert.assertTrue(registerObject.successregnotif.getText().contains("Your registration completed"));
		registerObject.userlogout();
	
		loginObject = new LoginPage(driver);
		homeObject.openloginpage();
		
		loginObject.userlogin(jsonReader.email,jsonReader.password);
		Assert.assertTrue(registerObject.logoutlink.getText().equals("Log out"));

	}

}
