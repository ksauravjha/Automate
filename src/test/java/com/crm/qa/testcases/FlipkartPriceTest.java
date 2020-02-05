package com.crm.qa.testcases;

import java.awt.AWTException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AmazonEntryPage;
import com.crm.qa.pages.FlipkartEntryPage;
import com.crm.qa.util.TestUtil;


public class FlipkartPriceTest extends TestBase{
	
	FlipkartEntryPage flipkartentrypage;
	public static long flipkartPrice;
	
	public FlipkartPriceTest()
	{
		super();// to call base class constructor
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		flipkartentrypage = new FlipkartEntryPage();
	}
	
	@Test
	public void HomePageLogoTest()
	{
		try{
		flipkartentrypage.closePopup();
		}
		catch(Exception e)
		{System.out.println("no popup exists");
		}	
		boolean title = flipkartentrypage.validateFlipkartLogo();
		Assert.assertEquals(title, true);
		
	}
	
    @Test
	public void ValidatePriceOnAFlipkart() throws InterruptedException, AWTException, IOException
	{
    	
    	try{
    		flipkartentrypage.closePopup();
    		}
    		catch(Exception e)
    		{System.out.println("no popup exists");
    		}
		long flipkartPrice = flipkartentrypage.getPriceOfItem();
		System.out.println("price is "+ flipkartPrice );
		String Fpath = "\\src\\test\\java\\com\\crm\\qa\\config\\config3.properties";
		TestUtil.writeIntoPropertyFile(Fpath,"flipkart",flipkartPrice);	
		
	}
    
    @AfterMethod
    public void tearDown()
    {
    	driver.close();
    }
	

}
