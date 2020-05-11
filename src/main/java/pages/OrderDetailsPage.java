package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends PageBases {

	public OrderDetailsPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(css="a.button-2.print-order-button")
	WebElement printbtn;

	@FindBy(css="a.button-2.pdf-invoice-button")
	WebElement pdfbtn;
	
	@FindBy(css="input.button-1.re-order-button")
	WebElement reorderbtn;
	
	public void printorder()
	{
		clickbutton(printbtn);
	}
	public void saveaspdforder() throws InterruptedException
	{
		clickbutton(pdfbtn);
		Thread.sleep(2000);
	}
}
