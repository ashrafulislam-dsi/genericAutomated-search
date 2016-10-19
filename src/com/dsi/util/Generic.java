package com.dsi.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Generic {
     public static void main(String[] args) {
    	 String filePath = "resources/All InputForTestcases.json";
    	 getJsonDataFromFile(filePath);
     }
     public static Object[][] getJsonDataFromFile(String filePath){
    	 JSONParser parser = new JSONParser();

    		try {

    			JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(filePath));

    			//System.out.println(jsonArray.size());
    			
    			
    			//Object [][] data = new Object[jsonArray.size()][];
    			Object [][] data = new Object[jsonArray.size()][1];
    			
    			
    			for(int i = 0; i < jsonArray.size(); i++){
    				int j = 0;
    				//System.out.println("\n\n" + "Info for Employee"+ " " + (i+1)+"\n" );
    				JSONObject jsonObject = (JSONObject)jsonArray.get(i);
    				//data[i] = new Object[jsonObject.size()];
    				/*Iterator<String> keys = jsonObject.keySet().iterator();
    			    while (keys.hasNext()) {
    			        String key = keys.next();
    			        String value = jsonObject.get(key).toString();
    			        
    			        //System.out.println( key + ":" + value + "" );
    			        
    			        data[i][j]= value;
    			        j++;
    			       
    			        
    			       
    			    }*/
    				
    				
    				data[i][0] = jsonObject;
    				    
    				
			}
    			
    			
    			//System.out.println("Data size: "+data[0][0]);
    			
    			
    			return data;
    			

    		} catch (FileNotFoundException e) {
    			e.printStackTrace();
    		} catch (IOException e) {
    			e.printStackTrace();
    		} catch (ParseException e) {
    			e.printStackTrace();
    		}

    		return null;
     }
    	  
    	    
    	   

}