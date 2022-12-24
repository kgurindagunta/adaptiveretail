/**

 * 
 */
package Checktest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author kgurindagunta
 *
 */
public class Fullcheck {

	public WebDriver driver;

	public String firstname = "Kiran";
	public String lastname = "Gurindagunta";
	public String email = "gurindaguntakiran@gmail.com";
	public String phonenum = "3333333333";

	@BeforeTest
	public void setup() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(
				"https://zybl-005.dx.commercecloud.salesforce.com/on/demandware.store/Sites-AR-Site/default/Login-Show");

	}

	@Test
	public void Login() throws InterruptedException {

		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Sites-AR-Site | Salesforce Commerce Cloud | 6.0.0");
		driver.findElement(By.xpath("//div[@class='button-wrapper']/button[1]")).click();
		String header = driver.findElement(By.xpath("//div[@class=' text-center my-3']/h2")).getText();
		System.out.println(header);
		if (header.contains("Log in to your account")) {
			driver.findElement(By.xpath("//input[@id='login-form-email']")).sendKeys("gurindaguntakiran@gmail.com");
			driver.findElement(By.xpath("//input[@id='login-form-password']")).sendKeys("Vijetha@12");
			driver.findElement(By.xpath("//button[text()='Log in']")).click();

			Thread.sleep(3000);
			String fname = driver.findElement(By.xpath("//div[@class='card-body body-card']/dl/dt[text()='Kiran']"))
					.getText();
			if (fname.equals(firstname) && fname != " ") {
				System.out.println("Firstname is entered correct");
			} else {
				System.out.println("Firstname is entered wrong");
			}

			String lname = driver.findElement(By.xpath("//*[@id=\"PERSONAL\"]/div/div[2]/div[2]/div[1]/div[2]"))
					.getText();
			if (lname.equals(lastname) && lname != " ") {
				System.out.println("Lastname is entered correct");
			} else {
				System.out.println("Lastname is entered wrong");
			}

			String Expectedemail = driver
					.findElement(By.xpath("//*[@id=\"PERSONAL\"]/div/div[2]/div[1]/div[2]/div[2]/dl/dt")).getText();
			if (Expectedemail.equals(email) && Expectedemail != " ") {
				System.out.println("Email entered is correct");
			} else {
				System.out.println("email entered is wrong");
			}

			String Expectedphonenum = driver
					.findElement(By.xpath("//*[@id=\"PERSONAL\"]/div/div[2]/div[2]/div[2]/div[2]")).getText();
			if (Expectedphonenum.equals(phonenum) && Expectedphonenum != " ") {
				System.out.println("Phone number entered is correct");
			} else {
				System.out.println("Phone number entered is incorrect");
			}
			WebElement communciation = driver
					.findElement(By.xpath("//ul[@class='nav nav-tabs checkout-tabs inline']/li[2]"));
			communciation.click();
			System.out.println("Navigated to communication preference");

			WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"COMUNICATION\"]/div/form/div[3]/label"));

			Thread.sleep(5000);

			checkbox.click();

			WebElement checkbobtn = driver.findElement(By.id("save-custom-preferences"));

			System.out.println(checkbobtn.getText());

			checkbobtn.click();
			if (checkbox.isSelected()) {
				System.out.println("checkbox is Toggled on");
			} else {
				System.out.println("checkbox is Toggled off");
			}

			Thread.sleep(5000);

			checkbox.click();

			Thread.sleep(5000);

			checkbobtn.click();

			Thread.sleep(5000);

			if (!checkbox.isSelected()) {
				System.out.println("checkbox is Toggled on");
			} else {
				System.out.println("checkbox is Toggled off");
			}
			
			driver.findElement(By.xpath("//ul[@class='nav nav-tabs checkout-tabs inline']/li[3]")).click();
			driver.findElement(By.xpath("//div[@id='PAYMENT']/div/div/div/div/div[2]/a[1]")).click();
			
			driver.findElement(By.id("cardOwner")).sendKeys("Kiran");
			driver.findElement(By.id("cardNumber")).sendKeys("123456789012345");
			WebElement month=driver.findElement(By.id("month"));
			Select selectMonth=new Select(month);
			selectMonth.selectByIndex(8);
			WebElement year=driver.findElement(By.id("year"));
			Select selectYear=new Select(year);
			selectYear.selectByVisibleText("2028");
			driver.findElement(By.xpath("//div[@class='col-6 btn-link-form mt-5']/button")).click();
			driver.findElement(By.xpath("//div[@class='col-6 mt-5']/a")).click();
			Thread.sleep(5000);
			

		} else {
			Assert.assertTrue(false);
		}
		driver.quit();

	}

}
