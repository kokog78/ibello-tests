package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;

@Name("Login page")
public class LoginPage extends AbstractPage implements PageInterface{

    private static final String url = "/clients/#login";

    @Find(by = By.CSS_SELECTOR, using = "login-lane")
    private WebElement loginLane;


    public void expect_login_lane_is_displayed() {
        expectations().expect(loginLane).toBe().displayed();
    }

    public void i_am_on_the_page() {
        expect_url_is_$(url);
        expect_login_lane_is_displayed();
    }
}
