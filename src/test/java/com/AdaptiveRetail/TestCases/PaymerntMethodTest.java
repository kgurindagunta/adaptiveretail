package com.AdaptiveRetail.TestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.AdaptiveRetail.PageObjects.PaymentMethods;

public class PaymerntMethodTest extends BaseClass {

	@Test
	public void paymentTest() throws InterruptedException, IOException {

		PaymentMethods payment = new PaymentMethods(driver);

		loginTest();
		Thread.sleep(3000);
		//Assert.assertTrue(false);
		payment.clickPaymentMethod();
		log.info("Naviagated to payments method");
		payment.clickAddNewPayment();
		log.info("Clicked on Add new button");
		payment.enterCardOwner(cardName);
		log.info("Entered card name");
		payment.enterCardNum(cardNum);
		log.info("entered card number");
		payment.selectMonth();
		log.info("Month is been selected");
		payment.selectYear();
		log.info("Year is been selected");
		payment.clickSubmit();
		log.info("clicked on submit buttton");
		payment.clickCancel();
		log.info("clicked on cancel button");
		
		captureScreen("payment");

	}

}
