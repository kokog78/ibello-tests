# namespace: Language
@full-test @language
Feature: Test for changing language

	Scenario: Language selection
		Given Language: i am on homepage
		And Language: the current language is the default
		When Language: i select the language
		Then Language: language is changed
		When Language: i change the language back to default
		Then Language: the current language is the default
