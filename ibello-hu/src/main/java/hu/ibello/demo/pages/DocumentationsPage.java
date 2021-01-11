package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;
import hu.ibello.search.Relation;
import hu.ibello.search.RelationType;

@Name("Documentations page")
public class DocumentationsPage extends AbstractPage implements PageInterface {

    @Find(by = By.CSS_SELECTOR, using = "docs-lane")
    private WebElement docsLane;

    @Find(by = By.CSS_SELECTOR, using = "a[href='documentation-changelog']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "lane-docs")
    private WebElement readItButton;

    @Find(by = By.CSS_SELECTOR, using = "title-lane[key='titles.all-docs']")
    private WebElement title;

    private String url = "/all-docs";

    public void expect_docs_lane_is_displayed() {
        expectations().expect(docsLane).toBe().displayed();
    }

    public void click_read_it_button() {
        doWith(readItButton).click();
    }

    public void expect_title_lane_is_displayed() {
        expectations().expect(title).toBe().displayed();
    }

    public void i_am_on_the_page() {
        expect_url_is_$(url);
        expect_docs_lane_is_displayed();
        expect_title_lane_is_displayed();
    }
}
