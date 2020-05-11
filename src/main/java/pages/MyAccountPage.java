package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBases {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(linkText = "Change password")
	WebElement changepasswordlink;
	
	@FindBy(id ="OldPassword")
	WebElement oldpasswordtxtbox;

	@FindBy(id ="NewPassword")
	WebElement newpasswordtxtbox;

	@FindBy(id ="ConfirmNewPassword")
	WebElement confirmnewpasswordtxtbox;
	
	@FindBy(css ="input.button-1.change-password-button")
	WebElement changepasswordbtn;
	
	@FindBy(css ="div.result")
	public WebElement passchanged;

	public void openchangepassword()
	{
		clickbutton(changepasswordlink);
	}
	public void changepassword(String oldpassword,String newpassword)
	{
		settext(oldpasswordtxtbox, oldpassword);
		settext(newpasswordtxtbox, newpassword);
		settext(confirmnewpasswordtxtbox, newpassword);
		clickbutton(changepasswordbtn);
		
		
	}
}
