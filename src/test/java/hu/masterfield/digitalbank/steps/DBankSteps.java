package hu.masterfield.digitalbank.steps;

import hu.masterfield.digitalbank.pages.CookieBannerPage;
import hu.masterfield.digitalbank.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.time.Duration;

public class DBankSteps {
    protected static WebDriver driver = null;
    protected static WebDriverWait wait = null;
    protected static CookieBannerPage cookieBannerPage = null;
    private static Scenario scenario = null;

    @Before
    public void setup(Scenario scenario) throws IOException {
        DBankSteps.scenario = scenario;
        
        WebDriverManager.chromedriver().clearDriverCache().setup();

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--lang=en-US");

        options.addArguments("--incognito");

        options.addArguments("--disable-blink-features=AutomationControlled");

        options.addArguments("--disable-infobars");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();

        cookieBannerPage = new CookieBannerPage(driver);
    }

    protected String getPageUrl(String pageName) {
        return "https://eng.digitalbank.masterfield.hu/bank/" + pageName;
    }

    @After
    public void cleanup(Scenario scenario) {
        if (scenario.isFailed()) {
            takeScreenshot("FAILED");
        }
        if (driver != null) {
            driver.quit();
        }
    }

  
    private void takeScreenshot(String screenshotName) {
        try {
            if (driver != null) {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", screenshotName);
            }
        } catch (Exception e) {
            System.out.println("Hiba a screenshot készítése során: " + e.getMessage());
        }
    }


    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        CookieBannerPage cPage = new CookieBannerPage(driver);
        cPage.acceptCookies();

        LoginPage lPage = new LoginPage(driver);
        lPage.isLoaded();
    }

    @When("I login with {string} and {string}")
    public void iLoginWithAnd(String arg0, String arg1) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("I see a message {string}")
    public void iSeeAMessage(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("I am on the home page")
    public void iAmOnTheHomePage() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("I see the welcome message")
    public void iSeeTheWelcomeMessage() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("I see the left side menu")
    public void iSeeTheLeftSideMenu() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("I am logged in")
    public void iAmLoggedIn() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("I log out")
    public void iLogOut() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("I am redirected to the login page")
    public void iAmRedirectedToTheLoginPage() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("I open the {string} page")
    public void IOpenThePage(String pageName) {
        driver.get(getPageUrl(pageName));
        takeScreenshot("Page opened: " + pageName);
    }
    
    @Then("I see the cookie banner")
    public void iSeeTheCookieBanner() {
        assertTrue(cookieBannerPage.isCookieBannerVisible(), 
                "A cookie banner-nek láthatónak kellene lennie");
        takeScreenshot("Cookie banner visible");
    }
        
    @When("I accept the cookies")
    public void iAcceptTheCookies() {
        cookieBannerPage.acceptCookies();
    }
     
    @Then("the cookie banner disappears")
    public void theCookieBannerDisappears() {
        assertTrue(cookieBannerPage.isCookieBannerDisappeared(), 
                "A cookie banner-nek el kellene tűnnie az elfogadás után");
        takeScreenshot("Cookie banner disappeared");
    }
}
