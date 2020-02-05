package com.crm.qa.pages;

import java.text.DecimalFormat;
import java.text.ParseException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class AmazonEntryPage extends TestBase{
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchbox;

	@FindBy(xpath="//input[@value='Go']")
	WebElement searchIcon;	
	
	@FindBy(xpath="//a[@href='/ref=nav_logo']")
	WebElement amazonLogo;
	
	@FindBy(xpath="//a[contains(@href,'/Apple-iPhone-XR-64GB')]//span[@class='a-price-whole']")
	WebElement amazonPrice;
	
	
	public AmazonEntryPage()
	{
		PageFactory.initElements(driver, this); 
		//this is pointing to current class object
	}
	
	String amazonUrl= prop.getProperty("amazonurl");
	
	public boolean validateAmazonLogo()
	{
		driver.get(amazonUrl);
		return amazonLogo.isDisplayed();
	}
	

	public long getPriceOfItem()
	{
		driver.get(amazonUrl);
		searchbox.sendKeys("iPhone XR (64GB) - Yellow");
		searchIcon.click();
		String PriceValue = amazonPrice.getText().toString();
		long price = TestUtil.returnLongFrmString(PriceValue);
	    return price;
	}
}
