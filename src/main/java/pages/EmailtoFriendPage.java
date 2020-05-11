package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailtoFriendPage extends PageBases{

	public EmailtoFriendPage(WebDriver driver) {
		super(driver);
	
	}
	@FindBy(id="FriendEmail")
	WebElement emailfriendtxtbox;

	@FindBy(id="PersonalMessage")
	WebElement messagetxtbox;

	@FindBy(name="send-email")
	public WebElement sendemailbtn ;

	@FindBy(css="div.result")
	public WebElement confirmmsg;
	
	public void usersendemailtofriend(String emailfriend,String message)
	{
		settext(emailfriendtxtbox, emailfriend);
		settext(messagetxtbox, message);
		clickbutton(sendemailbtn);
	}
}
