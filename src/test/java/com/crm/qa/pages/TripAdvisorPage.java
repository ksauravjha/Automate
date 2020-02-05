package com.crm.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class TripAdvisorPage extends TestBase{

	
	@FindBy(xpath="//*[contains(text(), 'Sign up')]//ancestor::div//ancestor::div//div[@title='Search']")
	WebElement SearchItem;
	
	@FindBy(xpath="//div[@id='component_5']//input[@title='Search']")
	WebElement SearchItemNew;
	
	@FindBy(xpath = "//*[@id='global_nav_search_form']//input[@id='mainSearch']")
	WebElement mainSearch;
	
	@FindBy(xpath = "//span[contains(text(),'Search')]")
	WebElement mainSearchItem;
	
	@FindBy(xpath="//div[@class='ui_columns results_panel']//div[@class='first-row']")
	WebElement firstSearchRowItem;
	
	@FindBy(xpath="//a[contains(@title,'Club Mahindra')][1]")
	WebElement firstSearchItem;
	
	@FindBy(xpath="//a[contains(text(),'Write a review')][1]")
	WebElement writeReview;
	
	@FindBy(xpath="/html/body/div[4]/div[2]/div/div/form/div[1]/div/fieldset[1]/div[2]/div/div/div[1]/div[2]/div[2]/span")
	WebElement threeStarRating;
	
	@FindBy(xpath="//input[@id='ReviewTitle']")
	WebElement titleOfReview;
	
	@FindBy(xpath="//*[@id='ReviewText']")
	WebElement yourReview;
	
	@FindBy(xpath="//*[text()='Hotel Ratings']")
	WebElement hotelRatingsText;
	
	@FindBy(id ="trip_date_month_year")
	WebElement dropdownVal;
	
	@FindBy(xpath ="//div[text()='Friends']")
	WebElement tripwithFriend;
	
	
	@FindBy(xpath="/html/body/div[4]/div[2]/div/div/form/div[1]/div/fieldset[1]/div[3]/div[3]/div[2]/div[1]/div[2]/div[1]/span")
	WebElement services;
	
	@FindBy(xpath="/html/body/div[4]/div[2]/div/div/form/div[1]/div/fieldset[1]/div[3]/div[3]/div[2]/div[2]/div[2]/div[1]/span")
	WebElement cleanliness;
	
	@FindBy(xpath="/html/body/div[4]/div[2]/div/div/form/div[1]/div/fieldset[1]/div[3]/div[3]/div[2]/div[3]/div[2]/div[1]/span")
	WebElement location;
	
	@FindBy(xpath="//input[@id='noFraud']")
	WebElement noFraudCheckbox;
	
	@FindBy(xpath="//div[@id='SUBMIT']/span")
	public  WebElement submitReview;
	
	
	
	
	String tripadvisorurl= prop.getProperty("tripadvisorurl");
	
	public TripAdvisorPage()
	{
		PageFactory.initElements(driver, this); 
		
	}
		
	public void searchAndSelectFirstClubMahindra() throws InterruptedException, AWTException
	{	
		try{
		
			driver.get(tripadvisorurl);	
			Thread.sleep(2000);
			SearchItemNew.click();
			SearchItemNew.sendKeys("Club Mahindra");
			Thread.sleep(2000);
			firstSearchItem.click();
		}
		catch(Exception e)
		{
		driver.get(tripadvisorurl);
		Thread.sleep(5000);	
		SearchItem.click();
		Thread.sleep(5000);
		mainSearch.click();
		mainSearch.sendKeys("Club Mahindra");
		Thread.sleep(2000);
		firstSearchRowItem.click();
		Thread.sleep(5000);}
		
	}
	
	public void WriteAReview() throws InterruptedException, AWTException
	{
		driver.get(tripadvisorurl);	
		try{
			Thread.sleep(5000);
			SearchItemNew.click();
			SearchItemNew.sendKeys("Club Mahindra");
			Thread.sleep(2000);
			firstSearchItem.click();
			Thread.sleep(5000);
			writeReview.click();
			Thread.sleep(10000);
			String currentWindow = driver.getWindowHandle();
			System.out.println("currentWindow" + currentWindow);
			Set<String> allWindow = driver.getWindowHandles();
			System.out.println("allWindow" + allWindow);
	        Iterator<String> itr = allWindow.iterator();
		
			while(itr.hasNext())
			{
				String newWindow = itr.next();
				if(!currentWindow.equals(newWindow)){
					driver.switchTo().window(newWindow);
					System.out.println(driver.switchTo().window(newWindow).getTitle());
					Thread.sleep(3000);
					Actions act = new Actions(driver);
					act.moveToElement(threeStarRating).click().build().perform();
					titleOfReview.sendKeys("its good");
					yourReview.sendKeys(TestUtil.input);
					Thread.sleep(3000);
					yourReview.sendKeys(Keys.TAB);  
					tripwithFriend.click();
					Select sc = new Select(dropdownVal);
					sc.selectByIndex(1);		
					act.moveToElement(services).click().build().perform();
					Thread.sleep(1000);
					act.moveToElement(cleanliness).click().build().perform();
					Thread.sleep(1000);
					act.moveToElement(location).click().build().perform();
					Thread.sleep(1000);
					noFraudCheckbox.click();		
				}
					
			}
			
		}
		catch(Exception e)
		{
		Thread.sleep(5000);	
		SearchItem.click();
		mainSearch.click();
		Thread.sleep(1000);
		mainSearch.sendKeys("Club Mahindra");
		firstSearchRowItem.click();
		Thread.sleep(5000);
		writeReview.click();
		Thread.sleep(10000);
		String currentWindow = driver.getWindowHandle();
		System.out.println("currentWindow" + currentWindow);
		Set<String> allWindow = driver.getWindowHandles();
		System.out.println("allWindow" + allWindow);
        Iterator<String> itr = allWindow.iterator();
	
		while(itr.hasNext())
		{
			String newWindow = itr.next();
			if(!currentWindow.equals(newWindow)){
				driver.switchTo().window(newWindow);
				System.out.println(driver.switchTo().window(newWindow).getTitle());
				Thread.sleep(3000);
				Actions act = new Actions(driver);
				act.moveToElement(threeStarRating).click().build().perform();
				titleOfReview.sendKeys("its good");
				yourReview.sendKeys(TestUtil.input);
				Thread.sleep(1000);
				yourReview.sendKeys(Keys.TAB);  
				tripwithFriend.click();
				Select sc = new Select(dropdownVal);
				sc.selectByIndex(1);		
				act.moveToElement(services).click().build().perform();
				Thread.sleep(1000);
				act.moveToElement(cleanliness).click().build().perform();
				Thread.sleep(1000);
				act.moveToElement(location).click().build().perform();
				Thread.sleep(1000);
				noFraudCheckbox.click();	
				Thread.sleep(1000);
			}
			
		
		}
	}

	}	
}
