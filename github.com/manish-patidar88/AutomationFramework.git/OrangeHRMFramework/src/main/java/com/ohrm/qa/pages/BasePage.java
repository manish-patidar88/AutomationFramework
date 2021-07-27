package com.ohrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ohrm.qa.driver.DriverManager;
import com.ohrm.qa.enums.WaitStrategy;
import com.ohrm.qa.factories.ExplicitWaitFactory;
import com.ohrm.qa.reports.ExtentLogger;

public class BasePage {

	protected void click(By by, WaitStrategy waitstrategy, String elementname) {
		WebElement element = ExplicitWaitFactory.performExplictWait(waitstrategy, by);
		element.click();
		ExtentLogger.pass(elementname + " is clicked", true);

	}

	protected void sendKeys(By by, String value, WaitStrategy waitstrategy, String elementname) {
		WebElement element = ExplicitWaitFactory.performExplictWait(waitstrategy, by);
		element.sendKeys(value);
		ExtentLogger.pass(value + " is entered successfully in " + elementname, true);
	}

	protected String getTitle() {
		return DriverManager.getDriver().getTitle();
	}
}
