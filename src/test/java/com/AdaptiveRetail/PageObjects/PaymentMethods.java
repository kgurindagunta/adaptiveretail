package com.AdaptiveRetail.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PaymentMethods {
	
WebDriver driver;
	
	public PaymentMethods(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//ul[@class='nav nav-tabs checkout-tabs inline']/li[3]")
	WebElement payment;
	
	@FindBy(xpath = "//div[@id='PAYMENT']/div/div/div/div/div[2]/a[1]")
	WebElement paymentBtn;
	
	@FindBy(id = "cardOwner")
	WebElement cardOwner;
	
	@FindBy(id="cardNumber")
	WebElement cardNum;
	
	@FindBy(id="month")
	WebElement month;
	
	@FindBy(id="year")
	WebElement year;
	
	@FindBy(xpath="//div[@class='col-6 btn-link-form mt-5']/button")
	WebElement submitBtn;
	
	@FindBy(xpath="//div[@class='col-6 mt-5']/a")
	WebElement cancelBtn;

	public void clickPaymentMethod() {
		payment.click();
	}
	
	public void clickAddNewPayment() {
		paymentBtn.click();
	}
	
	public void enterCardOwner(String cardName)
	{
		cardOwner.sendKeys(cardName);
	}
	
	public void enterCardNum(String cardNumber)
	{
		cardNum.sendKeys(cardNumber);
		
	}
	
	public void selectMonth() {
		Select selectMonth=new Select(month);
		selectMonth.selectByIndex(8);	
	}
	
	public void selectYear() {
		Select selectYear=new Select(year);
		selectYear.selectByVisibleText("2028");	
	}
	
	public void clickSubmit()
	{
		submitBtn.click();
	}
	
	public void clickCancel() {
		cancelBtn.click();
	}
}