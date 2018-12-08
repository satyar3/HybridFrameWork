package com.qa.zoho.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.zoho.utils.DriverManager;

public class LoginPage extends BasePage
{
	@FindBy(id = "lid")
	public WebElement email;

	@FindBy(id = "pwd")
	public WebElement pwd;

	@FindBy(id = "signin_submit")
	public WebElement login;

	public LoginPage doLogIn(String username,String password, String browser)
	{
		email.sendKeys(username);
		pwd.sendKeys(password);
		login.click();
		
		return this;
	}

//	public LoginPage(WebDriver driver)
//	{
//		PageFactory.initElements(driver, this);
//	}
	
	public LoginPage open()
	{
		DriverManager.getDriver();
		return (LoginPage) openPage(LoginPage.class);
	}

	@Override
	protected ExpectedCondition getPageLoadCondition()
	{
		return ExpectedConditions.visibilityOf(email);
	}
}
