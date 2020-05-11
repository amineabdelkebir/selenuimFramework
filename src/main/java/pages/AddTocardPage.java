package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddTocardPage extends PageBases {

	public AddTocardPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(css= "input.button-2.update-cart-button")
	WebElement Updshopbtn;
	
	@FindBy(name="continueshopping")
	WebElement Contshopbtn;
	
	@FindBy(name="removefromcart")
	WebElement checkremovebox;
	
	@FindBy(css="div.no-data")
	WebElement clearshoplist;
	
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	public WebElement prodname;

	@FindBy(id="itemquantity26787")
	WebElement qtnproduct;
	
	@FindBy(css="product-subtotal")
	public WebElement totalprice;
	
	@FindBy(id="checkout")
	public WebElement checkoutBtn;
	
	
	@FindBy(id="termsofservice")
	public WebElement acceptcheckbox;
	

	public void updquntproduct(String qte)
	{   cleartext(qtnproduct);
		settext(qtnproduct, qte);
		clickbutton(Updshopbtn);
	}
	
	public void clearcard()
	{
	clickbutton(checkremovebox);
	clickbutton(Updshopbtn);
	}
	
	public void usercheckproduct()
	{
		clickbutton(acceptcheckbox);
		clickbutton(checkoutBtn);
		
	}
}

