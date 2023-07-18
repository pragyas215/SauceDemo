package com.swaglabs.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage {

    @FindBy(xpath = "//span[@class='title']")
    private WebElement productInventory;  

    @FindBy(xpath = "(//div[@class='inventory_list']//button)[1]")
    private WebElement addToCartBackpackButton;
    
    @FindBy(xpath = "//div//div[@class='inventory_list']//div[3]//div[3]//button[1]")
    private WebElement addToCartBoltTshirtButton;  
    
    @FindBy(xpath = "//div//div[@class='inventory_list']//div[5]//div[3]//button[1]")
    private WebElement addToCartOnesieButton;  
    
    @FindBy(xpath = "//div//div[@class='inventory_list']//div[6]//div[3]//button[1]")
    private WebElement addToCartTshirtRedButton;
    
    @FindBy(xpath = "//div//div[@class='inventory_list']//div[4]//div[3]//button[1]")
    private WebElement addToCartFleeceJacketButton;
    
    @FindBy(xpath = "//div//div[@class='inventory_list']//div[2]//div[3]//button[1]")
    private WebElement addToCartBikeLightButton;
    
    @FindBy(xpath = "//a[@class=\"shopping_cart_link\"]")
    private WebElement cartIcon;
    
    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    private WebElement logoutLink; 
    
    @FindBy(xpath = "//button[contains(text(),'Open Menu')]")
    private WebElement menuButton; 
    
  
  

    public WebDriver driver;
    

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    

    public String viewInventory() {
    	WebDriverWait wait = new WebDriverWait(driver, 30);
    	wait.until(ExpectedConditions.visibilityOf(productInventory));
    	//System.out.println(productInventory.getText());
        return productInventory.getText();
    }
    
    public void clickAddToCartBackpack() {
    	
    	addToCartBackpackButton.click();
  	    
    }
    
        
    public CartPage goToCart() {
    	
    	cartIcon.click();
    	    	
  	    return PageFactory.initElements(driver, CartPage.class);
  	    
    }
    
    public void clickMenuButton() {
    	
    	menuButton.click();
  	    
    }
    
    public void clickLogout() {
    	
    	logoutLink.click();
  	    
    }

  
}
