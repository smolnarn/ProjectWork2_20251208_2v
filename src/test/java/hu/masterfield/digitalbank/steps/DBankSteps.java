package hu.masterfield.digitalbank.steps;

import hu.masterfield.digitalbank.pages.CookieBannerPage;
import hu.masterfield.digitalbank.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class DBankSteps {
    protected static WebDriver driver = null;
    protected static WebDriverWait wait = null;

    @Before
    public static void setup() throws IOException {

        ChromeOptions options = new ChromeOptions();

        // angol nyelvű böngésző indítása
        options.addArguments("--lang=en-US");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().setSize(new Dimension(900, 900));

        driver.get("https://eng.digitalbank.masterfield.hu/bank/home");

    }

    @After
    public static void cleanup() {
        driver.quit();
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
}
