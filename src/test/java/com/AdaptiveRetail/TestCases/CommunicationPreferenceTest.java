package com.AdaptiveRetail.TestCases;

import java.io.IOException;


import org.testng.annotations.Test;

import com.AdaptiveRetail.PageObjects.CommunicationPreference;

public class CommunicationPreferenceTest extends BaseClass {
	
	@Test
	public void checkboxTest() throws InterruptedException, IOException {
		
		loginTest();
		CommunicationPreference communication=new CommunicationPreference(driver);
		
		communication.clickCommunicationPreference();
		log.info("Navigated to Communication Preference");
		
		Thread.sleep(3000);
		communication.clickCheckbox();
		log.info("Clicked the checkbox");
		communication.clickApplyChangesBtn();
		log.info("clicked the Apply changes btn");
		Thread.sleep(3000);
		communication.clickCheckbox();
		log.info("Clicked the checkbox");
		Thread.sleep(3000);
		communication.clickApplyChangesBtn();
		log.info("clicked the Apply changes btn");
          Thread.sleep(3000);
          
          captureScreen("buttons");
		
	}

}
