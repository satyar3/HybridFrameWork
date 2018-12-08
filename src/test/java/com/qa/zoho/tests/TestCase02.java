package com.qa.zoho.tests;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.qa.zoho.base.TestBase;
import com.qa.zoho.dataproviders.DataProviders;
import com.qa.zoho.pageobjects.HomePage;
import com.qa.zoho.pageobjects.LoginPage;
import com.qa.zoho.utils.Constants;
import com.qa.zoho.utils.DataUtil;
import com.qa.zoho.utils.DriverManager;
import com.qa.zoho.utils.ExcelReader;

public class TestCase02 extends TestBase
{	
	
	@Test(dataProviderClass = DataProviders.class,dataProvider = "LoginTest", enabled = false)
	public void LoginTest(Hashtable<String,String> dataTable)
	{
		ExcelReader excel = new ExcelReader(Constants.MASTER_XL_PATH);
		DataUtil.checkExecution("Master", "LoginTest", dataTable.get("Runmode"), excel);
		
		openBrowser(dataTable.get("browser"));
		
		HomePage homepage = new HomePage(DriverManager.getDriver());
		LoginPage loginpage = homepage.gotoLoginPage();
		loginpage.doLogIn(dataTable.get("username"), dataTable.get("password"), dataTable.get("browser"));
		
		tearDown();		
	}
}
