package com.qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("F:\\Tushar Data\\API_Testing\\rest_api_workspace\\CucumberPOMArchitech\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(fis);
		} 
		catch (IOException e) {
			e.getMessage();
		}				
	}
	
	public static void initialization()
	{
		 String browserName = prop.getProperty("browser");
		 
		 if(browserName.equals("chrome"))
		 {
		    	System.setProperty("webdriver.chrome.driver", "F:\\Tushar Data\\drivers\\chromedriver.exe");
		    	driver= new ChromeDriver();
		 }
		 else if(browserName.equals("firefox"))
		 {
			 System.setProperty("webdriver.gecko.driver", "F:\\Tushar Data\\drivers\\geckodriver.exe");
		     driver= new FirefoxDriver();
		 }
		 
		 else
		 {
			 System.setProperty("webdriver.ie.driver", "F:\\Tushar Data\\drivers\\ie.exe");
		     driver= new InternetExplorerDriver();
		 }
		 
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(TestUtil.IMPPLICIT_WAIT, TimeUnit.SECONDS);
		 
		 driver.get(prop.getProperty("url"));
		 
	}
	 
	
}
