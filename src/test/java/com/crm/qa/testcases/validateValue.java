package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.crm.qa.util.TestUtil;

public class validateValue {
	
	@Test
	 public void tearDown() throws IOException
    {
		String Apath = "\\src\\test\\java\\com\\crm\\qa\\config\\config2.properties";
		String Fpath = "\\src\\test\\java\\com\\crm\\qa\\config\\config3.properties";
    	Long val1 = TestUtil.readPropertyFile(Apath, "amazon");
    	System.out.println("price on amazon is " + val1);
    	Long val2 = TestUtil.readPropertyFile(Fpath, "flipkart");
    	System.out.println("price on flipkart is " + val2);
    	if(val1 > val2)
    	{
    		System.out.println("Price on amazon is higher than Flipkart");
    	}
    	else if(val1 < val2)
    	{
    		System.out.println("Price on flipkart is higher than Amazon");
    	}
    	else
    	{
    		System.out.println("Price on flipkart and Amazon is same");
    	}
    	
    }

}
