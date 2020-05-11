package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegestrationPage extends PageBases {

	public UserRegestrationPage(WebDriver driver) {
		super(driver);

	}
	@FindBy(id = "gender-male")
	WebElement genderrdbtn;

	@FindBy(id = "FirstName")
	WebElement fntxtbox;

	@FindBy(id = "LastName")
	WebElement lntxtbox;

	@FindBy(id = "Email")
	WebElement emailtxtbox;

	@FindBy(id = "Password")
	WebElement passwordtxtbox;

	@FindBy(id = "ConfirmPassword")
	WebElement confirmpasswordtxtbox;

	@FindBy(id = "register-button")
	WebElement registersubbtn;
	
	@FindBy(css = "div.result")
	public WebElement successregnotif;
	
	@FindBy(linkText = "Log out")
	public WebElement logoutlink;
	
	@FindBy(linkText = "My account")
	WebElement myaccountlink;

	public void userRegistration(String firstname,String lastname,String email,String password)
	{
		clickbutton(genderrdbtn);
		settext(fntxtbox, firstname);
		settext(lntxtbox, lastname);
		settext(emailtxtbox, email);
		settext(passwordtxtbox, password);
		settext(confirmpasswordtxtbox, password);
		clickbutton(registersubbtn);
	}
public void userlogout()
{
	clickbutton(logoutlink);
	}

public void openmyaccountpage()
{
	clickbutton(myaccountlink);
	}
}

