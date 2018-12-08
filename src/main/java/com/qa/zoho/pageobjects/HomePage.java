package com.qa.zoho.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.zoho.utils.DriverManager;

public class HomePage extends BasePage
{
	WebDriver driver;

	@FindBy(xpath = "//a[@class='zh-login' and text()='Login']")
	public WebElement login;

	// public HomePage(WebDriver driver)
	// {
	// this.driver = driver;
	// PageFactory.initElements(driver, this);
	// }

	public LoginPage gotoLoginPage()
	{
		login.click();
		//return new LoginPage(driver);
	}
	
	public HomePage open()
	{
		DriverManager.getDriver();
		return (HomePage) openPage(HomePage.class);
	}

	@Override
	protected ExpectedCondition getPageLoadCondition()
	{
		return ExpectedConditions.visibilityOf(login);
	}
}
