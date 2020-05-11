package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBases {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		
	}
@FindBy(css="strong.current-item")
public WebElement productnamebreadcrumb ;

@FindBy(css="input.button-2.email-a-friend-button.valid")
public WebElement emailtofriendbtn;

@FindBy(css="span.price-value-4")
public WebElement productprice ;

@FindBy(linkText = "Add your review")
public WebElement addreviewlink;

@FindBy(id="add-to-wishlist-button-4")
WebElement addwishlistbtn;

@FindBy( css="input.button-2.add-to-compare-list-button")
WebElement addtocomparebtn;

@FindBy(id="add-to-cart-button-4")
WebElement addcrtbtn;

public void usersendemailtofrind()
{
clickbutton(emailtofriendbtn);	
}

public void registreduseraddreview()
{
clickbutton(addreviewlink);	
}

public void addtowishlist()
{
clickbutton(addwishlistbtn);	
}
public void addtocompare()
{
clickbutton(addtocomparebtn);	
}
public void addtocardshop()
{
clickbutton(addcrtbtn);	
}
}
