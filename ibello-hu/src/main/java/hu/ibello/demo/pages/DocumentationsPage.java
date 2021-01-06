package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;
import hu.ibello.search.Relation;
import hu.ibello.search.RelationType;

@Name("Documentations page")
public class DocumentationsPage extends AbstractPage {

    @Find(by = By.CSS_SELECTOR, using = "docs-lane")
    private WebElement docsLane;

    @Find(by = By.CSS_SELECTOR, using = "a[href='documentation-changelog']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "lane-docs")
    private WebElement readItButton;

    public void expect_docs_lane_is_displayed() {
        expectations().expect(docsLane).toBe().displayed();
    }

    public void click_read_it_button() {
        doWith(readItButton).click();
    }

}
