# namespace: product development
@full-test @prodev
Feature: Test the product development page

	Scenario: Version numbers are same on both language
		Given Product development: I am on product development page
		When Product development: I compare the version numbers
		Then Product development: The version numbers are the same

	Scenario: Version release dates are same on both language
		Given Product development: I am on product development page
		When Product development: I compare the release dates
		Then Product development: The version dates are the same

	Scenario: Version changes are described
		Given Product development: I am on product development page
		When Product development: I check the version changes descriptions
		Then Product development: The version changes are described

	Scenario: Version changes order are same on both language
		Given Product development: I am on product development page
		When Product development: I compare the version changes order
		Then Product development: The version changes order are the same
