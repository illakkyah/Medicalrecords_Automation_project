package com.kpmg.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.kpmg.base.AutomationWrapper;
import com.kpmg.utilities.DataSource;
import com.microsoft.playwright.options.SelectOption;

public class LoginTest extends AutomationWrapper {

	@Test(dataProvider = "commonDataProvider",dataProviderClass = DataSource.class)
	public void validLoginTest(String userName, String passWord, String langValue, String expectedText) {
		page.locator("xpath=//input[@id='authUser']").fill(userName);
		page.locator("xpath=//input[@id='clearPass']").fill(passWord);
		page.locator("xpath=//select[@name='languageChoice']").selectOption(new SelectOption().setValue(langValue));
		page.locator("xpath=//button[@id='login-button']").click();
		String actualtext = page.locator("xpath=//span[text()='Calendar']").innerText();
		Assert.assertEquals(actualtext, expectedText);
	

	}

	@Test(dataProvider = "commonDataProvider",dataProviderClass = DataSource.class)
	public void invalidLoginTest(String userName, String passWord, String langValue, String expectedError) {
		page.locator("xpath=//input[@id='authUser']").fill(userName);
		page.locator("xpath=//input[@id='clearPass']").fill(passWord);
		page.locator("xpath=//select[@name='languageChoice']").selectOption(new SelectOption().setValue(langValue));
		page.locator("xpath=//button[@id='login-button']").click();
		String errorText = page.locator("xpath=//p[contains(text(),'Invalid username')]").innerText();
		Assert.assertTrue(errorText.contains(expectedError));

	}

}
