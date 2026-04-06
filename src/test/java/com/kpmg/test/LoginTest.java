package com.kpmg.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class LoginTest {

	Playwright playwright;
	Browser browser;
	BrowserContext context;
	Page page;

	@BeforeMethod

	public void browserDetails() {

		playwright = Playwright.create();
		browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false).setChannel("chrome"));
		context = browser.newContext();
		page = context.newPage();

		page.navigate("https://demo.openemr.io/a/openemr/interface/login/login.php?site=default");
	}

	@AfterMethod

	public void browserClose() {

		page.waitForTimeout(6000);
		playwright.close();

	}
	
	@Test(priority = 1)
	public void getTitle_T01() {
		
		System.out.println(page.title());
		
	}
	
	@Test(priority = 2)
	
	public void getCenterText_T02() {
		
		String actualText = page.locator("xpath=//p[contains(text(),'The most popular')]").innerText();
		System.out.println(actualText);
	}

}
