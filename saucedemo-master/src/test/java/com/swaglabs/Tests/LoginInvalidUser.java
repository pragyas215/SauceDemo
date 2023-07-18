package com.swaglabs.Tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.openqa.selenium.WebDriver;

import com.swaglabs.Pages.InventoryPage;
import com.swaglabs.Pages.LoginPage;
import com.swaglabs.base.LaunchSwagLabs;

public class LoginInvalidUser extends LaunchSwagLabs {
	
	LaunchSwagLabs basePage;
	WebDriver driver;
	LoginPage loginPage;
	
	@BeforeTest
	public void setUp() {
		basePage = new LaunchSwagLabs();
		driver = basePage.init_driver("chrome");
		loginPage = new LoginPage(driver);
	}
    @Test
    public void LoginInvalidUserTest() throws InterruptedException
          {

        //create webdriver session
        LoginPage page = LoginPage.visitPage(driver);

        Reporter.log("Greet Sign In To Swag Labs Page...");
        InventoryPage inventory = page.enterCredentials("locked_out_user", "bogus");
         
        Reporter.log("Verify Invalid User Message...");
        AssertJUnit.assertTrue(page.verifyLockedOutMessage().contains("do not match"));
           
    }

}