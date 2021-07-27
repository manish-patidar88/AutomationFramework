package com.ohrm.qa.reports;

import java.util.Objects;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

	private ExtentManager() {
	}

	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	static ExtentTest getExtentTest() {
		return extentTest.get();
	}

	static void setExtentTest(ExtentTest test) {
		if (Objects.nonNull(test))
			extentTest.set(test);
	}

	static void unload() {
		extentTest.remove();
	}
}
