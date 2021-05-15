package com.sample.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.sample.pages.Page;

public class SelectList extends Control {

	public SelectList(Page parentvalue, By locator) {
		super(parentvalue, locator);
	}
	
	public Select getSelect() {
		return new Select(this.getElement());
	}

	public void selectByText(String value) {
		this.exists();
		try {
		this.getSelect().selectByVisibleText(value);
		}catch(Exception e) {
			throw new RuntimeException("Text is not present");
		}
	}
	
}
