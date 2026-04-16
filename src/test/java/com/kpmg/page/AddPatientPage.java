package com.kpmg.page;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

public class AddPatientPage {
	
private Page page;
private FrameLocator frame;
private FrameLocator frame1;
	
	public AddPatientPage(Page page, FrameLocator frame, FrameLocator frame1) {
		this.page = page;
		this.frame=page.frameLocator("xpath=//iframe[@name='pat']");
		this.frame1 =page.frameLocator("xpath=//iframe[@id='modalframe']");
	}
	
	public void enterFirstName(String firstName) {
		frame.locator("xpath=//input[@placeholder='First Name']").fill(firstName);
	}
	
	public void enterLastName(String lastName) {
		frame.locator("xpath=//input[@placeholder='Last Name']").fill(lastName);
	}
	
	public void enterDOB(String dob) {
		frame.locator("xpath=//input[@id='form_DOB']").fill(dob);	
	}
	
	public void selectGender(String gender) {
		frame.locator("xpath=//select[@title='Birth Sex']").selectOption(new
				 SelectOption().setLabel(gender));
	}
	
	public void clickCreatePatient() {
		frame.locator("xpath=//button[@name='create']").click();
	}
	
	public void clickOnConfirmCreateNewPatient() {
		frame1.locator("xpath=//button[contains(text(),'Confirm Create ')]").click();
	}

	

}

