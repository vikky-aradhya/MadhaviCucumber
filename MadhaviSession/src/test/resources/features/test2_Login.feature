Feature: Login into an application

  Background: User Navigates to application
    When User opens browser

  @Login_User
  Scenario: Login
    Given test data is read from excel "Login1" and "Sheet1"
    When user clicks on Home Link
    And user enters the username
    And user enters the password
    And user clicks on signin button
    And verify the Home Page title