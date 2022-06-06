# namespace: Product development
@full-test @prodev
Feature: Test the product development page

	Scenario: Version numbers are same for both languages
		Given Product development: I am on product development page
		When Product development: I compare the version numbers
		Then Product development: The version numbers are the same

	Scenario: Version release dates are same for both languages
		Given Product development: I am on product development page
		When Product development: I compare the release dates
		Then Product development: The release dates are the same

	Scenario: Version changes are described
		Given Product development: I am on product development page
		When Product development: I check the version change descriptions
		Then Product development: The version changes are described

	Scenario: Ordering of version changes is the same for both languages
		Given Product development: I am on product development page
		When Product development: I compare the ordering of version changes
		Then Product development: The ordering of version changes is the same
