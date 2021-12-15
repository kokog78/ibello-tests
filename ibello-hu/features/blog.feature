# namespace: blog
@full-test @Blog
Feature: Test the blog page

	Scenario: hungarian article looks well
		Given Blog: I am on homepage
		And Blog: The current language is hungarian
		When Blog: I go to the blogpage
		And Blog: I select a blogpost
		Then Blog: The selected post looks well
		And Blog: The recommendation is there

	Scenario: english article looks well
		Given Blog: I am on homepage
		When Blog: I change the language to english
		Then Blog: I go to the blogpage
		When Blog: I select a blogpost
		Then Blog: The selected post looks well
		And Blog: The recommendation is there
