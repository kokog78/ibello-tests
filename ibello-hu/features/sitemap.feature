# namespace: Sitemap
@full-test @sitemap
Feature: Sitemap

	@verify
	Scenario: Verify all links
		When Sitemap: i open sitemap page
		Then Sitemap: i verify links
