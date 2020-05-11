package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage extends PageBases{

	public ComparePage(WebDriver driver) {
		super(driver);}
		
		
	
		@FindBy(css = "a.clear-list")
		WebElement clearcomparelist;
		
		@FindBy(css = "div.no-data")
		WebElement nodatalabel;
	
		@FindBy(css = "compare-products-table")
		WebElement listelement;
	
		@FindBy(tagName = "tr")
		List<WebElement> rows;
	
		@FindBy(tagName = "td")
		List<WebElement> colums;
		
		@FindBy(linkText = "Apple MacBook Pro 13-inch")
		public WebElement firstprod;
	
        @FindBy(linkText = "Asus N551JK-XO076H Laptop")
		public WebElement secondprod;	

        public void clearcomparelist()
{
clickbutton(clearcomparelist);	
}

public void compareproduct()
{
System.out.println(rows.size());

for(WebElement row : rows)
{System.out.println(row.getText()+"\t");
for(WebElement col :colums)
{System.out.println(col.getText()+"\t");}
	}
}
}
