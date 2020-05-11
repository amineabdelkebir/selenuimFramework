package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBases {

	public LoginPage(WebDriver driver) {
		super(driver);

	}
	@FindBy(id ="Email")
	WebElement  emailtxtbox;

	@FindBy(id = "Password")
	WebElement  passwordtxtbox;

	@FindBy(css= "input.button-1.login-button")
	WebElement loginbtn;

public void userlogin(String login,String password)
{
	
	settext(emailtxtbox, login);
	settext(passwordtxtbox, password);
	clickbutton(loginbtn);	
}}