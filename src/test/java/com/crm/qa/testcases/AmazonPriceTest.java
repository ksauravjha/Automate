package com.crm.qa.testcases;

import java.awt.AWTException;
import java.io.File;
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


public class AmazonPriceTest extends TestBase{
	
	public static long amazonPrice;
	AmazonEntryPage amazonentrypage;
	FlipkartEntryPage flipkartentrypage;
	FlipkartPriceTest flipk = new FlipkartPriceTest();
	
	
	public AmazonPriceTest()
	{
		super();// to call base class constructor
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		amazonentrypage = new AmazonEntryPage();
		flipkartentrypage = new FlipkartEntryPage();
	}
	
	@Test
	public void HomePageLogoTest()
	{
		boolean title = amazonentrypage.validateAmazonLogo();
		Assert.assertEquals(title, true);
		
	}
	
    @Test
	public void ValidatePriceOnAmazon() throws IOException
	{
		long amazonPrice = amazonentrypage.getPriceOfItem();
		System.out.println("price is "+ amazonPrice );
		String Apath = "\\src\\test\\java\\com\\crm\\qa\\config\\config2.properties";
		TestUtil.writeIntoPropertyFile(Apath,"amazon",amazonPrice);	
		
	}	
     
    @AfterSuite
    public void tearDown() throws IOException
    {	
    	driver.quit();
    }
	

}
