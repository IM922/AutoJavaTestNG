package com.sample.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sample.pages.Page;

public class Edit extends Control {

	public Edit(Page parent, By locator) {
		super(parent, locator);
	}
	
	public void setText(String value) {
		this.getElement().click();
		this.getElement().clear();
		this.getElement().sendKeys(value);
	}

}
