package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;

@Name("Unsubscribe page")
public class UnsubscribePage extends AbstractPage implements PageInterface {
    private static final String url = "/unsubscribe";

    @Find(by = By.CSS_SELECTOR, using = "title-lane[key='titles.unsubscribe']")
    private WebElement title;

    public void expect_unsubscribe_title_lane_is_displayed() {
        expectations().expect(title).toBe().displayed();
    }

    public void i_am_on_the_page() {
        expect_url_is_$(url);
        expect_unsubscribe_title_lane_is_displayed();
    }
}
