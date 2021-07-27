package com.ohrm.qa.driver;

import java.net.MalformedURLException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import com.ohrm.qa.constants.FrameworkConstants;
import com.ohrm.qa.enums.ConfigProperties;
import com.ohrm.qa.exceptions.BrowserInvocationFailedException;
import com.ohrm.qa.factories.DriverFactory;
import com.ohrm.qa.util.PropertiesUtils;

/**
 * Driver class is responsible for invoking and closing browsers.
 * 
 * <p>
 * It is also responsible for setting the driver variable to DriverManager which
 * handles the thread safety for the WebDriver instance
 * <p>
 * Jun 22, 2021
 * 
 * @author Manish Patidar
 * @version 1.0
 * @since 1.0
 * @see DriverManager
 * @see com.ohrm.qa.testcases.BaseTest
 */
public final class Driver {
	/**
	 * Private constructor to avoid external instantiation
	 */
	private Driver() {
	}

	/**
	 * @author Manish Patidar
	 *         <p>
	 *         Jun 22, 2021
	 * @param browser value will be passed from BaseTest. Value can be Chrome,
	 *                firefox and edge
	 */
	public static void initDriver(String browser) {
		if (Objects.isNull(DriverManager.getDriver())) {
			try {
				DriverManager.setDriver(DriverFactory.getDriver(browser));
			} catch (MalformedURLException e) {
				throw new BrowserInvocationFailedException("Please check the capability of browser", e);
			}

			DriverManager.getDriver().manage().deleteAllCookies();
			DriverManager.getDriver().manage().timeouts().pageLoadTimeout(FrameworkConstants.getPageLoadTimeout(),
					TimeUnit.SECONDS);
			DriverManager.getDriver().manage().timeouts().implicitlyWait(FrameworkConstants.getImplicitWait(),
					TimeUnit.SECONDS);
			DriverManager.getDriver().get(PropertiesUtils.get(ConfigProperties.URL));
		}
	}

	/**
	 * 
	 * @author Manish Patidar
	 *         <p>
	 *         Purpose of this method is to quit the driver instance. Jul 1, 2021
	 */
	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
