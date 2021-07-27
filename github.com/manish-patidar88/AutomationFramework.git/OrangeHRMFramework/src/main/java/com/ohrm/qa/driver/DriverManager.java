package com.ohrm.qa.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
	private DriverManager() {
	}

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return driver.get();
	}

	/**
	 * set the webdriver instance to thread local variable
	 * 
	 * @author Manish Patidar Jul 15, 2021
	 * @param driverRef {@link org.openqa.selenium.WebDriver} instance that need to
	 *                  be saved for thread safety issues.
	 */
	static void setDriver(WebDriver driverRef) {
		if (Objects.nonNull(driverRef))
			driver.set(driverRef);
	}

	/**
	 * Calling remove method on threadlocal variable ensures to set the default
	 * value to Threadlocal variable. It is much safer that assigning null value to
	 * threadlocal variable.
	 * 
	 * @author Manish Patidar Jul 15, 2021
	 */
	static void unload() {
		driver.remove();
		// driver.set(null);
	}

}
