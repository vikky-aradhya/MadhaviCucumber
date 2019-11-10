Feature: Register into an application

	Background: User Navigates to application
	When User opens browser
	
	@Register_user
	Scenario: Register
	Given test data is read from excel "Register" and "Sheet2"
	Then user clicks on Register button
	And user enters Contact Information
	And user enters Mailing Information
	And user enters User Information
	Then user clicks on submit
	And verify the Register Page title