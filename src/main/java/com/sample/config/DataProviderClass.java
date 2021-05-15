package com.sample.config;
import org.testng.annotations.DataProvider;
public class DataProviderClass {
	
	@DataProvider(name="source")
	public static Object[][] getParameter() {
		return new Object[][] {
			{"IronMan","SuperSecretPassword!"},
			{"tomsmith","SuperSecretPassword!"},
		};
		
	}

}
