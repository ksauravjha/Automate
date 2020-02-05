package com.crm.qa.testcases;

import java.awt.AWTException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AmazonEntryPage;
import com.crm.qa.pages.FlipkartEntryPage;
import com.crm.qa.pages.TripAdvisorPage;
import com.crm.qa.util.TestUtil;


public class TripAdvisorTest extends TestBase{
	
	TripAdvisorPage tripadvisorpage;

	
	public TripAdvisorTest()
	{
		super();// to call base class constructor
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		tripadvisorpage = new TripAdvisorPage();
		
	}
	
	@Test(priority=0)
	public void searchandSelectFirstOption() throws InterruptedException, AWTException
	{
		tripadvisorpage.searchAndSelectFirstClubMahindra();
		String currentWindow = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		Iterator<String> itr = allWindow.iterator();
		
		while(itr.hasNext())
		{
			String newWindow = itr.next();
			if(newWindow != currentWindow)
			{
				driver.switchTo().window(newWindow);
				String title = driver.getTitle();
				Assert.assertEquals(title, "CLUB MAHINDRA MADIKERI, COORG - Resort Reviews, Photos, Rate Comparison - Tripadvisor");
			}
		}
	}
	
 
	@Test(priority=1)
	public void writeReview() throws InterruptedException, AWTException
	{
		tripadvisorpage.WriteAReview();
		String title = driver.getTitle();
		System.out.println("title is ->> " + title);
		Assert.assertEquals(title,"Write a review - Tripadvisor");
	}
    
	 @AfterMethod
	    public void tearDown()
	    {
	    	driver.close();
	    }
	 @AfterSuite
	    public void tearDownAll()
	    {
	    	driver.quit();
	    }

}
