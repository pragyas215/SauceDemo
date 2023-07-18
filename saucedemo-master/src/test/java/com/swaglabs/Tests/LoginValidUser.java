package com.swaglabs.Tests;



import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.openqa.selenium.WebDriver;

import com.swaglabs.Pages.InventoryPage;
import com.swaglabs.Pages.LoginPage;
import com.swaglabs.base.LaunchSwagLabs;


public class LoginValidUser extends LaunchSwagLabs {

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
    public void LoginValidUserTest() throws InterruptedException
        {
    	
        Reporter.log("Visiting Swag Labs Login page...");
        LoginPage page = LoginPage.visitPage(driver);

        Reporter.log("Greet Sign In To Swag Labs Page...");
        InventoryPage inventory = page.enterCredentials("standard_user", "secret_sauce");
        
        Reporter.log("View Product Inventory...");
        AssertJUnit.assertTrue(inventory.viewInventory().contains("Products"));
        
        Reporter.log("Logging Out...");
        inventory.clickMenuButton();
        Thread.sleep(500);
        inventory.clickLogout();
           
    }

}