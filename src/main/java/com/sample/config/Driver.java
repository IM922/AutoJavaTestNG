package com.sample.config;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	private Driver() {
	}


   private static ConcurrentHashMap<String, WebDriver>driverThreadMap= new ConcurrentHashMap<String, WebDriver>();
	public static final Map<String, Class<?>> driverMap = new HashMap<String, Class<?>>() {
		{
			put("chrome", ChromeDriver.class);
			put("firefox", ChromeDriver.class);
			put("ie", ChromeDriver.class);
			put("opera", ChromeDriver.class);
		}

	};

	private static String getThreadName() {
		return Thread.currentThread().getName()+"-"+Thread.currentThread().getId();
	}
	
	public static void add(String browser) throws Exception {
		Class<?> driverClass = driverMap.get(browser);
		WebDriver driver = (WebDriver) driverClass.getConstructor().newInstance();
		String threadName=getThreadName();
		driverThreadMap.put(threadName, driver);
		
	}

	public static WebDriver current() {
		String threadName=getThreadName();
		return driverThreadMap.get(threadName);
	}

}