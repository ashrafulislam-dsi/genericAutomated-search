package com.dsi.suites.pages;

import org.openqa.selenium.By;

import com.dsi.common.TestHelper;

public class EmployeeManagerPage{
	By logoutBtn = By.cssSelector("div[ng-click='logOut()']");
	
	TestHelper th = new TestHelper();
	
	public void logOutFromSystem(){
		TestHelper.hoverOverElement(By.cssSelector("div[ng-class='hovering']"));
		th.waitFor(10);
		th.clickOnElement(logoutBtn, 5);
	}
	
	public boolean isUserLoggedIn(){
		boolean isLogOutPresent = (TestHelper.getDriver().findElements(logoutBtn).size() == 1);
		return isLogOutPresent;
	}
	
}

