package com.tesco.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinitions {
    
    private WebDriver driver;

    @Given("the user opens the homepage")
    public void theUserOpensTheHomepage() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        // TODO: Add the URL of the tested page here
        // driver.get("https://www.tesco.com");
    }

    @When("the user clicks on the login button")
    public void theUserClicksOnTheLoginButton() {
        // TODO: Implement the click on the login button
        // WebElement loginButton = driver.findElement(By.id("login-button"));
        // loginButton.click();
    }

    @Then("the login page is displayed")
    public void theLoginPageIsDisplayed() {
        // TODO: Implement the verification
        // String currentUrl = driver.getCurrentUrl();
        // assertTrue(currentUrl.contains("login"));
        
        // Close browser
        if (driver != null) {
            driver.quit();
        }
    }
}

