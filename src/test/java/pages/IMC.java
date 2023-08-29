package pages;

import org.openqa.selenium.WebDriver;

import util.ActionClass;

public class IMC {

	ActionClass actionClass = new ActionClass();

	public void navigateIMC(WebDriver driver, String SubMenu) throws Exception {
				actionClass.click(driver, "Xpath", "//span[contains(text(),'IMC')]");
				switch (SubMenu) {
				case "Customerfullfillment":
					actionClass.click(driver, "Xpath", "//a[text()='Customer Fulfillment']");
					break;

				}

	}
	public void fullfillment(WebDriver driver,String accountnumber) throws Exception {
		actionClass.sendKeys(driver,"Xpath","//input[@id='accountNumber']",accountnumber);
		actionClass.click(driver,"Xpath","//input[@id=\"noOfRequests\"]/following::button[contains(text(),'Search')]");
		actionClass.click(driver,"Xpath","//th[contains(text(),'Account #')]/following::span[1]");
		actionClass.click(driver,"Xpath","//a[contains(text(),'Cancel Request')]/following::a[@name=\"select\"]");
		actionClass.click(driver,"Xpath","//button[contains(text(),' Inventory New Tags ')]");
		actionClass.click(driver,"Xpath","(//select[@id=\"transponderAgency\"])[2]");
		actionClass.dropDown(driver,"VALUE","//td[contains(text(),'Tag Agency:')]/following::select[@id='transponderAgency']","DNT");
		actionClass.click(driver,"Xpath","//span[contains(text(),'Select Tag ID')]");
		actionClass.click(driver,"Xpath","//button[contains(text(),' Select ')]");
		
	}
}
