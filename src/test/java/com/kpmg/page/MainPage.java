package com.kpmg.page;

import com.kpmg.base.PlaywrightKeywords;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class MainPage extends PlaywrightKeywords{
	
private Page page;
private String mainpopupLocator="xpath=//button[text()='Ask again later']";
private String calendarLocator="xpath=//span[text()='Calendar']";
private String patientmenuLocator="xpath=//div[text()='Patient']";
private String newsearchLocator="xpath=//div[text()='New/Search']";
private String dashboardLocator="xpath=//span[contains(text(),'Medical Record Dashboard')]";
	
	public MainPage(Page page) {
		super(page);
		this.page = page;
	}
	
	public void mainPagePopUp() {
		//page.locator(mainpopupLocator).click();
		clickonElement(mainpopupLocator);
	}
	
	public String clickOnCalendar() {
		//return page.locator(calendarLocator).innerText();	
		return getinnertextfromElement(calendarLocator);
	}
	
	public void clickOnPatient() {
		 //page.locator(patientmenuLocator).hover();
		 hoveronElement(patientmenuLocator);
		
	}
	
	public void clickOnNewSearch() {
		 //page.locator(newsearchLocator).click();
		 clickonElement(newsearchLocator);
	}
	
	public String recordDashboard() {
		//return page.locator(dashboardLocator).innerText();
		return getinnertextfromElement(dashboardLocator);
	}
	
	
	
	
	

}
