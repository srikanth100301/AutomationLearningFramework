package commonPackage;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import util.ActionClass;

public class Driver {
	public WebDriver driver;
	ActionClass actionClass = new ActionClass();
	
	public WebDriver browserOpen() throws Exception {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("useAutomationExtension", false);
		chromeOptions.addArguments("log-level=3");
		chromeOptions.addArguments("--silent");
		chromeOptions.addArguments("--no-sandbox");
		chromeOptions.addArguments("--disable-dev-shm-usage");
		chromeOptions.addArguments("--remote-allow-origins=*");
		chromeOptions.addArguments("--disable-cache");
		chromeOptions.addArguments("--disable-features=VizDisplayCompositor");
		chromeOptions.addArguments("--disable-gpu");
		chromeOptions.addArguments("--disable-browser-side-navigation");
		chromeOptions.addArguments("--no-sandbox");
		chromeOptions.addArguments("--disable-dev-shm-usage");
		chromeOptions.addArguments("--remote-allow-origins=*");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		chromeOptions.setExperimentalOption("prefs", prefs);
		chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		chromeOptions.addArguments("start-maximized");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	public void url(WebDriver driver, String url) throws Exception {
		actionClass.url(driver, url);
		actionClass.sleep(driver, 50);
	}

	public WebDriver getBrowser(String browserName) throws Exception {
		WebDriver browserType = null;
		switch (browserName.toUpperCase()) {
		case "CHROME":
			browserType = browserOpen();
			break;

		case "FIREFOX":
			break;
		}
		return browserType;
	}
	
	public void Browser(WebDriver driver) throws Exception {
		actionClass.sleep(driver, 50);
		actionClass.closeBrowser(driver);
	}
}
