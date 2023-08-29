package util;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ActionClass {
	private Hashtable<String, String> map = new Hashtable<String, String>();

	public void click(WebDriver driver, String xpathType, String path) throws Exception {
		Thread.sleep(2000);
		switch (xpathType.toUpperCase()) {
		case "XPATH":
			driver.findElement(By.xpath(path)).click();
			break;

		case "ID":
			driver.findElement(By.id(path)).click();
			break;

		case "NAME":
			driver.findElement(By.name(path)).click();
			break;
		}
	}

	public void sendKeys(WebDriver driver, String xpathType, String path, String data) throws Exception {
		Thread.sleep(2000);
		switch (xpathType.toUpperCase()) {
		case "XPATH":
			driver.findElement(By.xpath(path)).sendKeys(data);
			break;

		case "ID":
			driver.findElement(By.id(path)).sendKeys(data);
			break;

		case "NAME":
			driver.findElement(By.name(path)).sendKeys(data);
			break;
		}
	}

	public void dropDown(WebDriver driver, String dropDownType, String path, String data) throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath(path)).click();
		Select drpLocation = new Select(driver.findElement(By.xpath(path)));
		switch (dropDownType.toUpperCase()) {
		case "VALUE":
			drpLocation.selectByValue(data);
			break;

		case "INDEX":
			drpLocation.selectByIndex(Integer.valueOf(data));
			break;

		}
	}

	public void sleep(WebDriver driver, int time) throws Exception {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public void url(WebDriver driver, String url) throws Exception {
		Thread.sleep(2000);
		driver.get(url);
	}

	public void closeBrowser(WebDriver driver) throws Exception {
		driver.close();
	}

	public String randomData(String dataRequest, int count) throws Exception {
		String randomData = "";
		switch (dataRequest) {
		case "Alpha":
			randomData = RandomStringUtils.randomAlphabetic(count);
			break;

		case "Numeric":
			randomData = RandomStringUtils.randomNumeric(count);
			break;

		case "AlphaNumeric":
			randomData = RandomStringUtils.randomAlphanumeric(count);
			break;
		}
		return randomData;
	}

	public void scrollDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
	}

	public void scrollUp(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-350)", "");
	}
	
	public String getText(WebDriver driver, String xpath) {
		String value = "";
		value = driver.findElement(By.xpath(xpath)).getText();
		return value;
		
	}
	
	public void setvalues(String Key,String value) {
		map.put(Key, value);
	}
	
	public String getvalues(String Key) {
		return map.get(Key);
	}

}
