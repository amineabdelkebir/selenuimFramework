package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Producttowishlistpage extends PageBases {

	public Producttowishlistpage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(css ="td.product")
	public WebElement prodcutname;
	
	@FindBy(css ="input.button-2.update-wishlist-button")
	WebElement updatewishlistbtn;
	
	@FindBy(css ="div.page-title")
	public WebElement headerwishlist;
	
	@FindBy(name ="addtocart")
	WebElement addtocart;
	
	@FindBy(name ="removefromcart")
	WebElement removefromcart;
	
	@FindBy(css= "div.no-data")
	public WebElement confirmmsg;
	
	public void usercanremovfromwishlist()

	{
		clickbutton(removefromcart);
		clickbutton(updatewishlistbtn);
		
		
		
	}
}	
	



