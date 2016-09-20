package com.dsi.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


public class TestHelper{
	   public static WebDriver driver = null;
	    
	    @BeforeTest
	    public void setUp(){
	    	if(driver == null){
	    		driver = new FirefoxDriver();
	    		driver.manage().window().maximize();
	    		driver.get("http://localhost:8888/#/");
	    		System.out.println("Browser opened...");
	    	}
	    }
	    	
	    @AfterTest
	    public void tearDown(){
	    	driver.quit();
	    	System.out.println("Browser closed...");
	    }
	    
	    public void enterData(By element, String data){
	    	WebElement dataElement = driver.findElement(element);
	    	dataElement.clear();
	    	dataElement.sendKeys(data);
	    	//driver.findElement(element).sendKeys(data);
	    }
	    
	    public void clickOnElement(By element, int waitTimeInSeconds){
	    	driver.findElement(element).click();
	    	waitFor(waitTimeInSeconds);
	    }
	    
	    public String getElementAttribute(By element, String desiredAttribute){
	    	return driver.findElement(element).getAttribute(desiredAttribute);
	    }
	    
	    public String getElementText(By element){
	    	return driver.findElement(element).getText().trim();
	    }
	    	
		public boolean isElementPresent(By element){
			return	driver.findElements(element).size() == 1;		
		}
	    	
	    /*
	     * 	@param waitTimeInSecond take integer value in second unit
	     */
	    public void waitFor(int waitTimeInSecond){
	    	try {
				Thread.sleep(waitTimeInSecond * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }

		public static WebDriver getDriver() {
			return driver;
		}

		public static void setDriver(WebDriver driver) {
			TestHelper.driver = driver;
		}
	    	
	    public static void hoverOverElement(By element){
	    	Actions actions = new Actions(driver);
	    	actions.moveToElement(driver.findElement(element)).perform();
	    }	
}
