package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;

@Name("About page")
public class AboutPage extends AbstractPage {

    private static final String url = "/about";

    @Find(by = By.CSS_SELECTOR, using = "welcome-about-lane")
    private WebElement aboutLane;

    @Override
    public void i_am_on_the_page() {
        expect_url_is_$(url);
        expectations().expect(aboutLane).toBe().displayed();
    }
}
