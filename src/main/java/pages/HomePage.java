package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBases {

	public HomePage(WebDriver driver) {
		super(driver);
		jse =(JavascriptExecutor) driver;
		action = new Actions(driver);
	}
	@FindBy(linkText = "Register")
	WebElement registerlink;
	@FindBy(linkText = "Log in")
	WebElement login;

	@FindBy(linkText = "Contact us")
	WebElement contactus;
	
	@FindBy(id="customerCurrency")
	WebElement currencydropdownlist;
	
	@FindBy(linkText  ="Computers")
	WebElement computermenu;
	
	@FindBy(linkText = "Notebooks")
	WebElement notebookmenue;

	public void openresgistrationpage()
	{
		clickbutton(registerlink);
	}
	public void openloginpage()
	{
		clickbutton(login);
		
	}
	public void opencontactuspage()
	{
		scrolltobottom();
		clickbutton(contactus);
		
	}
	public void changecurrency()
	{
    select = new Select(currencydropdownlist);
    select.selectByVisibleText("Euro");
	}

	public void selectnoteboxmenu()
	{
		 action.moveToElement(computermenu)
		 .moveToElement(notebookmenue)
		 .click()
		 .build()
		 .perform();
	}

}

