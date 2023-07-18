package com.swaglabs.Tests;



import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.openqa.selenium.WebDriver;

import com.swaglabs.Pages.CartPage;
import com.swaglabs.Pages.InventoryPage;
import com.swaglabs.Pages.LoginPage;
import com.swaglabs.base.LaunchSwagLabs;


public class AddToCartSingleItem extends LaunchSwagLabs {

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
    public void AddToCartSingleItemTest()
            throws InterruptedException {

     
        Reporter.log("Visiting Swag Labs Login page...");
        LoginPage loginPage = LoginPage.visitPage(driver);
        
        Reporter.log("Greet Sign In To Swag Labs Page...");
        InventoryPage inventoryPage = loginPage.enterCredentials("standard_user", "secret_sauce");
         
        Reporter.log("View Product Inventory...");
        AssertJUnit.assertTrue(inventoryPage.viewInventory().contains("Products"));
         
        Reporter.log("Add To Cart Backpack...");
        inventoryPage.clickAddToCartBackpack();
         
        Reporter.log("Go To Cart...");
        CartPage cart = inventoryPage.goToCart();
         
        Reporter.log("Verify Backpack Item In Cart...");
        AssertJUnit.assertTrue(cart.verifyBackpackinCart().contains("Sauce Labs Backpack"));
           
    }

}