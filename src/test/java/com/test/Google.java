package com.test;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Google {
	public WebDriver driver;
	public TakesScreenshot scrnshot;
	
	@BeforeMethod
	public void launch() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
	}
	
	@Test(priority=2, invocationCount=2)
	public void title() {
		String title=driver.getTitle();
		Assert.assertEquals(title, "Google");
		System.out.println(title);
	}
	
	@Test(dependsOnMethods="title")
	public void googleLogo() {
		boolean logo=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/img")).isDisplayed();
		Assert.assertTrue(logo);
		System.out.println(logo);
	}
	
	@Test(priority=1)
	public void getalllinks() throws IOException {
		List<WebElement> lw=driver.findElements(By.tagName("a"));
		lw.size();
		
		for(int i=0; i<lw.size(); i++) {
			String link=lw.get(i).getAttribute("href");
			
			URL ul=new URL(link);
			HttpURLConnection httpconnect=(HttpURLConnection)ul.openConnection();
			httpconnect.connect();
			int response=httpconnect.getResponseCode();
			if(response>400) {
				System.out.println(link+ " is Broken");
			}
			else {
				System.out.println(link+ " is not Broken");
			}
		}
	}
	
	@AfterMethod
	public void TearDown() throws IOException {	
		driver.quit();
	}

	

}
