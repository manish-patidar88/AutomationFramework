/**
 * 
 */
package com.ohrm.qa.factories;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.ohrm.qa.enums.ConfigProperties;
import com.ohrm.qa.util.PropertiesUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Jun 23, 2021
 * 
 * @author Manish Patidar
 * @version 1.0
 * @since 1.0
 */
public final class DriverFactory {

	private static final String REMOTE = "remote";

	private DriverFactory() {
	}

	public static WebDriver getDriver(String browser) throws MalformedURLException {
		WebDriver driver = null;

		String runmode = PropertiesUtils.get(ConfigProperties.RUNMODE);

		if (browser.equalsIgnoreCase("chrome")) {
			if (runmode.equalsIgnoreCase(REMOTE)) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.CHROME);
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
				cap.setCapability(ChromeOptions.CAPABILITY, options);
				driver = new RemoteWebDriver(new URL(PropertiesUtils.get(ConfigProperties.SELENIUMGRIDURL)), cap);
			} else {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}

		} else if (browser.equals("firefox")) {
			if (runmode.equalsIgnoreCase(REMOTE)) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.FIREFOX);
				driver = new RemoteWebDriver(new URL(PropertiesUtils.get(ConfigProperties.SELENIUMGRIDURL)), cap);
			} else {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		} else if (browser.equals("edge")) {
			if (runmode.equalsIgnoreCase(REMOTE)) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.CHROME);
				driver = new RemoteWebDriver(new URL(PropertiesUtils.get(ConfigProperties.SELENIUMGRIDURL)), cap);
			} else {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}

		}

		return driver;

	}

}
