package hu.masterfield.digitalbank.steps;

import hu.masterfield.digitalbank.driver.DriverInitializer;
import hu.masterfield.digitalbank.pages.CookieBannerPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CookieStepDefs {
    
    private WebDriver driver;
    private CookieBannerPage cookieBannerPage;
    
 
    @Given("I start a new browser session")
    public void iStartANewBrowserSession() {
    
        driver = DriverInitializer.getDriver();
        driver.manage().deleteAllCookies();
        cookieBannerPage = new CookieBannerPage(driver);
    }
    

    @When("I open the test site")
    @Given("I open the test site")
    public void iOpenTheTestSite() {
       
        String baseUrl = System.getProperty("base.url", "http://localhost:8080");
        driver.get(baseUrl);
    }
    
  
    @Then("I see the cookie banner")
    @Given("I see the cookie banner")
    public void iSeeTheCookieBanner() {
        assertTrue(cookieBannerPage.isCookieBannerVisible(), 
                "A cookie banner-nek láthatónak kellene lennie");
    }
    
    
    @When("I accept the cookies")
    public void iAcceptTheCookies() {
        cookieBannerPage.acceptCookies();
    }
    
   
    @Then("the cookie banner disappears")
    public void theCookieBannerDisappears() {
        assertTrue(cookieBannerPage.isCookieBannerDisappeared(), 
                "A cookie banner-nek el kellene tűnnie az elfogadás után");
    }
    
 
    @When("I change cookie settings")
    public void iChangeCookieSettings() {
        cookieBannerPage.changeSettings();
    }
    
   
    @Then("I do not see the cookie banner")
    public void iDoNotSeeTheCookieBanner() {
        assertFalse(cookieBannerPage.isCookieBannerVisible(), 
                "A cookie banner-nek nem kellene láthatónak lennie");
    }
}

