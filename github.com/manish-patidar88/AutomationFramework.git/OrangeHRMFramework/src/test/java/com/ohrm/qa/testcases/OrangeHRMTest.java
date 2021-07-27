package com.ohrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ohrm.qa.pages.LoginPage;

//@Listeners(com.ohrm.qa.listeners.ListenerClass.class)
public final class OrangeHRMTest extends BaseTest {

	private OrangeHRMTest() {
	}

	@DataProvider(name = "getdata", parallel = true)
	private Object[][] getdata() {
		return new Object[][] { { "admin", "admin123" }, { "admin123", "admin123" } };
	}

	@Test(dataProvider = "getdata")
	public void loginLogoutTest1() throws Exception {
		String title = new LoginPage().enterUserName("admin").enterPassword("admin123").clickLogin().clickWelcome()
				.clickLogout().getPageTitle(); // method chaning
		Assert.assertEquals(title, "OrangeHRM");

	}

	@Test(dataProvider = "getdata")
	public void loginLogoutTest2() throws Exception {
		String title = new LoginPage().enterUserName("admin").enterPassword("admin123").clickLogin().clickWelcome()
				.clickLogout().getPageTitle(); // method chaning
		Assert.assertEquals(title, "OrangeHRM");
	}
}
