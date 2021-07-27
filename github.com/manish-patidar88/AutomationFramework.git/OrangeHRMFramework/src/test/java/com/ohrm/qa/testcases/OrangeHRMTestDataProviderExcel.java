package com.ohrm.qa.testcases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ohrm.qa.pages.LoginPage;

//@Listeners(com.ohrm.qa.listeners.ListenerClass.class)
public final class OrangeHRMTestDataProviderExcel extends BaseTest {

	private OrangeHRMTestDataProviderExcel() {
	}

	@Test // (dataProvider = "getdata", dataProviderClass = DataProviderUtils.class,
			// retryAnalyzer = RetryFailedTests.class)
	public void loginLogoutTest1(Map<String, String> data) throws Exception {
		String title = new LoginPage().enterUserName(data.get("username")).enterPassword(data.get("password"))
				.clickLogin().clickWelcome().clickLogout().getPageTitle(); // method chaning
		Assert.assertEquals(title, "OrangeHRM");

	}

	@Test // (dataProvider = "getdata", dataProviderClass = DataProviderUtils.class,
			// retryAnalyzer = RetryFailedTests.class)
	public void loginLogoutTest2(Map<String, String> data) throws Exception {
		String title = new LoginPage().enterUserName(data.get("username")).enterPassword(data.get("password"))
				.clickLogin().clickWelcome().clickLogout().getPageTitle(); // method chaning
		Assert.assertEquals(title, "OrangeHRM");
	}
}
