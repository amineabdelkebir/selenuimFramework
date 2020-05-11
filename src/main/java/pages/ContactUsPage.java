package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBases{

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="FullName")
	WebElement fnametextbox;
	@FindBy(id="Email")
	WebElement emailtextbox;
	@FindBy(id="Enquiry")
	WebElement enquirytexbox;
	@FindBy(name="send-email")
	WebElement submitbtn;
	@FindBy(css="div.result")
	public WebElement successmsg;

	public void contactus(String fullname,String email,String enquiry)
	{
		settext(fnametextbox, fullname);
		settext(emailtextbox, email);
		settext(enquirytexbox, enquiry);
		clickbutton(submitbtn);
		
	}
}
