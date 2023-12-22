package com.adactin.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.adactin.baseclass.BaseClass;

public class LoginPageLocator extends BaseClass{
	

		public static WebElement getuser() {
			return driver.findElement(By.id("username"));	
		}
		
		public static WebElement getpass() {
			return driver.findElement(By.id("password"));
		}
		
		public static WebElement getlogin_Button() {
			return driver.findElement(By.id("login"));
		}
		
		
	}


