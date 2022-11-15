Feature: Valid login

  In order to help me to manage my alerts
  As a user of marketalertum
  I want to be able to see my alerts

  Scenario: Simple login
    Given I am a user of marketalertum
    When I login using valid credentials
    Then I should see my alerts
