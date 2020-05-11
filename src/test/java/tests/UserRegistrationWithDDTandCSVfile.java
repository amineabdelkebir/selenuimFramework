package tests;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegestrationPage;

public class UserRegistrationWithDDTandCSVfile extends TestBases {
	
	
	HomePage homeObject;
	UserRegestrationPage registerObject;
	LoginPage loginObject;
	CSVReader reader;
	
	
	
	@Test(priority = 1,alwaysRun = true)
	public void usercanregistersuccssfuly() throws CsvValidationException, IOException
	{
		String CSV_file="C:\\Users\\Amine\\eclipse-workspace\\taf\\src\\test\\java\\data\\table.csv" ; 
		reader =new CSVReader(new FileReader(CSV_file));
		
		String[] csvcel;
		
		while ((csvcel =reader.readNext()) != null)
		{
			String fname=csvcel[0];
			String lname=csvcel[1];
			
			String email=csvcel[2];
			String password=csvcel[3];
		
		
		homeObject = new HomePage(driver);
		homeObject.openresgistrationpage();
		registerObject = new UserRegestrationPage(driver);
		registerObject.userRegistration(fname, lname, email,password);
		Assert.assertTrue(registerObject.successregnotif.getText().contains("Your registration completed"));
		registerObject.userlogout();
		homeObject.openloginpage();
		loginObject = new LoginPage(driver);
		loginObject.userlogin(email,password);
		Assert.assertTrue(registerObject.logoutlink.getText().equals("Log out"));
		}
}}
