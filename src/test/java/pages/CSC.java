package pages;

import org.openqa.selenium.WebDriver;

import util.ActionClass;

public class CSC {
	ActionClass actionClass = new ActionClass();

	public void navigateCSC(WebDriver driver, String SubMenu) throws Exception {
		actionClass.click(driver, "Xpath", "//a[@title=\"Customer Service Center\"]");
		switch (SubMenu) {
		case "OpenAccount":
			actionClass.click(driver, "Xpath", "//a[contains(text(),'Open Account')]");
			break;

		}
	}

	public void demoGraphic(WebDriver driver, String accountType) throws Exception {
		switch (accountType) {
		case "ComercialRevenue":
			actionClass.dropDown(driver, "VALUE",
					"//label[contains(text(),'Account Type')]/following::select[@id='userTypeSelected']", "Business");
			actionClass.sendKeys(driver, "Xpath", "//input[@id='businessName']", "kesineni");
			break;
		}
		actionClass.sendKeys(driver, "Xpath", "//input[@id=\"firstName\"]", "praveen");
		actionClass.sendKeys(driver, "Xpath", "//input[@id=\"Lastname\"]", "reddem");
		actionClass.sendKeys(driver, "Xpath", "//input[@id=\"addressLine1\"]", "b-10,1403,blzvadum");
		actionClass.sendKeys(driver, "Xpath", "//input[@id=\"addressCity\"]", "Texas");
		actionClass.sendKeys(driver, "Xpath", "//input[@id=\"addressZip1\"]", "12345");
		actionClass.sendKeys(driver, "Xpath", "//input[@id=\"primaryEmail\"]", "te@tp.com");
		actionClass.sendKeys(driver, "Xpath", "//input[@id=\"primaryConfirmEmail\"]", "te@tp.com");
		actionClass.sendKeys(driver, "Xpath", "//input[@id=\"mobilePhone\"]", "9999999999");
		actionClass.click(driver, "Xpath", "//span[contains(text(),'Vehicles and Tags')]/..");

	}

	public void vehicleClass(WebDriver driver, String accountType) throws Exception {
		Thread.sleep(5000);

		actionClass.sendKeys(driver, "Xpath", "//input[@id=\"pltNumbers\"]",
				actionClass.randomData("AlphaNumeric", 8).toUpperCase());
		actionClass.click(driver, "Xpath", "//select[@id=\"pltYear\"]");
		actionClass.dropDown(driver, "INDEX", "//select[@id=\"pltYear\"]", "4");
		actionClass.click(driver, "Xpath", "//select[@id=\"pltMake\"]");
		actionClass.dropDown(driver, "INDEX", "//select[@id=\"pltMake\"]", "4");
		actionClass.click(driver, "Xpath", "//select[@id=\"pltModel\"]");
		actionClass.dropDown(driver, "INDEX", "//select[@id=\"pltModel\"]", "2");
		actionClass.click(driver, "Xpath", "//select[@id=\"pltColor\"]");
		actionClass.dropDown(driver, "INDEX", "//select[@id=\"pltColor\"]", "2");

		actionClass.scrollDown(driver);
		actionClass.click(driver, "Xpath", "//input[@name=\"requestTransponder\"]");
		actionClass.click(driver, "Xpath",
				"//select[@formcontrolname=\"transponderMounting\"]/following::button[.='Next']");
		Thread.sleep(5000);
		actionClass.click(driver, "Xpath",
				"(//strong[contains(text(),'Low Balance Amount:')])[1]/following::button[2]");
		switch (accountType) {
		case "ComercialRevenue":

			break;

		case "":
			actionClass.click(driver, "Xpath", "//label[@for=\"this.primaryReplenishmentAmount\"]");
			break;
		}

		actionClass.click(driver, "Xpath",
				"//h4[contains(text(),'Please confirm to proceed:')]/following::button[contains(text(),'Next')]");

	}

	public void preview(WebDriver driver) throws Exception {
		actionClass.scrollDown(driver);
		actionClass.click(driver, "Xpath",
				"//span[contains(text(),'Vehicles and Tags')]/following::span[contains(text(),'Pay')]/..");
	}

	public void payment(WebDriver driver) throws Exception {
		actionClass.click(driver, "Xpath", "//select[@id=\"payMethod\"]");
		actionClass.dropDown(driver, "INDEX", "//select[@id=\"payMethod\"]", "1");
		actionClass.click(driver, "Xpath", "//span[contains(text(),'Make Payment')]/..");
		actionClass.click(driver, "Xpath", "//button[contains(text(),'Pay Now')]");

		String accountNumber = actionClass.getText(driver, "//td[contains(text(),'Account # ')]/following::td[1]")
				.trim().replaceAll("[^0-9]", "");
		actionClass.setvalues("AccountNumber", accountNumber);
		System.setProperty("AccountNumber", accountNumber);
	}

}
