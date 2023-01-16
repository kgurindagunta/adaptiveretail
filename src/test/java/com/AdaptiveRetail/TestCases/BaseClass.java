package com.AdaptiveRetail.TestCases;

import java.io.File;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.AdaptiveRetail.PageObjects.LoginPage;
import com.AdaptiveRetail.Utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public String firstName = readconfig.getFirstname();
	public String lastNane = readconfig.getLastname();
	public String Email = readconfig.getEmail();
	public String Phonenum = readconfig.getPhonenum();
	public String cardName = readconfig.getCardName();
	public String cardNum = readconfig.getCardNum();
	public static WebDriver driver;

	// public static Logger logger;
	public static Logger log = Logger.getLogger(BaseClass.class);
	@BeforeClass
	@Parameters("browser")
	public void setup(String br) throws IOException {

		PropertyConfigurator.configure("log4j.properties");

		if (br.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (br.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (br.equalsIgnoreCase("IE")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	
	@AfterClass
	public void tearDown() throws IOException, InterruptedException {
		
		LoginPage login = new LoginPage(driver);
		
		Thread.sleep(3000);
		login.clickLogoutBtn();

		driver.quit();

	}

	public void loginTest() throws InterruptedException, IOException {
		driver.get(baseURL);
		log.info("URL is opened");

		LoginPage login = new LoginPage(driver);
		login.clickAlert();
		String verify = login.verifyPage();

		if (verify.contains("Log in to your account")) {
			login.setEmail(username);
			login.setPassword(password);
			login.clickLogin();
		} else {
			System.out.println("Page is not valid");
		}

	}

	public String captureScreen(String tname) throws IOException {

		SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date dt = new Date();
		String timeStamp = sd.format(dt);
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}

}
