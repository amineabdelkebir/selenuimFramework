package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBases{

	public SearchPage(WebDriver driver) {
		super(driver);
		
	}
@FindBy(id="small-searchterms")
WebElement searchtextbox;
@FindBy(css="input.button-1.search-box-button")
WebElement searchbtn;
@FindBy(id="ui-id-1")
List<WebElement> productlist;
@FindBy(linkText ="Apple MacBook Pro 13-inch")
WebElement producttitle;

public void productsearch(String productname)
{
	settext(searchtextbox, productname);
	clickbutton(searchbtn);
}

public void openproductsdetailspage()
{
clickbutton(producttitle);	
}
public void searchproductusingautosuggest(String searchtxt) throws InterruptedException
{
	settext(searchtextbox, searchtxt);
	Thread.sleep(3000);
	productlist.get(0).click();
	}
} 
