package com.qa.zoho.rough;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.zoho.base.TestBase;

public class TestCase01 extends TestBase
{	
	
	@Test(dataProvider = "getData")
	public void doLogIn(String username, String password, String browserName)
	{
		openBrowser(browserName);
		
		getDriver().findElement(By.xpath("//a[@class='zh-login' and text()='Login']")).click();		
		getDriver().findElement(By.id("lid")).sendKeys(username);
		getDriver().findElement(By.id("pwd")).sendKeys(password);
		getDriver().findElement(By.id("signin_submit")).click();
		
		tearDown();		
	}
	
	@DataProvider(parallel = true)
	public Object[][] getData()
	{
		Object[][] obj = new Object[2][3];
		
		obj[0][0] = "trainer@way2automation.com";
		obj[0][1] = "Selenium@1234";
		obj[0][2] = "Chrome";
		
		obj[1][0] = "trainer@way2automation.com";
		obj[1][1] = "Selenium@1234";
		obj[1][2] = "Firefox";
		
		return obj;
	}
}
