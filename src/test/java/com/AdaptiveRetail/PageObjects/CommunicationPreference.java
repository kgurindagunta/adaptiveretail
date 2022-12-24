package com.AdaptiveRetail.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommunicationPreference {

	WebDriver driver;

	public CommunicationPreference(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//ul[@class='nav nav-tabs checkout-tabs inline']/li[2]")
	WebElement communication;
	
	@FindBy(xpath ="//*[@id=\"COMUNICATION\"]/div/form/div[3]/label")
	WebElement checkbox;
	
	@FindBy(id = "save-custom-preferences")
	WebElement ApplyChangesBtn;
	
	public void clickCommunicationPreference() {
		communication.click();
	}
	
	public void clickCheckbox() {
		checkbox.click();
	}
	
	public void clickApplyChangesBtn() {
		ApplyChangesBtn.click();
	}

}
