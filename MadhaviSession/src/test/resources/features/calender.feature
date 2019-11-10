Feature: calender picker

Background: User Navigates to application
    When User opens browser

  @calender
  Scenario: calender Date and Time Picker
    Given test data is read from excel "datepicker" and "Calender"
    And user picks date and time