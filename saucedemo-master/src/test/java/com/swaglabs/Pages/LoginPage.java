package com.swaglabs.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.swaglabs.base.LaunchSwagLabs;

public class LoginPage extends LaunchSwagLabs{

    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement usernameTextBox;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordTextBox;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton; 
    
    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement lockedOutMessage; 
    
    @FindBy(xpath = "//pre[@id='login_credentials']")
    private WebElement loginCredentials; 
    

    public WebDriver driver;
    public static String url = "https://www.saucedemo.com/";

    public static LoginPage visitPage(WebDriver driver) {
    	LoginPage page = new LoginPage(driver);
        page.visitPage();
        return page;
    }
   
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visitPage() {
        this.driver.get(url);
    }

    
    public InventoryPage enterCredentials(String username, String password) throws InterruptedException {
    	usernameTextBox.sendKeys(username);
    	passwordTextBox.sendKeys(password);
    	
    	loginButton.click();
        return PageFactory.initElements(driver, InventoryPage.class);
    }
   
    
    public boolean verifyLoginPage() {
    	WebDriverWait wait = new WebDriverWait(driver, 30);
    	wait.until(ExpectedConditions.visibilityOf(loginButton));
    	//System.out.println("Value is: "+loginButton.getText());
        return true;
    }
    
    public String verifyLockedOutMessage() {
    	WebDriverWait wait = new WebDriverWait(driver, 30);
    	wait.until(ExpectedConditions.visibilityOf(lockedOutMessage));
        return lockedOutMessage.getText();
    }

}
