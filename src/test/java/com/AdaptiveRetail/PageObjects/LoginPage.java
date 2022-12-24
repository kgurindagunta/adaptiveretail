package com.AdaptiveRetail.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='button-wrapper']/button[1]")
	WebElement alertBtn;

	@FindBy(xpath = "//div[@class=' text-center my-3']/h2")
	WebElement verifyPage;

	@FindBy(xpath = "//input[@id='login-form-email']")
	WebElement email;

	@FindBy(xpath = "//input[@id='login-form-password']")
	WebElement password;

	@FindBy(xpath = "//button[text()='Log in']")
	WebElement loginBtn;

	@FindBy(xpath = "//a[@id='myaccount']/span")
	WebElement logoutBtn;

	@FindBy(xpath = "//*[@id=\"ext-gen44\"]/body/div[1]/header/nav/div/div/div[1]/div[2]/div/div[2]/div/ul/li[4]/a")
	WebElement logoutBtn1;

	public void clickAlert() {
		alertBtn.click();
	}

	public String verifyPage() {
		return verifyPage.getText();
	}

	public void setEmail(String uname) {
		email.sendKeys(uname);
	}

	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void clickLogin() {
		loginBtn.click();
	}

	public void clickLogoutBtn() {
		logoutBtn.click();
		logoutBtn1.click();
	}

}
