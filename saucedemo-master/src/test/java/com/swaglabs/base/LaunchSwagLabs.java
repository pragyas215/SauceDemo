package com.swaglabs.base;



import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.swaglabs.Pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchSwagLabs  {

	public WebDriver driver;
	/**
	 * this method is used to initialize the driver on the basis of browsername
	 * 
	 * @param browserName
	 * @return driver
	 */
	public WebDriver init_driver(String browserName) {

		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}  else {
			System.out.println(browserName + " Browser value is wrong, please pass the correct browser name....");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		return driver;
	}

  
  
}