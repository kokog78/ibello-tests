package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;

@Name("Pricing page")
public class ProductPricingPage extends AbstractPage implements PageInterface{

    private static final String url = "/pricing-details";

    @Find(by = By.CSS_SELECTOR, using = "attribute-details-lane")
    private WebElement detailsLane;

    @Find(by = By.CSS_SELECTOR, using = "title-lane[key='titles.pricing-details']")
    private WebElement title;

    public void expect_details_lane_is_displayed() {
        expectations().expect(detailsLane).toBe().displayed();
    }

    public void expect_pricing_details_lane_is_displayed() {
        expectations().expect(title).toBe().displayed();
    }

    public void i_am_on_the_page() {
        expect_url_is_$(url);
        expect_details_lane_is_displayed();
        expect_pricing_details_lane_is_displayed();
    }
}
