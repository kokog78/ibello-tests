package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;

@Name("Order result page")
public class OrderResultPage extends AbstractPage {

    private static final String url = "/order-result";

    @Find(by = By.CSS_SELECTOR, using = "title-lane[key='titles.order-result']")
    private WebElement title;

    @Override
    public void I_am_on_the_page() {
        expect_url_is_$(url);
        expectations().expect(title).toBe().displayed();
    }
}
