package com.sample.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sample.config.Configuration;
import com.sample.pages.Page;

public class Control{
	protected static final long TIMEOUT = Configuration.timeout();
	private Page parent;
	By locator;
	JavascriptExecutor js;

	private final String TYPE = "arguments[0].value = '%s'";
	private final String CLEAR = "arguments[0].value = ''";
	private final String CLICK = "arguments[0].click()";
	private final String HIGHLIGHT = "arguments[0].style.backgroundColor='green'";
	private final String IS_DISPLAYED = "return arguments[0].style.display";
	private final String IS_ENABLED = "return arguments[0].disabled";
	private final String GET_TEXT = "return arguments[0].innerHTML.trim()";
		
	public Control(Page page, By locator) {
		super();
		this.parent = page;
		this.locator = locator;
		js= (JavascriptExecutor)getDriver();
	}

	public WebDriver getDriver() {
		return parent.getDriver();
	}

	public WebElement getElement() {
		return getDriver().findElement(locator);
	}

	public boolean exist(long timeout) {
		WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
		try {
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean exists() {
		return exist(TIMEOUT);
	}

	public void click() {
		exists();
		this.getElement().click();
	}

	public void sendkeys(CharSequence keysToSend) {
		exists();
		this.getElement().sendKeys(keysToSend);
	}

	public String getText() {
		return getElement().getText();
	}
	
	public void jsClick() {
		exists();
		js.executeScript(CLICK, getElement());
	}
	
	public boolean isDisplayed() {
		return  (Boolean) js.executeScript(IS_DISPLAYED, getElement());
	}

	
	public boolean isEnabled() {
		return (Boolean) js.executeScript(IS_ENABLED, getElement());
	}

	
	public <X> X getScreenshotAs(OutputType<X> arg0) throws WebDriverException {
		throw new RuntimeException("not implemented");
	}

	
	public void clear() {
		js.executeScript(CLEAR, getElement());
	}

		
	public boolean isSelected() {
		return getElement().isSelected();
	}

	public void sendKeys(CharSequence... arg0) {
		String jsQuery = String.format(TYPE, arg0);
		js.executeScript(jsQuery, getElement());
	}

	public void submit() {
		throw new RuntimeException("not implemented");
	}

	
}
