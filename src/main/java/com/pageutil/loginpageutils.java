package com.pageutil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginpageutils {
	public WebDriver driver;
	
	private By uid=By.id("username");
	private By pwd=By.id("password");
	private By login=By.id("loginBtn");
	
	
	public loginpageutils(WebDriver driver) {
		this.driver=driver;
	}
	
	public void uid(String userid) {
		driver.findElement(uid).sendKeys(userid);
	}
	
	public void pwd(String pwsd) {
		driver.findElement(pwd).sendKeys(pwsd);
	}
	
	public void login() {
		driver.findElement(login).click();
	}

}
