package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;

@Name("Login page")
public class LoginPage extends AbstractPage {

    private static final String url = "/clients/#login";

    @Find(by = By.CSS_SELECTOR, using = "login-lane")
    private WebElement loginLane;

    @Override
    public void I_am_on_the_page() {
        expect_url_is_$(url);
        expectations().expect(loginLane).toBe().displayed();
    }
}
