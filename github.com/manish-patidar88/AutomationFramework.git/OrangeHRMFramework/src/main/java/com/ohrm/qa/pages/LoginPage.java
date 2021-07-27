package com.ohrm.qa.pages;

import org.openqa.selenium.By;

import com.ohrm.qa.enums.WaitStrategy;
import com.ohrm.qa.util.DecodeUtils;

public class LoginPage extends BasePage {
	// Assertion should not be called in page layers
	// All your page methods need to have return type
	// OR
	private final By txtUsername = By.id("txtUsername");
	private final By txtPassword = By.id("txtPassword");
	private final By btnSubmit = By.xpath("//input[@name='Submit']");

	public LoginPage enterUserName(String name) {
		sendKeys(txtUsername, name, WaitStrategy.PRESENCE, "UserName");
		return this;
	}

	public LoginPage enterPassword(String pwd) {
		System.out.println(DecodeUtils.getDecodedString(pwd));
		sendKeys(txtPassword, DecodeUtils.getDecodedString(pwd), WaitStrategy.PRESENCE, "Password");
		return this;
	}

	public HomePage clickLogin() {
		click(btnSubmit, WaitStrategy.CLICKABLE, "Login button");

		return new HomePage();
	}

	public String getPageTitle() {
		return getTitle();
	}
}

/*
 * private String menuitem = "//div[text()='%value%']/parent::a"; public void
 * clickMenu(String value) {
 * driver.findElement(By.xpath(menuitem.replace("%value%",value))); }
 */
