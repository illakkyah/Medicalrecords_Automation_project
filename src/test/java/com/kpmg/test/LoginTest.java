package com.kpmg.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.kpmg.base.AutomationWrapper;
import com.kpmg.page.LoginPage;
import com.kpmg.page.MainPage;
import com.kpmg.utilities.DataSource;
import com.microsoft.playwright.options.SelectOption;

public class LoginTest extends AutomationWrapper {

	@Test(dataProvider = "commonDataProvider",dataProviderClass = DataSource.class)
	public void validLoginTest(String userName, String passWord, String langValue, String expectedText) {
		/*
		 * page.locator("xpath=//input[@id='authUser']").fill(userName);
		 * page.locator("xpath=//input[@id='clearPass']").fill(passWord);
		 * page.locator("xpath=//select[@name='languageChoice']").selectOption(new
		 * SelectOption().setValue(langValue));
		 * page.locator("xpath=//button[@id='login-button']").click(); String actualtext
		 * = page.locator("xpath=//span[text()='Calendar']").innerText();
		 */
		LoginPage login= new LoginPage(page);
		login.enterUserName(userName);
		login.enterPassword(passWord);
		login.selectLanguage(langValue);
		login.clickOnLogin();
		
		MainPage main=new MainPage(page);
		Assert.assertEquals(main.clickOnCalendar(), expectedText);
	

	}

	@Test(dataProvider = "commonDataProvider",dataProviderClass = DataSource.class)
	public void invalidLoginTest(String userName, String passWord, String langValue, String expectedError) {
		/*
		 * page.locator("xpath=//input[@id='authUser']").fill(userName);
		 * page.locator("xpath=//input[@id='clearPass']").fill(passWord);
		 * page.locator("xpath=//select[@name='languageChoice']").selectOption(new
		 * SelectOption().setValue(langValue));
		 * page.locator("xpath=//button[@id='login-button']").click(); String errorText
		 * = page.locator("xpath=//p[contains(text(),'Invalid username')]").innerText();
		 */
		LoginPage login= new LoginPage(page);
		login.enterUserName(userName);
		login.enterPassword(passWord);
		login.selectLanguage(langValue);
		login.clickOnLogin();
		
		Assert.assertTrue(login.getInvalidErrorMessage().contains(expectedError));

	}

}
