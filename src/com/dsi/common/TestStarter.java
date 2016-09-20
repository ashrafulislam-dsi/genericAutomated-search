package com.dsi.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

/*
 * this class will help to execute test suite
 */
public class TestStarter {

	private List<String> suites;
	private TestListenerAdapter tla;
	private TestNG testng;
	
	
	/** this will run the whole test suite */
	public void startTest() {
		try	{
			testng = new TestNG();
			//setting.setDriver();
			
			suites = new ArrayList<String>();
			suites.add("config/testng.xml");
			
			testng.setOutputDirectory("TestReport");
			
			testng.setTestSuites(suites);
			testng.run();
		  }
		catch(Exception ex) {
			String errorMsg = "Error reported on: "+new Date()+"\nEither Testsuite '"+testng.getDefaultSuiteName()+"' and TestCases in '"+testng.getDefaultTestName()+"' does not exist.\n";
			 System.out.println(errorMsg+" Message - "+ex.getMessage());
			 //ex.printStackTrace();
				 ex.printStackTrace();
		}
	}
}
