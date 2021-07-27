package com.ohrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ohrm.qa.enums.ConfigProperties;
import com.ohrm.qa.pages.HomePage;
import com.ohrm.qa.pages.LoginPage;
import com.ohrm.qa.util.JsonUtil;
import com.ohrm.qa.util.PropertiesUtils;

public final class LoginPageTest{
	
	LoginPage loginPage;
	HomePage homePage;
	
	private LoginPageTest() {
		
	}
	
	@Test
	public void Test1() throws Exception {		
		/*String title = new LoginPage().enterUserName(ProperyUtil.get(ConfigProperties.USERNAME)).enterPassword(ProperyUtil.get(ConfigProperties.PASSWORD)).clickLogin()
				.clickWelcome().clickLogout().getPageTitle();	//method chaning
		Assert.assertEquals(title, "OrangeHRM");*/
		
		String title = new LoginPage().enterUserName(JsonUtil.get(ConfigProperties.USERNAME)).enterPassword(JsonUtil.get(ConfigProperties.PASSWORD)).clickLogin()
				.clickWelcome().clickLogout().getPageTitle();	//method chaning
		Assert.assertEquals(title, "OrangeHRM");
	}
	
}
