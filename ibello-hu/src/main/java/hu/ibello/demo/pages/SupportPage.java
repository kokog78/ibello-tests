package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;
import hu.ibello.search.Relation;
import hu.ibello.search.RelationType;

@Name("Support page")
public class SupportPage extends AbstractPage {
    private static final String url = "/support";

    @Find(by = By.CSS_SELECTOR, using = "welcome-main-lane")
    private WebElement welcomeLane;

    @Find(by = By.CSS_SELECTOR, using = "login-lane")
    private WebElement loginLane;

    @Find(by = By.CSS_SELECTOR, using = "a[href='ibello']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "lane-welcome-main")
    private WebElement ourProductButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='services']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "lane-welcome-main")
    private WebElement ourServicesButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='documentation-changelog']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "lane-changes")
    private WebElement changelogButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='documentation-installation']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "lane-download")
    private WebElement installationGuideButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='all-docs']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "lane-docs")
    private WebElement readItButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='changes']")
    private WebElement earlierDevelopmentsButton;

    @Override
    public void I_am_on_the_page() {
        expect_url_is_$(url);
        expectations().expect(welcomeLane).toBe().displayed();
        expectations().expect(loginLane).toBe().displayed();
    }

    public void click_on_earlier_developments_button() {
        doWith(earlierDevelopmentsButton).click();
    }

    public void click_our_product_button() {
        doWith(ourProductButton).click();
    }

    public void click_our_services_button() {
        doWith(ourServicesButton).click();
    }

    public void click_changelog_button() {
        doWith(changelogButton).click();
    }

    public void click_installation_guide_button() {
        doWith(installationGuideButton).click();
    }

    public void click_read_it_button() {
        doWith(readItButton).click();
    }
}
