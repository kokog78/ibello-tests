package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;

@Name("Message sent page")
public class MessageSentPage extends AbstractPage {

    private static final String url = "/message-result";

    @Find(by = By.CSS_SELECTOR, using = "title-lane[key='titles.message-result']")
    private WebElement title;

    @Override
    public void I_am_on_the_page() {
        expect_url_is_$(url);
        expectations().expect(title).toBe().displayed();
    }
}
