# namespace: product development
@full-test @prodev
Feature: Test the product development page

	Scenario: Version numbers are same on both language
		Given Product development: I am on homepage
		When Product development: I navigate to product development page
		Then Product development: The version numbers are the same

    Scenario: Version release dates are same on both language
        Given Product development: I am on homepage
        When Product development: I navigate to product development page
        Then Product development: The version dates are the same

    Scenario: Version changes are described
        Given Product development: I am on homepage
        When Product development: I navigate to product development page
        Then Product development: The version changes are described

    Scenario: Version changes order are same on both language
        Given Product development: I am on homepage
        When Product development: I navigate to product development page
        Then Product development: The version changes order are the same
