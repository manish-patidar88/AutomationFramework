package com.ohrm.qa.testcases;

import com.ohrm.qa.pages.HomePage;

public final class HomePageTest {

	HomePage homePage;
	
	private HomePageTest() {
	}
	
	//@Test
	public void Test2() {
		homePage = new HomePage();
		//DriverManager.getDriver().findElement(By.xpath("//input[@name='q']")).sendKeys("Selenium test automation",Keys.ENTER);		
		//System.out.println(DriverManager.getDriver().getTitle() + "|"+ DriverManager.getDriver().getWindowHandle());		
	}
	
}
