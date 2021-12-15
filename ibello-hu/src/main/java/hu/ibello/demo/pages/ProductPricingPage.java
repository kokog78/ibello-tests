package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;

@Name("Pricing page")
public class ProductPricingPage extends AbstractPage {

    private static final String url = "/pricing-details";

    @Find(by = By.CSS_SELECTOR, using = "attribute-details-lane")
    private WebElement detailsLane;

    @Find(by = By.CSS_SELECTOR, using = "title-lane[key='titles.pricing-details']")
    private WebElement pricingTitle;

    @Override
    public void I_am_on_the_page() {
        expect_url_is_$(url);
        expectations().expect(detailsLane).toBe().displayed();
        expectations().expect(pricingTitle).toBe().displayed();
    }
}
