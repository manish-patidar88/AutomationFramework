package com.ohrm.qa.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.ohrm.qa.enums.ConfigProperties;
import com.ohrm.qa.util.PropertiesUtils;

public class RetryFailedTests implements IRetryAnalyzer {

	private int count = 0;
	private int retries = 1;

	@Override
	public boolean retry(ITestResult result) {
		boolean value = false;
		try {
			if (PropertiesUtils.get(ConfigProperties.RETRYFAILEDTEST).equalsIgnoreCase("yes")) {
				value = count < retries;
				count++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

}
