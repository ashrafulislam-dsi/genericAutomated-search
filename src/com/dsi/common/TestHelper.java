package com.dsi.common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

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
	    public static void waitFor(int waitTimeInSecond){
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
	    
	    /**
	     * 
	     * @param filePtah exact location of the file to read/get data from
	     * @param lineNumber number of the line to read
	     * @return text for specific line or null if not found
	     */
	    public static String getDataAt(String filePtah, int lineNumber){
	    	  String line = "";
	          
	          int lineNumberCounter = 1;
	          try (BufferedReader br = new BufferedReader(new FileReader(filePtah))) {

	              while ((line = br.readLine()) != null) {
	                  
	                  if(lineNumberCounter == lineNumber){
	                	  return line;
	                  }
	                  
	                  lineNumberCounter++;

	              }

	          } catch (IOException e) {
	              e.printStackTrace();
	          }
	          
	          return null;
	    }
	    
	    public static String getUsableData(String textFromFile){
	    	return textFromFile.split(",")[0];
	    }
	    
	    /**
	     * 
	     * @param dataFromSpecificLine
	     * @return
	     */
	    public  static boolean isDataValid(String dataFromSpecificLine){
	    	String [] temp = dataFromSpecificLine.split(",");
	    	if(temp[1].trim().equals("1")){
	    		System.out.println(temp[0].trim() + " is a valid data");
	    		return true;
	    	}else{
	    		System.out.println(temp[0].trim() + " is an invalid data");
	    	}
	    		
	    	
	    	return false;
	    }
	    
	    /**
	     * 
	     * @param maxBound
	     * @return
	     */
	    public static int getRandomNumberInRange(int maxBound){
	    	Random random = new Random();
	    	
	    	return (random.nextInt(maxBound) + 1);
	    }
}
