package com.dsi.suites;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dsi.common.TestHelper;
import com.dsi.suites.pages.EmployeeManagerPage;
import com.dsi.suites.pages.LoginPage;
import com.dsi.util.Generic;


public class DataProviderSearch extends TestHelper{
	@BeforeClass
	public void doLogin(){
		new LoginPage().signIn("sabbir@gmail.com", "1234");
	}
	
	/*@Test(dataProvider = "getData")
	public void test_searchFunctionality(String fName, String lName, String oName, String bankAcc, String nId, String email, String teamName, String projName, String date){
		EmployeeManagerPage emp = new EmployeeManagerPage();
		System.out.println("First name: " + fName);
		enterData(emp.firstName, fName);
		enterData(emp.lastName, lName);
		enterData(emp.otherName, oName);
		enterData(emp.bankAcount, bankAcc);
		enterData(emp.NID, nId);
		enterData(emp.email, email);
		enterData(emp.teamName, teamName);
		enterData(emp.projectName, projName);
		System.out.println("before search click ");
		emp.clickOnSearchBtn();
		
		System.out.println("Name: "+ fName);
		
	}*/
	
	@Test(dataProvider = "getData")
	public void testSearch(JSONObject jObject){
		
		EmployeeManagerPage emp = new EmployeeManagerPage();
		
		
		
		boolean isValidData = false;
		JSONObject userDataObject = null;
		
		
		if((JSONObject) jObject.get("valid") != null){
			userDataObject = (JSONObject) jObject.get("valid");
			isValidData = true;
		}else{
			userDataObject = (JSONObject) jObject.get("invalid");
		}
		
		
		System.out.println("object found");
		String firstName = userDataObject.get("firstName").toString();
		System.out.println("fname");
		String lastName = userDataObject.get("lastName").toString();
		String otherName = userDataObject.get("otherName").toString();
		String bankAccount = userDataObject.get("bankAccount").toString();
		String NID = userDataObject.get("NID").toString();
		String email = userDataObject.get("email").toString();
		String teamName = userDataObject.get("teamName").toString();
		String projectName = userDataObject.get("projectName").toString();
		
		
		enterData(emp.firstName, firstName);
		enterData(emp.lastName, lastName);
		enterData(emp.otherName, otherName);
		enterData(emp.bankAccount, bankAccount);
		enterData(emp.NID, NID);
		enterData(emp.email, email);
		enterData(emp.teamName, teamName);
		enterData(emp.projectName, projectName);
		
		System.out.println("before search click ");
		
		emp.clickOnSearchBtn();
		TestHelper.waitFor(1);
		
	}

	@DataProvider
	public Object[][] getData(){
		return Generic.getJsonDataFromFile("resources/All InputForTestcases.json");
	}
}
