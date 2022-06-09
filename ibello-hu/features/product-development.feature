# namespace: Product development
@full-test @prodev
Feature: Test the product development page

	Scenario: Version numbers are same for all languages
		Given Product development: I am on product development page
		When Product development: I collect the version numbers
		Then Product development: The version numbers are the same

	Scenario: Version dates are same for all languages
		Given Product development: I am on product development page
		When Product development: I collect the version dates
		Then Product development: The version dates are the same

	Scenario: Version changes are described
		Given Product development: I am on product development page
		When Product development: I collect the version descriptions
		Then Product development: The version descriptions are filled

	Scenario: Ordering of version changes is the same for all languages
		Given Product development: I am on product development page
		When Product development: I collect the version changes
		Then Product development: The ordering of version changes is the same
