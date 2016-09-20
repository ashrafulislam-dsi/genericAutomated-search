package com.dsi.suites.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import com.dsi.common.TestHelper;

public class LoginPage {
	public By userAccount = By.id("usr");
	public By passwd = By.id("pwd");
	public By loginBtn = By.cssSelector("body > div.ng-scope > div:nth-child(2) > div > div > div > div.col-xs-8.col-sm-6.col-md-5.col-lg-4 > div.formContainer > div.formBody > form > button");
	TestHelper th = new TestHelper();
	
	public void signIn(String userName,  String password){
		th.enterData(userAccount, userName);
		th.enterData(passwd, password);
		
		th.clickOnElement(loginBtn, 4);
	}

}

