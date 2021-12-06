package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	
	Actions act;
	
	public DashboardPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		act = new Actions(driver);
	}

	@FindBy(xpath = "//h1[text()='Dashboard']")
	WebElement dashboardTitle;

	@FindBy(xpath = "//a[@id=\"welcome\"]")
	WebElement welcomeMenu;
	
	@FindBy(xpath ="//a[text()='Support']/following::a[1]")
	WebElement logout;
	
	@FindBy(xpath ="//a[@id=\"menu_admin_viewAdminModule\"]")
	WebElement adminMenu;

	@FindBy(xpath = "//a[@id=\"menu_admin_UserManagement\"]")
	WebElement userManagement;
	
	@FindBy(xpath = "//a[@id=\"menu_admin_viewSystemUsers\"]")
	WebElement usersMenu;
	
	public boolean verifyPageTitle() {

		boolean status = dashboardTitle.isDisplayed();
		return status;
	}

	public String getDashboardPageTitle() {

		String title = dashboardTitle.getText();
		return title;
	}

	public boolean verifyWelcomeMenu() {

		boolean status = welcomeMenu.isDisplayed();
		return status;
	}

	public void clickWelcomeMenu() {

		welcomeMenu.click();
	}

	public void clickLogout() {
		logout.click();
	}
	
	public void clickusersMenu() {
		
		act.moveToElement(adminMenu).moveToElement(userManagement).moveToElement(usersMenu).click().build().perform();
	}
	
}
