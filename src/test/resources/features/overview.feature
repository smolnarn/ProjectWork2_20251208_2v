Feature: Financial Overview
  As a user
  I want to see my financial charts
  So that I can understand my financial situation

  Rule: Display charts on the main page (US03)
    
    Scenario: Verify charts on Overview page
      Given I am logged in
      And I am on the "Áttekintés" page
      Then I see the account balance summary chart
      And I see the chart showing deposits and withdrawals for the last three months
