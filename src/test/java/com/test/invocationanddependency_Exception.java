package com.test;

import org.testng.annotations.Test;

public class invocationanddependency_Exception {

	@Test(invocationCount=2)
	public void loginTest() {
		System.out.println("Welcome to Login Page");
	}
	
	@Test
	public void homePage() {
		System.out.println("Home Page");
	}
	
	@Test(dependsOnMethods="homePage")
	public void linkTest() {
		System.out.println("Link is available?");
	}
	
	@Test(expectedExceptions=ArithmeticException.class)
	public void Sum() {
		int a=9/0;
	}
	
}
