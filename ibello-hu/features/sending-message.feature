@negative
Feature: Decision table for sending a message test scenarios

	Background: Loading the valid test data
		Given i load the valid test data

	Scenario: Sending message with invalid name
		Given i want to send a new message
		When the name will be invalid
		When i send the message
		Then i see that the there is an error message

	Scenario: Sending message with invalid email
		Given i want to send a new message
		When the email will be invalid
		When i send the message
		Then i see that the there is an error message

	Scenario: Sending message with invalid subject
		Given i want to send a new message
		When the subject will be invalid
		When i send the message
		Then i see that the there is an error message

	Scenario: Sending message with invalid massage
		Given i want to send a new message
		When the message will be invalid
		When i send the message
		Then i see that the there is an error message
