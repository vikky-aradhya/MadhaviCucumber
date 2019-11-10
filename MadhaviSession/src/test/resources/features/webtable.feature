Feature: webtable validate

  Background: User Navigates to application
    When User opens browser

  @webtable
  Scenario: webtable check
    Given test data is read from excel "webtable" and "WebTable"
    And user enters the company
    And user enters the group