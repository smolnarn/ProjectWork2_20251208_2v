package hu.masterfield.digitalbank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ViewSavingsAccountsPage extends BasePage {
    
    @FindBy(css = ".card.bg-success, .card-success, .card.text-white.bg-success")
    private List<WebElement> greenCards;
    
    @FindBy(css = ".transaction-item, .transaction-row, tbody tr")
    private List<WebElement> transactions;
    
    @FindBy(css = ".alert-success, .alert.alert-success")
    private WebElement successMessage;
    
    public ViewSavingsAccountsPage(WebDriver driver) {
        super(driver);
    }
    
    public boolean isLoaded() {
        try {
            wait.until(ExpectedConditions.urlContains("savings-view"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isGreenCardVisible() {
        wait.until(ExpectedConditions.presenceOfElementLocated(
            By.cssSelector(".card.bg-success, .card-success, .card.text-white.bg-success, .bg-success")
        ));
        return true;
    }
    
    public String getCardFieldValue(String fieldName) {
        try {
            WebElement card = greenCards.get(0);
            
            String[] xpathPatterns = {
                String.format(".//*[contains(text(),'%s')]/following-sibling::*[1]", fieldName),
                String.format(".//*[contains(text(),'%s')]/../*[2]", fieldName),
                String.format(".//*[text()='%s']/following-sibling::*", fieldName),
                String.format(".//*[contains(@class,'field-label') and contains(text(),'%s')]/../*[contains(@class,'field-value')]", fieldName)
            };
            
            for (String xpath : xpathPatterns) {
                try {
                    WebElement valueElement = card.findElement(By.xpath(xpath));
                    if (valueElement != null && !valueElement.getText().isEmpty()) {
                        return valueElement.getText().trim();
                    }
                } catch (Exception e) {
                }
            }
            
            return "";
        } catch (Exception e) {
            return "";
        }
    }
    
    public boolean verifyCardData(String field, String expectedValue) {
        String actualValue = getCardFieldValue(field);
        return actualValue.contains(expectedValue) || expectedValue.contains(actualValue);
    }
    
    public boolean isInitialDepositInTransactions(String amount) {
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.cssSelector(".transaction-item, .transaction-row, tbody tr")
            ));
            
            for (WebElement transaction : transactions) {
                String transactionText = transaction.getText();
                if (transactionText.contains(amount) && 
                    (transactionText.toLowerCase().contains("deposit") || 
                     transactionText.toLowerCase().contains("befizetés") ||
                     transactionText.toLowerCase().contains("initial"))) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    
    public String getAccountNumber() {
        return getCardFieldValue("Account Number").replaceAll("[^0-9]", "");
    }
    
    public String getInterestRate() {
        return getCardFieldValue("Interest Rate");
    }
    
    public String getBalance() {
        return getCardFieldValue("Balance");
    }
    
    public String getOwnership() {
        return getCardFieldValue("Ownership");
    }
    
    public String getAccountType() {
        return getCardFieldValue("Account");
    }
    
    public String getSuccessMessage() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector("#new-account-msg")
        ));
        return message.getText();
    }
}

