package com.swaglabs.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    
    @FindBy(xpath = "//div[contains(text(),'Sauce Labs Backpack')]")
    private WebElement backpackLabel; 
    
    
    public WebDriver driver;
    

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public String verifyBackpackinCart() {
    	WebDriverWait wait = new WebDriverWait(driver, 30);
    	wait.until(ExpectedConditions.visibilityOf(backpackLabel));
    	//System.out.println(backpackLabel.getText());
        return backpackLabel.getText();
    }
    
    
   
    
}
