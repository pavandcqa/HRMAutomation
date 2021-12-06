package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import base.TestBase;

public class LoginPageTestCases extends TestBase{

	@Test(priority = 1, groups = {"smoke"})
	public void HRM_LoginPage_VerifyLoginWithValidCredentials() {
		
		log.info("user is on DashboardPage");
		
		String expectedTitle = "XYZDashboard";
		String actualTitlte = dp.getDashboardPageTitle();
		Assert.assertEquals(actualTitlte, expectedTitle, "LoginFailed..!");
	}
	
	@Test(priority = 2,enabled = false)
	public void HRM_LoginPage_VerifyLoginWithInvalidCredentials() {
		
		Logger log = Logger.getLogger(LoginPageTestCases.class);
		
		log.info("user is on login page and trying to verify login with invalid credentials");
		
		Assert.assertTrue(lp.verifyPresenceOfUserNameField(), "Username InputBox not present..!");
		lp.setUserName("Admin");
		
		log.info("entered username");
		
		Assert.assertTrue(lp.verifyPresenceOfPasswordField(), "Password InputBox not present..!");
		lp.setPassword("xyz");
		
		log.info("entered invalid password");
		
		Assert.assertTrue(lp.verifyLoginBtnEnabled(), "LoginBtn Disabled..!");
		lp.clickLogin();
		
		log.info("clicked on login btn");
		
		String expectedValue = "Invalid credentials";
		String actualValue = lp.getInvalidLoginErrorMessage();
		
		Assert.assertEquals(actualValue, expectedValue, "Login Success.. and TestFailed");
	}
	
}
