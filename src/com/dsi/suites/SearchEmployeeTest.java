package com.dsi.suites;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dsi.common.TestHelper;
import com.dsi.suites.pages.EmployeeManagerPage;
import com.dsi.suites.pages.LoginPage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

 

public class SearchEmployeeTest extends TestHelper{
	LoginPage loginPage = new LoginPage();
	EmployeeManagerPage em = new EmployeeManagerPage();
	
	String searchkeyForFirstName = "a";
	/*String searchkeyForLastName = "aaa";
	String searchkeyForEmail = "aaa";
	String searchkeyForteamName = "aaa";*/
	
	final String noDataFoundMsg = "No data Found";
	
	final By noDataFoundMsgLocator = By.cssSelector("body > div.ng-scope > div > div > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(2) > div.ng-scope > div");	
    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By otherName = By.id("otherName");
    By bankAcount = By.id("bankAcc");
    By NID = By.id("nationalId");
    By email = By.id("emailAdd");
    By teamName = By.id("teamName");
    By projectName = By.id("projName");
    
    
    By firstNameResultLocator = By.cssSelector("table > tbody > tr > td:nth-child(2)");
    By lastNameResultLocator = By.cssSelector("table > tbody > tr > td:nth-child(3)");
    By emailResultLocator = By.cssSelector("table > tbody > tr > td:nth-child(5)");
   
	
	@BeforeClass
	public void loginIntoSystem(){
		loginPage.signIn("sabbir@gmail.com", "1234");
	}
	
	
	@AfterClass
	public void logoutFromSystem(){
		em.logOutFromSystem();
	}
	
	@Test
	public void blankSearchForActiveUser(){
		em.checkActive();
		em.clickOnSearchBtn();
		
		
		if(em.isSearchResultEmpty()){
			Assert.assertTrue(true);
		}else{
			Assert.assertTrue(em.isActiveSearchOk());
		}
	}
	
	@Test
	public void blankSearchForInActiveUser(){
		em.unchecktActive();
		System.out.println("clicked");
		
		em.clickOnSearchBtn();
		
		if(em.isSearchResultEmpty()){
			Assert.assertTrue(true);
		}else{
			Assert.assertTrue(em.isInActiveSearchOk());
		}
	}
	
	@Test
	public void test_firstNameLikeMatchTestForActiveUser(){
		em.searchByActiveUser(firstName, searchkeyForFirstName);
		
		if(em.isSearchResultEmpty()){
			Assert.assertTrue(true);
		}else{
			Assert.assertTrue(em.isLikeMatchValid(firstNameResultLocator, searchkeyForFirstName));
			Assert.assertTrue(em.isActiveSearchOk());
		}	
	}
	

	@Test
	public void test_firstNameLikeMatchTestForInactiveUser(){
		em.searchByInActiveUser(firstName, searchkeyForFirstName);
		
		if(em.isSearchResultEmpty()){
			Assert.assertTrue(true);
		}else{
			Assert.assertTrue(em.isLikeMatchValid(firstNameResultLocator, searchkeyForFirstName));
			Assert.assertTrue(em.isInActiveSearchOk());
		}	
	}
	
	
	@Test
	
	public void test_EmployeeIdExactMatchTestForActiveUser(){
		em.searchByActiveUser(firstName, searchkeyForFirstName);
		
		if(em.isSearchResultEmpty()){
			Assert.assertTrue(true);
		}else{
			Assert.assertTrue(em.isLikeMatchValid(firstNameResultLocator, searchkeyForFirstName));
		}	
	}
	
	@Test
	public void activeSearchTest(){
		final String filePathForName = "C://Users/me/Desktop/csv.txt"; 
		final int maxBoundForLineNumber = 4;
		String firstName = TestHelper.getDataAt(filePathForName, getRandomNumberInRange(maxBoundForLineNumber));
		String lastName = TestHelper.getDataAt(filePathForName, getRandomNumberInRange(maxBoundForLineNumber));
		String otherName = TestHelper.getDataAt(filePathForName, getRandomNumberInRange(maxBoundForLineNumber));
		String teamName = TestHelper.getDataAt(filePathForName, getRandomNumberInRange(maxBoundForLineNumber));
		
		enterData(this.firstName, getUsableData(firstName));
		enterData(this.lastName, getUsableData(lastName));
		
		boolean isResultOutputValid = isDataValid(firstName) && isDataValid(lastName);
		
		if(isResultOutputValid == false){
			System.out.println("There's an invalid data...");
			Assert.assertEquals(getElementText(noDataFoundMsgLocator),noDataFoundMsg);
		}else{
			System.out.println("There's an valid data...");
		}
		
	}
	
	
	
		
		
	}
	
   

