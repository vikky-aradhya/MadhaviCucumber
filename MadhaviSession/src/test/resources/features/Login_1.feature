Feature: Login into an application

  Background: User Navigates to application
    When User opens browser
    
  @Login_user_outline
  Scenario Outline: Login to app
    And user enters the username as "<username>"
    And user enters the password as "<password>"
    And user clicks on signin button
    And verify the Home Page title

    Examples: 
      | username | password |
      | mercury  | mercury  |
      | java     | java     |