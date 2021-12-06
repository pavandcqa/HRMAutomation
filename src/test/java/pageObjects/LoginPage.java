package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By userNameInputBox = By.xpath("//input[@id=\"txtUsername\"]");
	By passwordInputBox = By.xpath("//input[@id=\"txtPassword\"]");
	By loginBtn = By.xpath("//input[@id=\"btnLogin\"]");
	By errorMessage = By.xpath("//span[text()='Invalid credentials']");

	public boolean verifyPresenceOfUserNameField() {

		boolean status = driver.findElement(userNameInputBox).isDisplayed();
		return status;
	}

	public void setUserName(String uname) {
		driver.findElement(userNameInputBox).clear();
		driver.findElement(userNameInputBox).sendKeys(uname);
	}

	public boolean verifyPresenceOfPasswordField() {

		boolean status = driver.findElement(passwordInputBox).isDisplayed();
		return status;
	}

	public void setPassword(String pwd) {
		driver.findElement(passwordInputBox).clear();
		driver.findElement(passwordInputBox).sendKeys(pwd);
	}

	public boolean verifyLoginBtnEnabled() {

		boolean status = driver.findElement(loginBtn).isEnabled();
		return status;
	}

	public void clickLogin() {

		driver.findElement(loginBtn).click();
	}
	
	public String getInvalidLoginErrorMessage() {
		
		String errorMsg = driver.findElement(errorMessage).getText();
		return errorMsg;
	}
}
