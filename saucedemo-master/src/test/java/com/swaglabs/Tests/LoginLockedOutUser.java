package com.swaglabs.Tests;



import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.openqa.selenium.WebDriver;

import com.swaglabs.Pages.InventoryPage;
import com.swaglabs.Pages.LoginPage;
import com.swaglabs.base.LaunchSwagLabs;



public class LoginLockedOutUser extends LaunchSwagLabs {

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
    public void LoginLockedOutUserTest()
           throws InterruptedException {

        //create webdriver session
      
        Reporter.log("Visiting Swag Labs Login page...");
        LoginPage page = LoginPage.visitPage(driver);

        Reporter.log("Greet Sign In To Swag Labs Page...");
        InventoryPage inventory = page.enterCredentials("locked_out_user", "secret_sauce");
         
        Reporter.log("Verify Locked Out User Message...");
        AssertJUnit.assertTrue(page.verifyLockedOutMessage().contains("Sorry"));
           
    }

}