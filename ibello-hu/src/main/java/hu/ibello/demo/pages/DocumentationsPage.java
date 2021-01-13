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

    @Find(by = By.CSS_SELECTOR, using = "title-lane[key='titles.all-docs']")
    private WebElement docsTitle;

    private String url = "/all-docs";

    @Override
    public void i_am_on_the_page() {
        expect_url_is_$(url);
        expectations().expect(docsLane).toBe().displayed();
        expectations().expect(docsTitle).toBe().displayed();
    }

    public void click_read_it_button() {
        doWith(readItButton).click();
    }
}
