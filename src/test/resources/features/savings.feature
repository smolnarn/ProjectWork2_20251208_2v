@savings
Feature: Savings Management
  As a user
  I want to manage my savings accounts
  So that I can grow my wealth

  Background:
    Given I am logged in

  Rule: New savings account creation form functionality (US04)

    Scenario: Reset form to default state
      Given I am on the "New Saving" page
      And I fill out the form with data
      When I reset the form
      Then all fields are cleared

    Scenario: Successful account opening with valid data
      Given I am on the "New Saving" page
      When I select "Saving" from "account type" options
      And I select "Individual" from "ownership" options
      And I enter "My Savings" into "account name" field
      And I enter "100" into "initial deposit" field
      And I submit the form
      Then I see the "success" message
      And I am on the "View Saving" page

  Rule: Display created account data and transactions (US05)

    Scenario Outline: Verify new account data in the list
      Given I have successfully created a new savings account
      And I am on the "View Saving" page
      Then I see the following data on a green card:
        | Field       | Value           |
        | Account     | <Account>       |
        | Ownership   | <Ownership>     |
        | AccountNumber | <AccountNumber> |
        | InterestRate | <InterestRate> |
        | Balance     | <Balance>       |

      Examples:
   
        | Account | Ownership  | AccountNumber | InterestRate | Balance |
        | Saving  | Individual | *             | 1.85%        | $25.00  |

    Scenario: Initial deposit appears in transactions
      Given I have successfully created a new savings account
      And I am on the "View Saving" page
      Then I see the initial deposit in the transactions with the correct amount
