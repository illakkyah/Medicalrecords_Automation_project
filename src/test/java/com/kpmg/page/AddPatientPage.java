package com.kpmg.page;

import com.kpmg.base.PlaywrightKeywords;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

public class AddPatientPage extends PlaywrightKeywords{
	
private Page page;
private FrameLocator frame;
private FrameLocator frame1;
private String patLocator="xpath=//iframe[@name='pat']";
private String modalLocator="xpath=//iframe[@id='modalframe']";
private String firstnameLocator="xpath=//input[@placeholder='First Name']";
private String lastnameLocator="xpath=//input[@placeholder='Last Name']";
private String dobLocator="xpath=//input[@id='form_DOB']";
private String genderLocator="xpath=//select[@title='Birth Sex']";
private String createpatLocator="xpath=//button[@name='create']";
private String confirmpatLocator="xpath=//button[contains(text(),'Confirm Create ')]";

	
	public AddPatientPage(Page page, FrameLocator frame, FrameLocator frame1) {
		super(page);
		this.page = page;
		this.frame=page.frameLocator(patLocator);
		this.frame1 =page.frameLocator(modalLocator);
	}
	
	public void enterFirstName(String firstName) {
		frame.locator(firstnameLocator).fill(firstName);
	}
	
	public void enterLastName(String lastName) {
		frame.locator(lastnameLocator).fill(lastName);
	}
	
	public void enterDOB(String dob) {
		frame.locator(dobLocator).fill(dob);	
	}
	
	public void selectGender(String gender) {
		frame.locator(genderLocator).selectOption(new
				 SelectOption().setLabel(gender));
	}
	
	public void clickCreatePatient() {
		frame.locator(createpatLocator).click();
	}
	
	public void clickOnConfirmCreateNewPatient() {
		frame1.locator(confirmpatLocator).click();
	}

	

}

