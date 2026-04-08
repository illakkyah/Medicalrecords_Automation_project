package com.kpmg.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kpmg.base.AutomationWrapper;

public class LoginUITest extends AutomationWrapper {

	@Test(priority = 1)
	public void titleTest() {

		Assert.assertEquals(page.title(), "OpenEMR Login");
		// System.out.println(page.title());

	}

	@Test(priority = 2)
	public void headerTest() {

		String actualText = page.locator("xpath=//p[contains(text(),'The most popular')]").innerText();
		// System.out.println(actualText);
		Assert.assertTrue(actualText.contains("Electronic Health Record and Medical Practice Management solution"));
	}

}
