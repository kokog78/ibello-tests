package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;
import hu.ibello.search.Relation;
import hu.ibello.search.RelationType;

@Name("Changelog page")
public class ChangelogPage extends AbstractPage {

    private static final String url = "documentation-changelog";

    @Find(by = By.CSS_SELECTOR, using = "doc-lane")
    private WebElement docLane;

    @Find(by = By.CSS_SELECTOR, using = "a[href='all-docs']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "lane-doc-footer")
    private WebElement moreDocumentationButton;

    @Override
    public void I_am_on_the_page() {
        expect_url_is_$(url);
        expectations().expect(docLane).toBe().displayed();
    }

    public void click_more_documentation_button() {
        doWith(moreDocumentationButton).click();
    }
}
