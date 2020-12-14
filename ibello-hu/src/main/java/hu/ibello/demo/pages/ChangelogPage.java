package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;
import hu.ibello.search.Relation;
import hu.ibello.search.RelationType;

@Name("Changelog Page")
public class ChangelogPage extends AbstractPage {

    @Find(by = By.CSS_SELECTOR, using = "doc-lane")
    private WebElement docLane;

    @Find(by = By.CSS_SELECTOR, using = "a[href='#all-docs']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "lane-doc-footer")
    private WebElement moreDocumentationButton;

    public void expect_doc_lane_is_displayed() {
        expectations().expect(docLane).toBe().displayed();
    }
    public void click_more_documentation_button() {
        doWith(moreDocumentationButton).click();
    }

}
