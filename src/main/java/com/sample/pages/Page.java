package com.sample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sample.controls.Control;

public class Page {
	
	private WebDriver driver;

	public Page(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	public Page navigate() {
		return this;
	}

	public boolean isTextPresent(String text) {
		String locator=String.format("//*[text()='%s'or contains(text(),%s)]", text,text);
		Control elemnt= new Control(this, By.xpath(locator));
		return elemnt.exists();
	}
	
}
