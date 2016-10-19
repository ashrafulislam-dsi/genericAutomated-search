package com.dsi.suites.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.dsi.common.TestHelper;

public class EmployeeManagerPage{
	TestHelper th = new TestHelper();
	public By logoutBtn = By.cssSelector("div[ng-click='logOut()']");
	public By searchBtn = By.cssSelector("button[ng-click='searchAction()']");
	public By clearBtn = By.cssSelector("div[ng-click='clear()']");
	public By isActiveCheckBoxLocator = By.id("isActive"); 
	public By tableRowLocator = By.cssSelector("table.table > tbody > tr");
	public By activeColumnLocator = By.id("isActive");
	final By noDataFoundMsgLocator = By.cssSelector("body > div.ng-scope > div > div > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(2) > div.ng-scope > div");
	public By firstName = By.id("firstName");
	public By lastName = By.id("lastName");
	public By otherName = By.id("otherName");
	public   By bankAccount = By.id("bankAcc");
	public  By NID = By.id("nationalId");
	public  By email = By.id("emailAdd");
	public   By teamName = By.id("teamName");
	public   By projectName = By.id("projName");

	public By firstNameResultLocator = By.cssSelector("table > tbody > tr > td:nth-child(2)");
	  
	
	final String noDataFoundMsg = "No data Found";
	

	
	
	
	public void logOutFromSystem(){
		TestHelper.hoverOverElement(By.cssSelector("div[ng-class='hovering']"));
		th.waitFor(10);
		th.clickOnElement(logoutBtn, 5);
	}
	
	public boolean isUserLoggedIn(){
		boolean isLogOutPresent = (TestHelper.getDriver().findElements(logoutBtn).size() == 1);
		return isLogOutPresent;
	}
	
	public void searchByActiveUser(By element, String text){
		checkActive();
		
		WebElement searchBox = TestHelper.getDriver().findElement(element);
		searchBox.clear();
		searchBox.sendKeys(text);
		clickOnSearchBtn();
	}
	
	public void searchByInActiveUser(By element, String text){
		unchecktActive();
		
		WebElement searchBox = TestHelper.getDriver().findElement(element);
		searchBox.clear();
		searchBox.sendKeys(text);
		clickOnSearchBtn();
	}
	
	public void checkActive(){
		if(TestHelper.getDriver().findElement(isActiveCheckBoxLocator).isSelected() == false)
			TestHelper.getDriver().findElement(isActiveCheckBoxLocator).click();
	}
	
	public void unchecktActive(){
		if(TestHelper.getDriver().findElement(isActiveCheckBoxLocator).isSelected() == true)
			TestHelper.getDriver().findElement(isActiveCheckBoxLocator).click();
	}
	
	public void clickOnSearchBtn(){
			TestHelper.getDriver().findElement(searchBtn).click();
			th.waitFor(5);
	}
	
	public void clickOnClearBtn(){
		TestHelper.getDriver().findElement(clearBtn).click();
		th.waitFor(2);
	}
	
	public boolean isSearchResultEmpty(){
		String searchEmptyMsg = th.getElementText(noDataFoundMsgLocator);
		
		return searchEmptyMsg.equals(noDataFoundMsg);
	}
	
	public boolean isActiveSearchOk(){
		List<WebElement> activeSearchList = TestHelper.getDriver().findElements(activeColumnLocator);
		
		System.out.println(activeSearchList.size()+"****");
		
		for(WebElement activeColumn : activeSearchList){
			if(activeColumn.getAttribute("class").contains("not-empty") == false){
				return false;
			}
			
		}
		return true;
		}
		
		
	public boolean isInActiveSearchOk(){
		List<WebElement> inActiveSearchList = TestHelper.getDriver().findElements(activeColumnLocator);
			
		System.out.println(inActiveSearchList.size()+"****");
			
		for(WebElement inActiveColumn : inActiveSearchList){
			if(inActiveColumn.getAttribute("class").contains("empty") == false){
				return false;
			}
			}
		
		return true;
	}
	
	public boolean isLikeMatchValid(By location, String searchKey){
		List<WebElement> columnElementList = TestHelper.getDriver().findElements(location);
		
		for(WebElement column : columnElementList){
				if(column.getText().contains(searchKey) == false){
					return false;
				}
			}
		
		return true;
		
		
	}
	
}

