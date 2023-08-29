package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;


public class PropertiesUtil {
	
	private final String testdataPath = System.getProperty("user.dir")+"\\src\\test\\java\\testData\\Config.properties";
	private Properties prop;
	
	public PropertiesUtil() {
		try {
		BufferedReader isr= new BufferedReader(new FileReader(testdataPath));
		Properties prop = new Properties();
		prop.load(isr);
		isr.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getProperty(String key) {
		try {
		BufferedReader isr= new BufferedReader(new FileReader(testdataPath));
		Properties prop = new Properties();
		prop.load(isr);
		isr.close();
		return prop.getProperty(key);
		}catch(Exception e) {
			return "Error ocurred";
		} 
	}
	
	public String getAccountCreationCount() {
		return getProperty("AccountCreation");
	}
}
