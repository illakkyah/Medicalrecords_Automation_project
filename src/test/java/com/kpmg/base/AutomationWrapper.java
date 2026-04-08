package com.kpmg.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class AutomationWrapper {
	
	private Playwright playwright;
	private Browser browser;
	private BrowserContext context;
	protected Page page;

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

		page.waitForTimeout(3000);
		playwright.close();

	}

}
