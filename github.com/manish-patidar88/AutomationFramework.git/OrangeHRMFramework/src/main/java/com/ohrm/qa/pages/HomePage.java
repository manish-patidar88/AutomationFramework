package com.ohrm.qa.pages;

import org.openqa.selenium.By;

import com.ohrm.qa.enums.WaitStrategy;

public class HomePage extends BasePage{
	
	private final By eleWelcome = By.id("welcome");
	private final By lnkLogout = By.xpath("//a[text()='Logout']");
	
	public HomePage clickWelcome() {
		click(eleWelcome,WaitStrategy.CLICKABLE,"Welcome lnik");		
		return this;
	}
	
	public LoginPage clickLogout() {
		click(lnkLogout,WaitStrategy.CLICKABLE,"Logout link");		
		return new LoginPage();
	}
	
	//wait.until(d->d.findElement(lnkLogout).isEnabled());   Java 8
}

