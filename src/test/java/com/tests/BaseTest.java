package com.tests;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.sample.config.Configuration;
import com.sample.config.Driver;

public class BaseTest {
	private WebDriver driver;

	@BeforeMethod
	public void setup() throws Exception {
		Configuration.load();
		Configuration.print();
		String baseUrl = Configuration.get("url");
		System.setProperty("webdriver.chrome.driver", new File("drivers/chromedriver.exe").getAbsolutePath());
		DesiredCapabilities cap = new DesiredCapabilities();
		Driver.add(Configuration.get("browser"));
		driver = Driver.current();
		driver.get(baseUrl);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
