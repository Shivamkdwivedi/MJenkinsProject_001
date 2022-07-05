package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class googletest {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void launcBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}
	
	@Test
	public void logo() {
		boolean logo=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/img")).isDisplayed();
		Assert.assertTrue(logo);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
