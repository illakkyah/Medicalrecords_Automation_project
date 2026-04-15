package com.kpmg.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kpmg.base.AutomationWrapper;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.options.SelectOption;

public class PatientTest extends AutomationWrapper{
	
	@Test
	public void addValidPatientTest() {
		page.locator("xpath=//input[@id='authUser']").fill("admin");
		page.locator("xpath=//input[@id='clearPass']").fill("pass");
		page.locator("xpath=//select[@name='languageChoice']").selectOption(new SelectOption().setValue("18"));
		page.locator("xpath=//button[text()='Login']").click();
		String actualtext = page.locator("xpath=//span[text()='Calendar']").innerText();
		Assert.assertEquals(actualtext, "Calendar");

		// Frame frame=page.frame("logoutinnerframe");
		page.locator("xpath=//div[text()='OpenEMR Product Registration']").scrollIntoViewIfNeeded();
		page.locator("xpath=//div[text()='OpenEMR Product Registration']").isVisible();
		//System.out.println(popup);
		// page.locator("xpath=//div[text()='OpenEMR Product
		// Registration']").scrollIntoViewIfNeeded();
		// page.evaluate("document.body.style.zoom='0.8'");
		page.locator("xpath=//button[text()='Ask again later']").click();
		page.locator("xpath=//div[text()='Patient']").hover();
		page.locator("xpath=//div[text()='New/Search']").click();
		FrameLocator frame = page.frameLocator("xpath=//iframe[@name='pat']");
		frame.locator("xpath=//input[@placeholder='First Name']").fill("Jack");

		frame.locator("xpath=//input[@placeholder='Last Name']").fill("wick");

		frame.locator("xpath=//input[@id='form_DOB']").fill("15-4-2026");
		frame.locator("xpath=//select[@title='Birth Sex']").selectOption(new SelectOption().setLabel("Female"));
		frame.locator("xpath=//button[@name='create']").click();

		FrameLocator frame1 =page.frameLocator("xpath=//iframe[@id='modalframe']");
		frame1.locator("xpath=//button[contains(text(),'Confirm Create ')]").click();
		
	}

}
