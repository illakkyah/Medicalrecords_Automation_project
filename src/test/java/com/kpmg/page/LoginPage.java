package com.kpmg.page;

import com.kpmg.base.PlaywrightKeywords;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

public class LoginPage extends PlaywrightKeywords {

	private Page page;
	private String usernameLocator = "xpath=//input[@id='authUser']";
	private String passwordLocator = "xpath=//input[@id='clearPass']";
	private String languageLocator = "xpath=//select[@name='languageChoice']";
	private String loginLocator = "xpath=//button[@id='login-button']";
	private String acknowledgementLocator = "xpath=//a[text()='Acknowledgments, Licensing and Certification']";
	private String headerLocator = "xpath=//p[contains(text(),'The most popular')]";
	private String invaliderrorLocator = "xpath=//p[contains(text(),'Invalid username')]";

	public LoginPage(Page page) {
		super(page);
		this.page = page;
	}

	public void enterUserName(String userName) {
		// page.locator(usernameLocator).fill(userName);
		super.filltexttoElement(usernameLocator, userName);
	}

	public void enterPassword(String passWord) {
		// page.locator(passwordLocator).fill(passWord);
		super.filltexttoElement(passwordLocator, passWord);
	}

	public void selectLanguage(String langValue) {
		// page.locator(languageLocator).selectOption(new
		// SelectOption().setValue(langValue));
		super.selectElementbyValue(languageLocator, langValue);
	}

	public void clickOnLogin() {
		// page.locator(loginLocator).click();
		super.clickonElement(loginLocator);
	}

	public Page clickOnAckLink() {
		Page newTab = page.waitForPopup(() -> {
			page.locator(acknowledgementLocator).click();
		});
		return newTab;
	}

	public String getLoginHeader() {
		// return page.locator(headerLocator).innerText();
		return super.getinnertextfromElement(headerLocator);
	}

	public String getLoginTitle() {
		return page.title();
	}

	public String getInvalidErrorMessage() {
		//return page.locator(invaliderrorLocator).innerText();
		return super.getinnertextfromElement(invaliderrorLocator);
	}

}
