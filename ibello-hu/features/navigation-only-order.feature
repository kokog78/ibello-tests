# namespace: navigation order
@full-test @navigation @nav-order
Feature: Testing navigation to different order pages of products

	Scenario: Testing navigation to different order pages of products #1
		Given navigation order: test init
		And navigation order: i am on homepage
		When navigation order: from home page i order a server product
		Then navigation order: i am on order page and server is selected
		When navigation order: i navigate back to homepage
		And navigation order: from home page i order an analyzer product
		Then navigation order: i am on order page and analyzer is selected
		When navigation order: i navigate back to homepage
		And navigation order: from home page i order a creator product
		Then navigation order: i am on order page and creator is selected
		When navigation order: i navigate back to homepage
		And navigation order: from home page i order a team product
		Then navigation order: i am on order page and team 10 is selected
		When navigation order: i navigate back to homepage
