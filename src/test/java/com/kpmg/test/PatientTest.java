package com.kpmg.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kpmg.base.AutomationWrapper;
import com.kpmg.page.AddPatientPage;
import com.kpmg.page.LoginPage;
import com.kpmg.page.MainPage;
import com.kpmg.utilities.DataSource;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.assertions.LocatorAssertions.ContainsTextOptions;
import com.microsoft.playwright.options.SelectOption;

public class PatientTest extends AutomationWrapper {

	@Test(dataProvider = "commonDataProvider",dataProviderClass = DataSource.class)
	public void addValidPatientTest(String userName, String passWord, String langValue, String expectedText, String firstName, String lastName,String dob, String gender, String dashboardHeader) {
		/*
		 * page.locator("xpath=//input[@id='authUser']").fill("admin");
		 * page.locator("xpath=//input[@id='clearPass']").fill("pass");
		 * page.locator("xpath=//select[@name='languageChoice']").selectOption(new
		 * SelectOption().setValue("18"));
		 * page.locator("xpath=//button[text()='Login']").click(); String actualtext =
		 * page.locator("xpath=//span[text()='Calendar']").innerText();
		 */
		LoginPage login= new LoginPage(page);
		login.enterUserName(userName);
		login.enterPassword(passWord);
		login.selectLanguage(langValue);
		login.clickOnLogin();
		
		MainPage main=new MainPage(page);
		Assert.assertEquals(main.clickOnCalendar(), "Calendar");

		// Frame frame=page.frame("logoutinnerframe");
		// page.locator("xpath=//div[text()='OpenEMR Product
		// Registration']").scrollIntoViewIfNeeded();
		// page.locator("xpath=//div[text()='OpenEMR Product
		// Registration']").isVisible();
		// System.out.println(popup);
		// page.locator("xpath=//div[text()='OpenEMR Product
		// Registration']").scrollIntoViewIfNeeded();
		// page.evaluate("document.body.style.zoom='0.8'");

		/*
		 * // page.locator("xpath=//button[text()='Ask again later']").click();
		 * page.locator("xpath=//div[text()='Patient']").hover();
		 * page.locator("xpath=//div[text()='New/Search']").click();
		 */
		//main.mainPagePopUp();
		main.clickOnPatient();
		main.clickOnNewSearch();
	
		
		/*
		 * FrameLocator frame = page.frameLocator("xpath=//iframe[@name='pat']");
		 * frame.locator("xpath=//input[@placeholder='First Name']").fill("Jack");
		 * 
		 * frame.locator("xpath=//input[@placeholder='Last Name']").fill("wick");
		 * 
		 * frame.locator("xpath=//input[@id='form_DOB']").fill("16-4-2026");
		 * frame.locator("xpath=//select[@title='Birth Sex']").selectOption(new
		 * SelectOption().setLabel("Female"));
		 * frame.locator("xpath=//button[@id='create']").click();
		 * page.waitForTimeout(2000); FrameLocator frame1 =
		 * page.frameLocator("xpath=//iframe[@id='modalframe']"); //
		 * frame1.locator("xpath=//button[contains(text(),'Confirm Create ')]").click();
		 * frame1.locator("xpath=//button[@id='confirmCreate']").click(); String
		 * actualDashboardHeader =
		 * frame.locator("xpath=//span[contains(text(),'Medical Record Dashboard')]")
		 * .innerText();
		 */
		
		FrameLocator frame = page.frameLocator("xpath=//iframe[@name='pat']");
		FrameLocator frame1 = page.frameLocator("xpath=//iframe[@id='modalframe']");
		AddPatientPage addPatient=new AddPatientPage(page, frame, frame1);
		addPatient.enterFirstName(firstName);
		addPatient.enterLastName(lastName);
		addPatient.enterDOB(dob);
		addPatient.selectGender(gender);
		addPatient.clickCreatePatient();
		addPatient.clickOnConfirmCreateNewPatient();
		
		
		Assert.assertTrue(main.recordDashboard().contains("Medical Record Dashboard"));
	}

}
