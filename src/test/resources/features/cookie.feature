Feature: Cookie Banner Management
  As a user
  I want to be notified about cookie usage
  So that my privacy is protected

  Rule: Cookie banner appears in new browser session (US02)

    Scenario: Cookie banner appears in new session
      Given I start a new browser session
      When I open the test site
      Then I see the cookie banner

    Scenario: Accept cookie banner
      Given I start a new browser session
      And I open the test site
      And I see the cookie banner
      When I accept the cookies
      Then the cookie banner disappears

