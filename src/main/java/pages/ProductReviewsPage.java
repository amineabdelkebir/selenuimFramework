package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductReviewsPage extends PageBases {

	public ProductReviewsPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(id="AddProductReview_Title")
	WebElement reviewtitletxtbox;

	@FindBy(id="AddProductReview_ReviewText")
	WebElement reviewtexttxtbox;

	@FindBy(css="div.rating-options")
	WebElement ratingoption ;
	
	@FindBy(css="input.button-1.write-product-review-button")
	WebElement sendrviewbtn ;
	
	@FindBy(css="div.result")
	public WebElement confirmsendreview ;

	public void rgistredusersendreview(String titlereview,String textreview)
	{
		settext(reviewtitletxtbox, titlereview);
		settext(reviewtexttxtbox, textreview);
		clickbutton(ratingoption);
		clickbutton(sendrviewbtn);
	}
}
