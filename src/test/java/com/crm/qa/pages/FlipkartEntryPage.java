package com.crm.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.ParseException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class FlipkartEntryPage extends TestBase{
	
	@FindBy(id="//button[@class='_2AkmmA _29YdH8']")
	WebElement closePopup;
	
	@FindBy(xpath="//input[@name='q']")
	WebElement searchbox;

	@FindBy(xpath="//button[@class='vh79eN']")
	WebElement searchIcon;	
	
	@FindBy(xpath="//img[@title='Flipkart']")
	WebElement flipkartLogo;
	
	@FindBy(xpath="//a[contains(@href,'/apple-iphone-xr')]//div[@class='_1vC4OE _2rQ-NK']")
	WebElement flipkartPrice;
	
	public FlipkartEntryPage()
	{
		PageFactory.initElements(driver, this); 
		//this is pointing to current class object
	}

	
	String flipkartUrl= prop.getProperty("flipkarturl");
	
	public void closePopup() throws InterruptedException, AWTException
	{
		driver.get(flipkartUrl);
		try{
			Robot rb = new Robot();
			rb.keyPress(KeyEvent.VK_ESCAPE);
		}catch(Exception e)
		{
			Thread.sleep(2000);
			Robot rb = new Robot();
			rb.keyPress(KeyEvent.VK_ESCAPE);
		}	
	}
	
	public boolean validateFlipkartLogo()
	{
		driver.get(flipkartUrl);
		return flipkartLogo.isDisplayed();
	}
	

	public long getPriceOfItem() throws InterruptedException, AWTException
	{
		FlipkartEntryPage obj = new FlipkartEntryPage();
		driver.get(flipkartUrl);
		obj.closePopup();
		searchbox.sendKeys("iPhone XR (64GB) - Yellow");
		searchIcon.click();
		String PriceValue = flipkartPrice.getText();
		System.out.println("price value " + PriceValue);
		PriceValue  = PriceValue.substring(1);
		System.out.println("price value " + PriceValue);
		long price = TestUtil.returnLongFrmString(PriceValue);
	    return price;
	     
	}
}
