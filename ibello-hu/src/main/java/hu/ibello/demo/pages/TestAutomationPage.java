package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;

@Name("Test automation page")
public class TestAutomationPage extends AbstractPage {

    private static final String url = "/landing-test-automation";

    @Find(by = By.CSS_SELECTOR, using = "title-lane[key='titles.landing-test-automation']")
    private WebElement testAutomationTitle;

    @Override
    public void I_am_on_the_page() {
        expect_url_is_$(url);
        expectations().expect(testAutomationTitle).toBe().displayed();
    }
}
