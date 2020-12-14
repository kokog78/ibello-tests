package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;

@Name("Manager Page")
public class ManagerPage extends AbstractPage {

    @Find(by = By.CSS_SELECTOR, using = "flow-lane")
    private WebElement flowLane;

    public void expect_flow_lane_is_displayed() {
        expectations().expect(flowLane).toBe().displayed();
    }

}
