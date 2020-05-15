package tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;

import utilities.Helper;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class TestBases2 {
	public static  String BaseURL ="https://demo.nopcommerce.com/"; 
	protected ThreadLocal<RemoteWebDriver> driver = null;



	@BeforeClass
	@org.testng.annotations.Parameters(value= {"browser"})
	public void setup(@Optional("chrome")String browser) throws MalformedURLException
	{
		driver =  new ThreadLocal<>();
		DesiredCapabilities caps = new  DesiredCapabilities();
		caps.setCapability("browserName",browser);
		driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),caps));
				getdriver().navigate().to(BaseURL); 
	}

	public WebDriver getdriver()
	{ 
		return driver.get();

	}

	@AfterClass
	public void stopdriver()
	{
		getdriver().quit();
		driver.remove();

	}
	@AfterMethod

	public void screenshotOnfailure(ITestResult result)
	{
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed !!");
			System.out.println("Takin Screenshot ...");
			Helper.capturescreenshot(getdriver(), result.getName());

		}

	}}