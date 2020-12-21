package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;

@Name("Pricing page")
public class PricingPage extends AbstractPage {

    @Find(by = By.CSS_SELECTOR, using = "attribute-details-lane")
    private WebElement detailsLane;

    public void expect_details_lane_is_displayed() {
        expectations().expect(detailsLane).toBe().displayed();
    }

}
