package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;
import hu.ibello.search.Relation;
import hu.ibello.search.RelationType;

@Name("Interest Page")
public class InterestPage extends AbstractPage {

    @Find(by = By.CSS_SELECTOR, using = "workflow-lane")
    private WebElement workflowLane;

    @Find(by = By.CSS_SELECTOR, using = "a[href='#all-docs']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "lane-docs")
    private WebElement readItButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='#documentation-installation']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "lane-download")
    private WebElement installGuideButton;

    public void expect_workflow_lane_is_displayed() {
        expectations().expect(workflowLane).toBe().displayed();
    }

    public void click_read_it_button() {
        doWith(readItButton).click();
    }

    public void click_install_guide_button() {
        doWith(installGuideButton).click();
    }

}
