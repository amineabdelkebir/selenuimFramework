package tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import utilities.Helper;
public class TestBases extends  AbstractTestNGCucumberTests

{

	public static WebDriver driver;
	public static String downloadpath = System
			.getProperty("C:\\Users\\Amine\\eclipse-workspace\\taf\\downloads");

	public static ChromeOptions chromeoption()
	{
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object>  chromeprefs = new HashMap<String, Object>();
		chromeprefs.put("profile.default.content_settings.popus",0);
		chromeprefs.put("profile.default_directory", downloadpath);
		options.setExperimentalOption("prefs", chromeprefs);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return options;

	}
	@BeforeSuite
	@Parameters({"browser"})

	public void startdriver(@Optional("Chrome") String	browserName)

	{
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe"); 
			driver = new ChromeDriver(chromeoption());

		}else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/drivers/geckodriver.exe"); 
			driver = new FirefoxDriver();
		}

		else if (browserName.equalsIgnoreCase("internetexplorer")) {
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/drivers/IEDriverServer.exe"); 
			driver = new InternetExplorerDriver();


		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com/");
	}

	@AfterSuite
	public void stopdriver()
	{
		driver.quit();
	}

	@AfterMethod

	public void screenshotOnfailure(ITestResult result)
	{
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed !!");
			System.out.println("Takin Screenshot ...");
			Helper.capturescreenshot(driver, result.getName());

		}
	}
}
