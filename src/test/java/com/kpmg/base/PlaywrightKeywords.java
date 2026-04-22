package com.kpmg.base;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

public class PlaywrightKeywords {

	private Page page;

	public PlaywrightKeywords(Page page) {
		this.page = page;
	}

	public void clickonElement(String xpathLocator) {
		page.locator(xpathLocator).click();
	}

	public void filltexttoElement(String xpathLocator, String text) {
		page.locator(xpathLocator).fill(text);
	}

	public void selectElementbyValue(String xpathLocator, String value) {
		page.locator(xpathLocator).selectOption(new SelectOption().setValue(value));
	}

	public String getinnertextfromElement(String xpathLocator) {
		return page.locator(xpathLocator).innerText();
	}
	
	public void hoveronElement(String xpathLocator) {
		page.locator(xpathLocator).hover();
	}

}
