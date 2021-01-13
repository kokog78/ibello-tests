package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;

@Name("Changes Page")
public class ChangesPage extends AbstractPage {

    private final String url = "/changes";

    @Find(by = By.CSS_SELECTOR, using = "title-lane[key='titles.changes']")
    private WebElement changesTitle;

    @Override
    public void i_am_on_the_page() {
        expect_url_is_$(url);
        expectations().expect(changesTitle).toBe().displayed();
    }
}
