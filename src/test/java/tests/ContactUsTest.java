package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBases{

	HomePage homep;
	ContactUsPage contactpage;

	String email="jihed@gmail.com";
	String fullname="jihed bettaieb";
	String enquiry="you are the best";

	@Test
	public void usercanusecontactus()
	{
		homep = new HomePage(driver);
		homep.opencontactuspage();
		contactpage = new ContactUsPage(driver);
		contactpage.contactus(fullname, email, enquiry);
		Assert.assertTrue(contactpage.successmsg.getText()
				.contains("Your enquiry has been successfully sent to the store owner."));
	}

}
