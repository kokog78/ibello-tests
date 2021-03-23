package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;

@Name("Service details page")
public class ServiceDetailsPage extends AbstractPage {

    private final String url = "/service-details";

    @Find(by = By.CSS_SELECTOR, using = "title-lane[key='titles.service-details']")
    private WebElement servicesTitle;

    @Override
    public void i_am_on_the_page() {
        expect_url_is_$(url);
        expectations().expect(servicesTitle).toBe().displayed();
    }
}
