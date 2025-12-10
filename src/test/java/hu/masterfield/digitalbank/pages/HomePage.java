package hu.masterfield.digitalbank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    
    @FindBy(css = "h2, .welcome-text, .user-greeting, .dashboard h2")
    private WebElement welcomeMessage;
    
    @FindBy(css = "aside, .sidebar, nav.sidebar")
    private WebElement leftSideMenu;
    
    @FindBy(css = ".alert-success, .alert.alert-success, div[role='alert'].alert-success")
    private WebElement successMessage;
    
    @FindBy(css = "a[href='/bank/logout'], a[href*='logout']")
    private WebElement logoutButton;
    
    @FindBy(css = ".dropdown-toggle, .user-panel img, img[alt='User Avatar']")
    private WebElement userMenu;
    
    public HomePage(WebDriver driver) {
        super(driver);
    }
 
    
    public boolean isLoaded() {
        try {
            wait.until(ExpectedConditions.urlContains("/home"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public boolean isOnHomePage() {
        return getCurrentUrl().contains("/home");
    }
  

    public boolean isWelcomeMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(welcomeMessage));
            return welcomeMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    public String getWelcomeMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOf(welcomeMessage));
            return welcomeMessage.getText();
        } catch (Exception e) {
            return "";
        }
    }
 

    public boolean isLeftSideMenuDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(leftSideMenu));
            return leftSideMenu.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    public void clickUserMenu() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(userMenu));
            userMenu.click();
        } catch (Exception e) {
        }
    }


    public void clickLogout() {
        try {
        
            clickUserMenu();
        } catch (Exception e) {
          
        }
        
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButton.click();
    }
    

    public String getSuccessMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOf(successMessage));
            return successMessage.getText();
        } catch (Exception e) {
            return "";
        }
    }
}

