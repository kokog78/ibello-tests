package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;
import hu.ibello.search.Relation;
import hu.ibello.search.RelationType;

@Name("Ibello page")
public class IbelloPage extends AbstractPage {

    @Find(by = By.CSS_SELECTOR, using = "welcome-ibello-lane")
    private WebElement ibelloLane;

    @Find(by = By.CSS_SELECTOR, using = "a[href='order']")
    private WebElement orderButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='#ibello_technics']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "lane-welcome-ibello")
    private WebElement detailsTechnicsButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='download']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "lane-attributes")
    private WebElement downloadButton;

    public void expect_ibello_lane_is_displayed() {
        expectations().expect(ibelloLane).toBe().displayed();
    }

    public void click_order_button() {
        doWith(orderButton).click();
    }

    public void click_details_technics_button() {
        doWith(detailsTechnicsButton).click();
    }

    public void click_download_button() {
        doWith(downloadButton).click();
    }

}
