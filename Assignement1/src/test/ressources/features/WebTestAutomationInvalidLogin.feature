Feature: Invalid Login

  I am a user of marketalertum
  I try to login
  I can't login

  Scenario: Invalid Login
    Given I am a user of marketalertum
    When I login using invalid credentials
    Then I should see the login screen again

