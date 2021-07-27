package com.ohrm.qa.factories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ohrm.qa.driver.DriverManager;
import com.ohrm.qa.enums.WaitStrategy;

public final class ExplicitWaitFactory {
	private ExplicitWaitFactory() {
	}

	public static WebElement performExplictWait(WaitStrategy waitstrategy, By by) {
		WebElement element = null;
		if (waitstrategy == WaitStrategy.CLICKABLE) {
			element = new WebDriverWait(DriverManager.getDriver(), 10)
					.until(ExpectedConditions.elementToBeClickable(by));

		} else if (waitstrategy == WaitStrategy.PRESENCE) {

			element = new WebDriverWait(DriverManager.getDriver(), 10)
					.until(ExpectedConditions.presenceOfElementLocated(by));

		} else if (waitstrategy == WaitStrategy.VISIBLE) {
			element = new WebDriverWait(DriverManager.getDriver(), 10)
					.until(ExpectedConditions.visibilityOfElementLocated(by));
		} else if (waitstrategy == WaitStrategy.NONE) {
			element = DriverManager.getDriver().findElement(by);
		}
		return element;
	}

}
