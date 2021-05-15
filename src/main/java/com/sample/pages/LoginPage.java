package com.sample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sample.config.Configuration;
import com.sample.config.Driver;
import com.sample.controls.Control;
import com.sample.controls.SelectList;


public class LoginPage extends Page{

	@FindBy(locator="username")
	public Control username;
	
	@FindBy(locator="password")
	public Control password;
	
	@FindBy(locator="//button")
	public Control button;
	
	@FindBy(locator="//*[@id='dropdown']")
	public SelectList dropdown;
	
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	

	public void selectDropdown() {
		Driver.current().get("https://the-internet.herokuapp.com/dropdown");
		Configuration.timeout();
		dropdown.selectByText("Option 1");
	}
	
}
