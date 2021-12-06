package base;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.SystemUsers;
import utils.ConfigReader;

public class TestBase {

	static protected WebDriver driver;
	protected LoginPage lp;
	protected DashboardPage dp;
	protected SystemUsers sp;
	protected ConfigReader config;
	
	protected Logger log;
	
	@Parameters({"browser", "appUrl"})
	@BeforeMethod(alwaysRun = true)
	public void login(String brOption, String url) {

		log = Logger.getLogger(TestBase.class);
		
		log.info("*********** Initializing **********");
		
		log.info("Initializing Properties File Object");
		
		config = new ConfigReader();
		
		System.out.println(brOption);
		System.out.println(url);
		if(brOption.equals("chrome")) {
			
			System.setProperty(config.getChromeKey(), config.getChromePath());
			System.out.println("*************** Setting up Browser ********************");
			driver = new ChromeDriver();
		}
		else if (brOption.equals("firefox")) {
			System.setProperty(config.getFirefoxKey(), config.getFirefoxPath());
			System.out.println("*************** Setting up Browser ********************");
			driver = new FirefoxDriver();
		}
		
		System.out.println("*************** Initializing Browser ********************");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(url);

		System.out.println("Navigated to appurl " + url);
		
		lp = new LoginPage(driver);
		Assert.assertTrue(lp.verifyPresenceOfUserNameField(), "Username InputBox not present..!");
		lp.setUserName(config.getUserName());
		Assert.assertTrue(lp.verifyPresenceOfPasswordField(), "Password InputBox not present..!");
		lp.setPassword(config.getPassword());
		Assert.assertTrue(lp.verifyLoginBtnEnabled(), "LoginBtn Disabled..!");
		lp.clickLogin();
		
		dp = new DashboardPage(driver);
		sp = new SystemUsers(driver);
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		
		dp.clickWelcomeMenu();
		dp.clickLogout();
		System.out.println("Successfully Loggedout from the application");
		
		driver.close();
		System.out.println("******************** CLOSING THE BROWSER **************");
	}
}
