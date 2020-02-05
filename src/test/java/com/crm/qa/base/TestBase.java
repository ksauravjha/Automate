package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;



public class TestBase{
	
public static WebDriver driver;
public static Properties prop;
	
	public TestBase()
	{
		try {
			prop = new Properties();
			FileInputStream fip = new FileInputStream(
					System.getProperty("user.dir")+"\\src\\test\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(fip);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
		
	}
	
	public static void initialization()
	{
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ".\\src\\test\\java\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Hello, driver initialized");
		}
		else if(browserName.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "");
			driver = new FirefoxDriver();
		}
		System.out.println("Hello, driver minimized");
		driver.manage().window().maximize();
		System.out.println("Hello, driver maximized");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
	}

}

		