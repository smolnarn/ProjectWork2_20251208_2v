Feature: Savings Management
  As a user
  I want to manage my savings accounts
  So that I can grow my wealth

  Background:
    Given I am logged in

  Rule: New savings account creation form functionality (US04)

    Scenario: Reset form to default state
      Given I am on the "Új megtakarítási számla létrehozása" page
      And I fill out the form with data
      When I reset the form
      Then all fields are cleared

    Scenario: Successful account opening with valid data
      Given I am on the "Új megtakarítási számla létrehozása" page
      When I select the "Megtakarítások" account type
      And I select "Egyéni" ownership
      And I enter an account name
      And I enter a valid initial deposit amount
      And I submit the form
      Then I see a success message
      And I am redirected to the "Megtakarítási számlák megtekintése" page

  Rule: Display created account data and transactions (US05)

    Scenario Outline: Verify new account data in the list
      Given I have successfully created a new savings account
      When I am on the "Megtakarítási számlák megtekintése" page
      Then I see the following data on a green card:
        | Field       | Value           |
        | Account     | <Account>       |
        | Ownership   | <Ownership>     |
        | AccountNumber | <AccountNumber> |
        | InterestRate | <InterestRate> |
        | Balance     | <Balance>       |

      Examples:
   
        | Account        | Ownership | AccountNumber | InterestRate | Balance |
        | Megtakarítások | Egyéni    | 486130016     | 1.85%        | $25.00  |

    Scenario: Initial deposit appears in transactions
      Given I have successfully created a new savings account
      When I am on the "Megtakarítási számlák megtekintése" page
      Then I see the initial deposit in the transactions with the correct amount
