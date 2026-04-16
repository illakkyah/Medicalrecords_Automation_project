package com.kpmg.page;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

public class LoginPage {

	private Page page;

	public LoginPage(Page page) {
		this.page = page;
	}

	public void enterUserName(String userName) {
		page.locator("xpath=//input[@id='authUser']").fill(userName);
	}

	public void enterPassword(String passWord) {
		page.locator("xpath=//input[@id='clearPass']").fill(passWord);
	}

	public void selectLanguage(String langValue) {
		page.locator("xpath=//select[@name='languageChoice']").selectOption(new SelectOption().setValue(langValue));
	}

	public void clickOnLogin() {
		page.locator("xpath=//button[@id='login-button']").click();
	}

	public Page clickOnAckLink() {
		Page newTab = page.waitForPopup(() -> {
			page.locator("xpath=//a[text()='Acknowledgments, Licensing and Certification']").click();
		});
		return newTab;
	}

	public String getLoginHeader() {
		return page.locator("xpath=//p[contains(text(),'The most popular')]").innerText();
	}
	
	public String getLoginTitle() {
		return page.title();
	}

	public String getInvalidErrorMessage() {
		return page.locator("xpath=//p[contains(text(),'Invalid username')]").innerText();
	}

}
