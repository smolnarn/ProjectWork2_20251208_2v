package hu.masterfield.digitalbank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewSavingsAccountPage extends BasePage {
    
    public NewSavingsAccountPage(WebDriver driver) {
        super(driver);
    }
    
    public boolean isLoaded() {
        try {
            wait.until(ExpectedConditions.urlContains("savings-add"));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='radio']")));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public void selectAccountType(String accountType) {
        WebElement radio = wait.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector("input[type='radio'][id*='" + accountType + "' i]")
        ));
        if (!radio.isSelected()) {
            radio.click();
        }
    }
    
    public void selectOwnership(String ownership) {
        WebElement radio = wait.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector("input[type='radio'][id*='" + ownership + "' i]")
        ));
        if (!radio.isSelected()) {
            radio.click();
        }
    }
    
    public void enterAccountName(String accountName) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector("input[type='text'][id*='account' i], input[id*='name' i]")
        ));
        field.clear();
        field.sendKeys(accountName);
    }
    
    public void enterInitialDeposit(String amount) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector("#openingBalance")
        ));
        field.clear();
        field.sendKeys(amount);
    }
    
    public void submitForm() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector("#newSavingsSubmit")
        ));
        button.click();
    }
    
    public void resetForm() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector("button[type='reset']")
        ));
        button.click();
    }
    
    public boolean areAllFieldsCleared() {
        WebElement accountNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector("input[type='text'][id*='account' i], input[id*='name' i]")
        ));
        WebElement initialDepositField = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector("#openingBalance")
        ));
        
        String accountName = accountNameField.getAttribute("value");
        String initialDeposit = initialDepositField.getAttribute("value");
        
        boolean accountNameEmpty = accountName == null || accountName.isEmpty();
        boolean depositEmpty = initialDeposit == null || initialDeposit.isEmpty();
        
        return accountNameEmpty && depositEmpty;
    }
    
    public void fillFormWithTestData() {
        selectAccountType("Saving");
        selectOwnership("Individual");
        enterAccountName("Test Account");
        enterInitialDeposit("100");
    }
    
    public String getSuccessMessage() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector("#new-account-msg")
        ));
        return message.getText();
    }
    
    public String getErrorMessage() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector(".alert-danger, .alert.alert-danger, div[role='alert'].alert-danger")
        ));
        return message.getText();
    }
}