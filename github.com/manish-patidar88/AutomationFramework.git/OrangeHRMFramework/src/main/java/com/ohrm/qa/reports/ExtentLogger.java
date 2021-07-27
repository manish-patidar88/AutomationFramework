package com.ohrm.qa.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.ohrm.qa.enums.ConfigProperties;
import com.ohrm.qa.util.PropertiesUtils;
import com.ohrm.qa.util.ScreenshotUtils;

public final class ExtentLogger {

	private ExtentLogger() {
	}

	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}

	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}

	public static void pass(String message, boolean isScreenshotNeeded) {
		if (PropertiesUtils.get(ConfigProperties.PASSEDSTEPSSCREENSHOT).equalsIgnoreCase("yes") && isScreenshotNeeded) {
			ExtentManager.getExtentTest().pass(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		} else {
			ExtentManager.getExtentTest().pass(message);
		}
	}

	public static void fail(String message, boolean isScreenshotNeeded) {
		if (PropertiesUtils.get(ConfigProperties.FAILEDSTEPSSCREENSHOT).equalsIgnoreCase("yes") && isScreenshotNeeded) {
			ExtentManager.getExtentTest().fail(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		} else {
			ExtentManager.getExtentTest().fail(message);
		}
	}

	public static void skip(String message, boolean isScreenshotNeeded) {
		if (PropertiesUtils.get(ConfigProperties.SKIPSTEPSSCREENSHOT).equalsIgnoreCase("yes") && isScreenshotNeeded) {
			ExtentManager.getExtentTest().skip(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		} else {
			ExtentManager.getExtentTest().skip(message);
		}
	}

}
