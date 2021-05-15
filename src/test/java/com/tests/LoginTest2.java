package com.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.sample.config.DataProviderClass;
import com.sample.pages.LoginPage;
import com.sample.pages.PageFactory;

public class LoginTest2 extends BaseTest{
	private WebDriver driver;
			
	@Test(dataProvider="source",dataProviderClass=DataProviderClass.class)
	public void LoginTest(String username,String password) throws Exception {
		LoginPage loginpage=PageFactory.init(LoginPage.class);
		loginpage.username.clear();
		loginpage.username.sendkeys(username);
		loginpage.password.sendkeys(password);
		loginpage.button.jsClick();
		loginpage.selectDropdown();
		
	}
	
	
}
