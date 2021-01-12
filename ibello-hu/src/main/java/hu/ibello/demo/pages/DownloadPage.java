package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;
import hu.ibello.search.Relation;
import hu.ibello.search.RelationType;

@Name("Download page")
public class DownloadPage extends AbstractPage implements PageInterface {

    @Find(by = By.CSS_SELECTOR, using = "workflow-lane")
    private WebElement workflowLane;

    @Find(by = By.CSS_SELECTOR, using = "a[href='#all-docs']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "lane-docs")
    private WebElement readItButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='documentation-installation']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "lane-download")
    private WebElement installGuideButton;

    @Find(by = By.CSS_SELECTOR, using = "title-lane[key='titles.download']")
    private WebElement title;

    private final String url = "/download";


    public void expect_workflow_lane_is_displayed() {
        expectations().expect(workflowLane).toBe().displayed();
    }

    public void click_read_it_button() {
        doWith(readItButton).click();
    }

    public void click_install_guide_button() {
        doWith(installGuideButton).click();
    }

    public void expect_title_lane_is_displayed() {
        expectations().expect(title).toBe().displayed();
    }

    public void i_am_on_the_page() {
        expect_url_is_$(url);
        expect_workflow_lane_is_displayed();
        expect_title_lane_is_displayed();
    }
}
