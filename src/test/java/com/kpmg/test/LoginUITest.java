package com.kpmg.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kpmg.base.AutomationWrapper;
import com.kpmg.page.LoginPage;

public class LoginUITest extends AutomationWrapper {

	@Test(priority = 1)
	public void titleTest() {
		LoginPage login= new LoginPage(page);
		Assert.assertEquals(login.getLoginTitle(), "OpenEMR Login");
		// System.out.println(page.title());

	}

	@Test(priority = 2)
	public void headerTest() {
		LoginPage login= new LoginPage(page);
		//String actualText = page.locator("xpath=//p[contains(text(),'The most popular')]").innerText();
		// System.out.println(actualText);
		Assert.assertTrue(login.getLoginHeader().contains("Electronic Health Record and Medical Practice Management solution"));
	}

}
