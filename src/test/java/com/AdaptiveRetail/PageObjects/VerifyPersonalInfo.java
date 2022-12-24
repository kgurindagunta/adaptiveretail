package com.AdaptiveRetail.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyPersonalInfo {
	
WebDriver driver;
	
	public VerifyPersonalInfo(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//div[@class='card-body body-card']/dl/dt[text()='Kiran']")
	WebElement fname;
	
	@FindBy(xpath = "//div[@class='card-body body-card']/dl/dt[text()='Gurindagunta']")
	WebElement lname;
	
	@FindBy(xpath ="//div[@class='card-body body-card']/dl/dt[text()='gurindaguntakiran@gmail.com']")
	WebElement email;
	
	@FindBy(xpath ="//div[@class='card-body body-card']/dl/dt[text()='3333333333']")
	WebElement phonenum;
	
	public String verifyFname() {
		return fname.getText();
	}
	
	public String verifyLname() {
		return lname.getText();
	}
	
	public String verifyEmail() {
		return email.getText();
	}
	
	public String verifyPhonenum() {
		return phonenum.getText();
	}
	
	

}
