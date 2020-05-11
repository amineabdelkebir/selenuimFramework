package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBases {

	protected WebDriver driver;
	public Select select;
	public JavascriptExecutor jse;
	public Actions action;
	//create constructor
	public PageBases(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	protected static void clickbutton(WebElement button)
	{
	button.click();	 	
	}
	protected static void settext(WebElement textelement,String value)
	{
		textelement.sendKeys(value);
	}
 public void scrolltobottom()
 {
	 jse.executeScript("scrollBy(0,2500)");
 }
 public void cleartext(WebElement element)
 {
	 element.clear();
	 
 }
}
