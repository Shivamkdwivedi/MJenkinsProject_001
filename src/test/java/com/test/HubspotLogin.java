package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pageutil.loginpageutils;

import io.github.bonigarcia.wdm.WebDriverManager;



public class HubspotLogin {
	
	public WebDriver driver;
	private loginpageutils lpu;
	
	@BeforeMethod
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://app.hubspot.com/login");
	}
	
	@Test
	public void login() {
		lpu=new loginpageutils(driver);
		lpu.uid("shivamkdwivedi645@gmail.com");
		lpu.pwd("Shivam@test123");
		lpu.login();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}


