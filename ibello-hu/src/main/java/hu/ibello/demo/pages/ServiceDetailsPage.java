package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;

@Name("Service details page")
public class ServiceDetailsPage extends AbstractPage implements PageInterface{

    @Find(by = By.CSS_SELECTOR, using = "title-lane[key='titles.service-details']")
    private WebElement title;

    private final String url = "/service-details";

    public void expect_title_lane_is_displayed() {
        expectations().expect(title).toBe().displayed();
    }

    public void i_am_on_the_page() {
        expect_url_is_$(url);
        expect_title_lane_is_displayed();
    }
}
