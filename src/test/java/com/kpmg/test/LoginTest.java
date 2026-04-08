package com.kpmg.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.kpmg.base.AutomationWrapper;
import com.microsoft.playwright.options.SelectOption;

public class LoginTest extends AutomationWrapper {

	@DataProvider
	public String[][] loginCredentials() {

		String[][] loginDetails = new String[2][4];
		loginDetails[0][0] = "admin";
		loginDetails[0][1] = "pass";
		loginDetails[0][2] = "18";
		loginDetails[0][3] = "Calendar";
		loginDetails[1][0] = "physician";
		loginDetails[1][1] = "physician";
		loginDetails[1][2] = "18";
		loginDetails[1][3] = "Calendar";

		return loginDetails;
	}

	@Test(dataProvider = "loginCredentials")
	public void validLoginTest(String userName, String passWord, String langValue, String expectedText) {
		page.locator("xpath=//input[@id='authUser']").fill(userName);
		page.locator("xpath=//input[@id='clearPass']").fill(passWord);
		page.locator("xpath=//select[@name='languageChoice']").selectOption(new SelectOption().setValue(langValue));
		page.locator("xpath=//button[@id='login-button']").click();
		String actualtext = page.locator("xpath=//span[text()='Calendar']").innerText();
		Assert.assertEquals(actualtext, expectedText);

	}

	@Test
	public void invalidLoginTest() {
		page.locator("xpath=//input[@id='authUser']").fill("admin");
		page.locator("xpath=//input[@id='clearPass']").fill("admin123");
		page.locator("xpath=//select[@name='languageChoice']").selectOption(new SelectOption().setValue("18"));
		page.locator("xpath=//button[@id='login-button']").click();
		String errorText = page.locator("xpath=//p[contains(text(),'Invalid username')]").innerText();
		Assert.assertTrue(errorText.contains("Invalid username"));

	}

}
