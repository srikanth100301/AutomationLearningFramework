package runner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import businessLogic.CSCLogic;
import commonPackage.Driver;
import pages.CSC;
import pages.IMCLogic;
import pages.LoginPage;
import util.PropertiesUtil;

public class TestClass {
	Driver driver = new Driver();
	LoginPage applicationLogin = new LoginPage();
	CSCLogic cscLogic = new CSCLogic();
	IMCLogic imcLogic =  new IMCLogic();
	WebDriver webdriverr = null;
	PropertiesUtil pUtil = new PropertiesUtil();
	
	@BeforeClass
	public void openURL() throws Exception {
		webdriverr = driver.getBrowser("CHROME");
		driver.url(webdriverr, "https://nttastgcscp2.tollplus.com/#/login");
	}

	@BeforeMethod
	public void loginApp() throws Exception {
		applicationLogin.loginApplication(webdriverr);
	}

	@Test
	public void createAccountRunner() throws Exception {
		String acc = pUtil.getAccountCreationCount();
		System.out.println("Account "+acc);
		cscLogic.openAccount(webdriverr, "");
		imcLogic.customerFullfillment(webdriverr, "");
	}

	@AfterMethod
	public void logutApp() throws Exception {
		applicationLogin.logutApplication(webdriverr);
	}

	@AfterClass
	public void closeBrowser() throws Exception {
		// driver.Browser(webdriverr);
	}

}
