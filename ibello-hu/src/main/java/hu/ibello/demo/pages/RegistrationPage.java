package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;

@Name("Registration page")
public class RegistrationPage extends AbstractPage {

    private static final String url = "/clients/#registration";

    @Find(by = By.CSS_SELECTOR, using = "registration-lane")
    private WebElement registrationLane;

    @Override
    public void I_am_on_the_page() {
        expect_url_is_$(url);
        expectations().expect(registrationLane).toBe().displayed();
    }
}
