package businessLogic;

import org.openqa.selenium.WebDriver;

import pages.CSC;
import util.ActionClass;

public class CSCLogic {
	CSC accountCreation = new CSC();
	ActionClass actionClass = new ActionClass();

	/* End to End from Open Account - Payment */
	public void openAccount(WebDriver webdriverr, String accountType) throws Exception {
		
		accountCreation.navigateCSC(webdriverr, "OpenAccount");
		demographic(webdriverr, accountType);
		vehicleTags(webdriverr, accountType);
		preview(webdriverr);
		payment(webdriverr);
	}

	public void demographic(WebDriver webdriverr, String accountType) throws Exception {
		accountCreation.demoGraphic(webdriverr, accountType);
	}

	public void vehicleTags(WebDriver webdriverr, String accountType) throws Exception {
		accountCreation.vehicleClass(webdriverr, accountType);
	}

	public void preview(WebDriver webdriverr) throws Exception {
		accountCreation.preview(webdriverr);
	}

	public void payment(WebDriver webdriverr) throws Exception {
		accountCreation.payment(webdriverr);
	}

}
