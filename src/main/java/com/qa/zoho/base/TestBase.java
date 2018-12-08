package com.qa.zoho.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

import com.qa.zoho.utils.DriverManager;

public class TestBase extends DriverManager
{	
	
	public void openBrowser(String browserName)
	{
		System.out.println("Launching from :"+getClass().getName());
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\exe_files\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("useAutomationExtension", false);
			driver = new ChromeDriver(options);
			System.out.println("Launching from :"+getClass().getName()+" "+browserName);
		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\exe_files\\geckodriver.exe");
			driver = new FirefoxDriver();
			System.out.println("Launching from :"+getClass().getName()+" "+browserName);
		}
		
		DriverManager.setDriver(driver);		
	
		DriverManager.getDriver().manage().deleteAllCookies();
		DriverManager.getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		DriverManager.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		DriverManager.getDriver().manage().window().maximize();
		
		DriverManager.getDriver().get("https://www.zoho.com");
	}
	
	
	@AfterTest
	public void tearDown()
	{
		DriverManager.getDriver().quit();
	}
}
