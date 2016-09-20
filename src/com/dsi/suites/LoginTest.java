package com.dsi.suites;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dsi.common.TestHelper;
import com.dsi.suites.pages.EmployeeManagerPage;
import com.dsi.suites.pages.LoginPage;import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;

public class LoginTest  extends TestHelper{
	LoginPage loginPage = new LoginPage();
	EmployeeManagerPage em = new EmployeeManagerPage();
	
	final String blankSubmissionMsg = "This field is required";
	
	final String incorrectEmailMessage = "Invalid username or password!!";
	final By incorrectEmailMessageLocator = By.cssSelector("body > div.ng-scope > div:nth-child(2) > div > div > div > div.col-xs-8.col-sm-6.col-md-5.col-lg-4 > div.formContainer > div.formBody > form > div:nth-child(3) > span");
	
	final By blankUserMsgLocator = By.cssSelector("body > div.ng-scope > div:nth-child(2) > div > div > div > div.col-xs-8.col-sm-6.col-md-5.col-lg-4 > div.formContainer > div.formBody > form > div:nth-child(1) > span:nth-child(3)");
	final By blankPasswdMsgLocator = By.cssSelector("body > div.ng-scope > div:nth-child(2) > div > div > div > div.col-xs-8.col-sm-6.col-md-5.col-lg-4 > div.formContainer > div.formBody > form > div:nth-child(2) > span");
	
	@Test
	 public void testURL ()
	 { 
		driver.get("http://localhost:8888/#/");
		Assert.assertTrue(isElementPresent(loginPage.userAccount));
		Assert.assertTrue(isElementPresent(loginPage.passwd));
		Assert.assertTrue(isElementPresent(loginPage.loginBtn));
	  
	 }
	
	@Test
	public void test_blankLogin(){
		loginPage.signIn("", "");
		
		/*String userErrorMsg = getElementText(blankUserMsgLocator);
		String passwdErrorMsg = getElementText(blankPasswdMsgLocator);
		
		Assert.assertEquals(userErrorMsg, blankSubmissionMsg);
		Assert.assertEquals(passwdErrorMsg, blankSubmissionMsg);*/
		
		Assert.assertEquals(getElementText(blankUserMsgLocator), blankSubmissionMsg);
		Assert.assertEquals(getElementText(blankPasswdMsgLocator), blankSubmissionMsg);
	}
	
	@Test
	public void LoginWithValidUsernameAndPasswordBlank(){
		loginPage.signIn("sabbir@gmail.com", "");
		Assert.assertEquals(getElementText(blankPasswdMsgLocator), blankSubmissionMsg);
		
		/*boolean isLogged = em.isUserLoggedIn();
		Assert.assertTrue(!isLogged);*/
		
	}
	

	@Test
	public void LoginWithBlankUsernameAndValidPassword(){
		loginPage.signIn("", "1234");
		
		Assert.assertEquals(getElementText(blankUserMsgLocator), blankSubmissionMsg);
		/*boolean isLogged = em.isUserLoggedIn();
		Assert.assertTrue(!isLogged);*/
	}
	
	@Test
	public void LoginWithIncorrectUsernamePassword(){
		loginPage.signIn("sar@gmail.com", "124");
		String incorrectEmailErroressage = getElementText(incorrectEmailMessageLocator);
		Assert.assertEquals(incorrectEmailErroressage, incorrectEmailMessage);
		
		/*boolean isLogged = em.isUserLoggedIn();
		Assert.assertTrue(!isLogged);*/
	}
	
	@Test
	public void LoginWithCaseSensitiveUsernameAndValidPassword(){
		loginPage.signIn("sAbbiR@gmail.com", "1234");
		
		
		
		boolean isLogged = em.isUserLoggedIn();
		Assert.assertTrue(isLogged);
		
		em.logOutFromSystem();
		
	}
	
	@Test
	public void loginWithValidCredentials(){
		loginPage.signIn("sabbir@gmail.com", "1234");
		
		boolean isLogged = em.isUserLoggedIn();
		Assert.assertTrue(isLogged);
	}
}
	

