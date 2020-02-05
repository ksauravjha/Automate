package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Properties;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	
	public static long IMPLICIT_WAIT = 10;
	
	public static Properties properties;
	
	public static FileOutputStream fileOut;
	
	public static String input = "The saying, “Always choose your words carefully” is applicable not only during inter-personal communication but it holds true in a corporate context as well, especially during sensitive matters like performance reviews.  A performance review needs to be a balanced affair where as a manager or supervisor you are required to state the obvious, and communicate an effective feedback to the employees. The secret is to craft your performance review comments in such a manner to be specific and short and succinct without sounding on the edge";
		
	public static Long returnLongFrmString(String val)
	{
		String str= val;
		DecimalFormat decimalFormat = new DecimalFormat("");
	     try {
	        long number = decimalFormat.parse(str).longValue();
	        System.out.println("The number is: " + number);
	        return number;
	    } catch (ParseException e) {
	     System.out.println(str + " is not a valid number.");
	     return (long) 0.00;
	   }
		
	}
	
	
	
	public static void writeIntoPropertyFile(String path, String name, long value) throws IOException
	{	
	    properties = new Properties();
		properties.setProperty(name,  String.valueOf(value));
		FileOutputStream fileOut = new FileOutputStream(System.getProperty("user.dir")+path);
		properties.store(fileOut, null);	
		fileOut.close();
	}
	
	public static long readPropertyFile(String path, String key) throws IOException
	{	long num=0;
	    properties = new Properties();
	    FileInputStream fileOut = new FileInputStream(System.getProperty("user.dir")+path);
	    properties.load(fileOut);
	    String val = properties.getProperty(key);
	    num = Long.parseLong(val);
		return num;
	}
	
	
}