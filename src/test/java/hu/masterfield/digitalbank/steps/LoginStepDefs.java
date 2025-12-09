package hu.masterfield.digitalbank.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefs {

    @Given("I am on the {string} page")
    public void iAmOnThePage(String pageName) {
        // TODO: Implementáció
    }

    @When("I enter username {string} and password {string}")
    public void iEnterUsernameAndPassword(String username, String password) {
        // TODO: Implementáció
    }

    @When("I submit the form")
    public void iSubmitTheForm() {
        // TODO: Implementáció
    }

    @Then("I see a message: {string}")
    public void iSeeAMessage(String message) {
        // TODO: Implementáció
    }

    @Then("I am redirected to the {string} page")
    public void iAmRedirectedToThePage(String pageName) {
        // TODO: Implementáció
    }

    @Then("I see the welcome message")
    public void iSeeTheWelcomeMessage() {
        // TODO: Implementáció
    }

    @Then("I see the left side menu")
    public void iSeeTheLeftSideMenu() {
        // TODO: Implementáció
    }

    @Given("I am logged in")
    public void iAmLoggedIn() {
        // TODO: Implementáció
    }

    @When("I log out")
    public void iLogOut() {
        // TODO: Implementáció
    }

    @Then("when I reload the page, the system requires login again")
    public void whenIReloadThePageTheSystemRequiresLoginAgain() {
        // TODO: Implementáció
    }
}

