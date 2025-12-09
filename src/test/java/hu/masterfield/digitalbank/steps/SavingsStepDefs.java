package hu.masterfield.digitalbank.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;

public class SavingsStepDefs {

    @Given("I fill out the form with data")
    public void iFillOutTheFormWithData() {
        // TODO: Implementáció
    }

    @When("I reset the form")
    public void iResetTheForm() {
        // TODO: Implementáció
    }

    @Then("all fields are cleared")
    public void allFieldsAreCleared() {
        // TODO: Implementáció
    }

    @When("I select {string} from {string} options")
    public void iSelectFromOptions(String value, String fieldName) {
        // TODO: Implementáció
    }

    @When("I enter {string} into {string} field")
    public void iEnterIntoField(String value, String fieldName) {
        // TODO: Implementáció
    }

    @Then("I see the {string} message")
    public void iSeeTheMessage(String messageType) {
        // TODO: Implementáció
    }

    @Given("I have successfully created a new savings account")
    public void iHaveSuccessfullyCreatedANewSavingsAccount() {
        // TODO: Implementáció
    }

    @Then("I see the following data on a green card:")
    public void iSeeTheFollowingDataOnAGreenCard(DataTable dataTable) {
        // TODO: Implementáció
    }

    @Then("I see the initial deposit in the transactions with the correct amount")
    public void iSeeTheInitialDepositInTheTransactionsWithTheCorrectAmount() {
        // TODO: Implementáció
    }
}

