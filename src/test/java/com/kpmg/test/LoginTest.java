package com.kpmg.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kpmg.base.AutomationWrapper;
import com.microsoft.playwright.options.SelectOption;

public class LoginTest extends AutomationWrapper {

	@Test
	public void validLoginTest() {
		page.locator("xpath=//input[@id='authUser']").fill("physician");
		page.locator("xpath=//input[@id='clearPass']").fill("physician");
		page.locator("xpath=//select[@name='languageChoice']").selectOption(new SelectOption().setValue("18"));
		page.locator("xpath=//button[@id='login-button']").click();
		String actualtext = page.locator("xpath=//span[text()='Calendar']").innerText();
		Assert.assertEquals(actualtext, "Calendar");
		
	}

	@Test
	public void invalidLoginTest() {
		page.locator("xpath=//input[@id='authUser']").fill("admin");
		page.locator("xpath=//input[@id='clearPass']").fill("admin123");
		page.locator("xpath=//select[@name='languageChoice']").selectOption(new SelectOption().setValue("18"));
		page.locator("xpath=//button[@id='login-button']").click();
		String errorText=page.locator("xpath=//p[contains(text(),'Invalid username')]").innerText(); 
		Assert.assertTrue(errorText.contains("Invalid username"));

	}

}
