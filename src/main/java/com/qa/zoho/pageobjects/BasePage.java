package com.qa.zoho.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.zoho.utils.DriverManager;

public abstract class BasePage<T>
{
	WebDriver driver;
	public BasePage()
	{
		this.driver = DriverManager.getDriver();
	}
	
	public T openPage(Class cls)
	{
		T page = null;
		page = (T) PageFactory.initElements(DriverManager.getDriver(), cls);
		ExpectedCondition pageLoadCondition = ((BasePage) page).getPageLoadCondition();
		waitForPageLoad(pageLoadCondition);
		return page;
		
	
	}
	
	protected abstract ExpectedCondition getPageLoadCondition();
	
	private void waitForPageLoad(ExpectedCondition pageLoadCondition)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(pageLoadCondition);
	}
}
