package com.AdaptiveRetail.TestCases;

import java.io.IOException;


import org.testng.annotations.Test;
import com.AdaptiveRetail.PageObjects.VerifyPersonalInfo;

public class PersonalinfoTest extends BaseClass {

	@Test
	public void verifyPersonalInfo() throws InterruptedException, IOException {
		VerifyPersonalInfo verify = new VerifyPersonalInfo(driver);
		loginTest();

		String fname = verify.verifyFname();

		if (fname.contains(firstName) && fname != " ") {
			log.info("FirstName is Verified");
		} else {
			log.info("FirstName is not Verified");
		}

		String lname = verify.verifyLname();

		if (lname.equals(lastNane) && lname != " ") {
			log.info("LastName is Verified");
		} else {
			log.info("LastName is Not Verified");
		}

		String email = verify.verifyEmail();

		if (email.contains(Email) && email != " ") {
			log.info("Email is verified");
		} else {
			log.info("Email is not Verified");
		}

		String phonenumber = verify.verifyPhonenum();

		if (phonenumber.contains(Phonenum) && phonenumber != " ") {
			log.info("PhoneNumber is verified");
		} else {
			log.info("PhoneNumber is not Verified");
		}
		
		captureScreen("details");


	}

}
