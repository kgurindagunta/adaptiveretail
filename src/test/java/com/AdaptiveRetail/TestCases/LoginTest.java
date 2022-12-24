package com.AdaptiveRetail.TestCases;

import java.io.IOException;


import org.testng.annotations.Test;


public class LoginTest extends BaseClass {
	
	@Test
	public void login() throws InterruptedException, IOException {
		loginTest();
		captureScreen("login");
	
		
	}

	
	
	
	

}
