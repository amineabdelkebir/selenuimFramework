package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
public class CheckoutPage extends PageBases {

	public CheckoutPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id="BillingNewAddress_FirstName")
	WebElement firstnametextbox;

	@FindBy(id="BillingNewAddress_LastName")
	WebElement lastnametextbox;

	@FindBy(id="BillingNewAddress_Email")
	WebElement emailtextbox;

	@FindBy(id="BillingNewAddress_CountryId")
	WebElement listofcountry;

	@FindBy(id="BillingNewAddress_StateProvinceId")
	WebElement listofstate;

	@FindBy(id="BillingNewAddress_City")
	WebElement statetextbox;

	@FindBy(id="BillingNewAddress_Address1")
	WebElement adressetextbox;

	@FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement zipcodetextbox;

	@FindBy(id="BillingNewAddress_PhoneNumber")
	WebElement phonenumtextbox;

	@FindBy(css="input.button-1.new-address-next-step-button")
	WebElement billingadrbtn;

	@FindBy(id="shippingoption_0")
	WebElement checkshipping1;

	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[1]/h1")
	public WebElement thnxlabel;

	@FindBy(linkText = "Click here for order details.")
	WebElement ordertetailslink;

	/*@FindBy(id="shippingoption_1")
	WebElement checkshipping2;

	@FindBy(id="shippingoption_2")
	WebElement checkshipping3;*/
	@FindBy(css="input.button-1.shipping-method-next-step-button")
	WebElement shippingbtn;


	@FindBy(id = "paymentmethod_0")
	WebElement methodmoneyorder;

	@FindBy(css = "input.button-1.payment-method-next-step-button")
	WebElement paymentmetbtn;

	@FindBy(id = "CreditCardType")
	WebElement selectcreditcard;

	@FindBy(id= "CardholderName")
	WebElement cardnametextbox;

	@FindBy(id="CardNumber")
	WebElement creditnumbertextbox;

	@FindBy(id="ExpireMonth")
	WebElement expiremounth;

	@FindBy(id="ExpireYear")
	WebElement expireyear;

	@FindBy(css="a.product-name")
	WebElement prodname;

	@FindBy(id="CardCode")
	WebElement codetextbox;

	@FindBy(css="input.button-1.payment-info-next-step-button")
	WebElement infopayptbtn;

	@FindBy(css="input.button-1.confirm-order-next-step-button")
	WebElement confirmshopbtn;

	@FindBy(id="BillingNewAddress_Company")
	WebElement companytextbox;
	
	@FindBy(css="input.button-1.checkout-as-guest-button")
	WebElement guestcheck;

	public void registredusercheckoutproduct(String countryname,String adresse,String postcode,
			String phone,String city,String productname) throws InterruptedException
	{
		select = new Select(listofcountry);
		select.selectByVisibleText(countryname);
		settext(adressetextbox, adresse);
		settext(zipcodetextbox, postcode);
		settext(phonenumtextbox, phone);
		settext(statetextbox, city);

		clickbutton(billingadrbtn);
		Thread.sleep(1000); 
		clickbutton(checkshipping1);

		Thread.sleep(1000);
		clickbutton(shippingbtn);

		clickbutton(methodmoneyorder);
		clickbutton(paymentmetbtn);

		clickbutton(infopayptbtn);
		clickbutton(confirmshopbtn);
		clickbutton(ordertetailslink);






		//Assert.assetTrue(Productname.isdisplayed());
		//	Assert.assetTrue(Productname.gettext().contains(productname);
		//Assert.assertTrue(thankyoulbl.isDisplayed());

		//Assert.assertTrue(succesmessage.gettext().contains(""));

//button-1 checkout-as-guest-button
	}

	public void checkoutproduct(String firstname,String lastname, 
			String email,String countryname,String postcode,
			String phone,String city,
			String company ,String productname,String adresse) throws InterruptedException
	{
		clickbutton(guestcheck);
		settext(firstnametextbox, firstname);
		settext(lastnametextbox, lastname);
		settext(emailtextbox, email);
		settext(companytextbox, company);
		select = new Select(listofcountry);
		select.selectByVisibleText(countryname);
		settext(statetextbox, city);
		settext(zipcodetextbox, postcode);
		settext(phonenumtextbox, phone);
		settext(adressetextbox, adresse);
		

		clickbutton(billingadrbtn);
		Thread.sleep(1000); 
		clickbutton(checkshipping1);

		Thread.sleep(1000);
		clickbutton(shippingbtn);

		clickbutton(methodmoneyorder);
		clickbutton(paymentmetbtn);

		clickbutton(infopayptbtn);
		clickbutton(confirmshopbtn);
		clickbutton(ordertetailslink);






		//Assert.assetTrue(Productname.isdisplayed());
		//	Assert.assetTrue(Productname.gettext().contains(productname);
		//Assert.assertTrue(thankyoulbl.isDisplayed());

		//Assert.assertTrue(succesmessage.gettext().contains(""));


	}



	/*public void confirmorder(String cardtype ,String cardname,String cardnumber,String code,String mounth,String year) 
			throws InterruptedException
	{
		select = new Select(selectcreditcard);
		select.selectByVisibleText(cardtype);
		settext(cardnametextbox,cardname);
		settext(creditnumbertextbox,cardnumber);
		select = new Select(expiremounth);
		select.deselectByVisibleText(mounth);
		select = new Select(expireyear);
		select.deselectByVisibleText(year);

		settext(codetextbox,code);
		clickbutton(infopayptbtn);
		Thread.sleep(1000);
		clickbutton(confirmshopbtn);

	}*/
}


