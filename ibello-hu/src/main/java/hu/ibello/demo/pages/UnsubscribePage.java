package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;

@Name("Unsubscribe page")
public class UnsubscribePage extends AbstractPage {

    private static final String url = "/unsubscribe";

    @Find(by = By.CSS_SELECTOR, using = "title-lane[key='titles.unsubscribe']")
    private WebElement unsubscribeTitle;

    @Override
    public void i_am_on_the_page() {
        expect_url_is_$(url);
        expectations().expect(unsubscribeTitle).toBe().displayed();
    }
}
