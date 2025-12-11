package hu.masterfield.digitalbank.steps;

import hu.masterfield.digitalbank.pages.CookieBannerPage;
import hu.masterfield.digitalbank.pages.HomePage;
import hu.masterfield.digitalbank.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
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
    protected static LoginPage loginPage = null;
    protected static HomePage homePage = null;
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
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
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
            System.out.println("Error taking screenshot: " + e.getMessage());
        }
    }


    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        loginPage.isLoaded();
        cookieBannerPage.acceptCookies();
        takeScreenshot("Login page loaded");
    }

    @When("I login with {string} and {string}")
    public void iLoginWithAnd(String username, String password) {
        loginPage.login(username, password);
        takeScreenshot("Login attempt with: " + username);
    }

    @Then("I see a message {string}")
    public void iSeeAMessage(String expectedMessage) {
        String actualMessage = "";
        
        if (loginPage.isOnLoginPage()) {
            actualMessage = loginPage.getErrorMessage();
        }
        
        if (actualMessage.isEmpty() && homePage.isOnHomePage()) {
            actualMessage = homePage.getSuccessMessage();
        }
        
        takeScreenshot("Message displayed");
        assertTrue(actualMessage.contains(expectedMessage) || expectedMessage.contains(actualMessage),
                "Expected message: '" + expectedMessage + "' but got: '" + actualMessage + "'");
    }

    @Then("I am on the {string} page")
    public void iAmOnThePage(String pageName) {
        if (pageName.equals("Áttekintés") || pageName.equals("Overview") || pageName.equals("Dashboard") || pageName.equals("Home")) {
            assertTrue(homePage.isOnHomePage(), 
                    "Should be on the Home/Dashboard page");
        } else {
            String currentUrl = driver.getCurrentUrl();
            assertTrue(currentUrl.contains("/" + pageName),
                    "Expected to be on '" + pageName + "' page, but URL is: " + currentUrl);
        }
        takeScreenshot("On page: " + pageName);
    }

    @And("I see the welcome message")
    public void iSeeTheWelcomeMessage() {
        assertTrue(homePage.isWelcomeMessageDisplayed(), 
                "Welcome message should be displayed on home page");
        takeScreenshot("Welcome message visible");
    }

    @And("I see the left side menu")
    public void iSeeTheLeftSideMenu() {
        assertTrue(homePage.isLeftSideMenuDisplayed(), 
                "Left side menu should be displayed on home page");
        takeScreenshot("Left side menu visible");
    }

    @Given("I am logged in")
    public void iAmLoggedIn() {
        iAmOnTheLoginPage();
        
        loginPage.login("jsmith3", "Demo123!");
        
        assertTrue(homePage.isLoaded(), "Home page should be loaded after successful login");
        takeScreenshot("Logged in successfully");
    }

    @When("I log out")
    public void iLogOut() {
        homePage.clickLogout();
        takeScreenshot("Clicked logout");
    }

    @Then("I am redirected to the {string} page")
    public void iAmRedirectedToThePage(String pageName) {
        String currentUrl = driver.getCurrentUrl();
        takeScreenshot("Redirected to: " + pageName);
        
        assertTrue(currentUrl.contains("/" + pageName),
                "Expected to be redirected to '" + pageName + "' page, but URL is: " + currentUrl);
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
    
    @Then("I see the chart {string}")
    public void iSeeTheChart(String chartName) {
        assertTrue(homePage.isChartVisible(chartName), 
                "Chart should be visible: " + chartName);
        takeScreenshot("Chart visible: " + chartName);
    }
}
