Feature: Login and Logout
  As a user
  I want to log in and log out
  So that I can access my finances securely

  Background:
    Given I am on the login page

  Rule: System warns when fields are empty or incorrect (US01)
    
    Scenario: Unsuccessful login with incorrect password
      When I enter incorrect username "<username>" and password "<password>"
      And I submit the login form
      Then I see an error message: "Hiba Hibás belépési adatok vagy a hozzáférés nem engedélyezett a felhasználói fiók státusza, vagy létező felhasználó munkamenet miatt."
      And I remain on the login page

      Examples:
        | username | password | 
        | jsmith3  | wrongpassword |
        | wrongusername  | Demo123! |
        | jsmith3  |           |
        |           | Demo123! |
        |           |           |

  Rule: System redirects and greets after entering correct credentials (US01)

    Scenario: Successful login with valid credentials
      When I enter valid username "jsmith3" and password "Demo123!"
      And I submit the login form
      Then I am redirected to the "Áttekintés" page
      And I see a welcome message
      And the left side menu becomes available

  Rule: System logs out securely when logging out (US06)

    Scenario: Logout from menu
      Given I am logged in
      When I select the logout option
      Then I am redirected to the login page
      And I see a "Sikeres kilépés." message
      And when I reload the page, the system requires login again
