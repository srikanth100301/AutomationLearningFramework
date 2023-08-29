package pages;

import org.openqa.selenium.WebDriver;

import util.ActionClass;

public class LoginPage {
	ActionClass actionClass = new ActionClass();

	public void loginApplication(WebDriver driver) throws Exception {
		actionClass.sendKeys(driver, "Name", "UserName", "preddem");
		actionClass.sendKeys(driver, "Name", "Password", "King@2024@");
		actionClass.click(driver, "Xpath", "//input[@value='Submit']");
		actionClass.dropDown(driver, "INDEX", "//select[@id='location']", "5");
		actionClass.click(driver, "Xpath", "//input[@value='Submit']");
	}
	
	public void logutApplication(WebDriver driver) throws Exception {
	}
}
