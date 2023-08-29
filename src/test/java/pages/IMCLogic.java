package pages;

import org.openqa.selenium.WebDriver;

import util.ActionClass;

public class IMCLogic {

	IMC imc = new IMC();
	ActionClass actionClass = new ActionClass();

	/* End to End from Open Account - Payment */
	public void customerFullfillment(WebDriver webdriverr, String tagType) throws Exception {
		imc.navigateIMC(webdriverr, "Customerfullfillment");
		String accountnumber= System.getProperty("AccountNumber");
		System.out.println(actionClass.getvalues("AccountNumber"));
		fullfillment(webdriverr, accountnumber);
	}
	
	public void fullfillment(WebDriver webdriverr, String accountnumber) throws Exception {
		imc.fullfillment(webdriverr, accountnumber);
	}

}
