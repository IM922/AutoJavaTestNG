package com.sample.pages;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.sample.config.Driver;


public class PageFactory {

	public PageFactory() {
	}

	private static By toLocator(String input) {
		if (input.matches("^(xpath=|/)(.*)")) {
			return By.xpath(input.replaceAll("^xpath=", ""));
		} else if (input.matches("^id=(.*)")) {
			return By.xpath(input.substring("id=".length()));
		} else if (input.matches("^name=(.*)")) {
			return By.xpath(input.substring("name=".length()));
		} else if (input.matches("^css=(.*)")) {
			return By.xpath(input.substring("css=".length()));
		} else if (input.matches("^class=(.*)")) {
			return By.xpath(input.substring("class=".length()));
		} else {
			return By.id(input);
		}

	}

	@SuppressWarnings("unchecked")
	private static <T> T getAnnotationField(Annotation annontation, String name, Class<T> type) throws Exception {
		T result;
		result = (T) annontation.getClass().getMethod(name).invoke(annontation);
		return result;
	}

	public static <T extends Page> T init( Class<T> pageClass) throws Exception {
		T page = pageClass.getConstructor(WebDriver.class).newInstance(Driver.current());
		for (Field field : pageClass.getFields()) {
			Annotation anno = (Annotation) field.getAnnotation(FindBy.class);
			if (anno != null) {
				Object control = field.getType().getConstructor(Page.class,By.class)
						.newInstance(page,toLocator(getAnnotationField(anno, "locator", String.class)));
				field.set(page, control);
			}
		}
		return page;
	}
}
