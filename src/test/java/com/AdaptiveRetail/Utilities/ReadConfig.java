package com.AdaptiveRetail.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	public ReadConfig() {
		File src= new File("./Configuration/config.properties");
		
		try
		{
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
				
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public String getApplicationURL() {
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getUsername() {
		String email=pro.getProperty("email");
		return email;
	}
	
	public String getPassword() {
		String password=pro.getProperty("password");
		return password;
	}
	
	public String getFirstname() {
		String firstname=pro.getProperty("firstname");
		return firstname;
	}
	
	public String getLastname() {
		String firstname=pro.getProperty("lastname");
		return firstname;
	}
	

	public String getEmail() {
		String email=pro.getProperty("email");
		return email;
	}
	

	public String getPhonenum() {
		String Phonenum=pro.getProperty("phonenum");
		return Phonenum;
	}
	
	public String getCardName() {
		String cardName=pro.getProperty("cardOwner");
		return cardName;
	}
	
	public String getCardNum() {
		String cardNum=pro.getProperty("cardNum");
		return cardNum;
	}
	

	

}
