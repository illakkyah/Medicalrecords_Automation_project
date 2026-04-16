package com.kpmg.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class MainPage {
	
private Page page;
	
	public MainPage(Page page) {
		this.page = page;
	}
	
	public void mainPagePopUp() {
		page.locator("xpath=//button[text()='Ask again later']").click();
	}
	
	public String clickOnCalendar() {
		return page.locator("xpath=//span[text()='Calendar']").innerText();	
	}
	
	public void clickOnPatient() {
		 page.locator("xpath=//div[text()='Patient']").hover();
		
	}
	
	public void clickOnNewSearch() {
		 page.locator("xpath=//div[text()='New/Search']").click();
	}
	
	public String recordDashboard() {
		return page.locator("xpath=//span[contains(text(),'Medical Record Dashboard')]").innerText();
	}
	
	
	
	
	

}
