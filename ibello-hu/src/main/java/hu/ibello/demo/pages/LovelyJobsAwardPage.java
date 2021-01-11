package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.demo.panel.NavigationBarPanel;
import hu.ibello.demo.steps.NavigationSteps;
import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;

@Name("Lovely Jobs Award page")
public class LovelyJobsAwardPage extends AbstractPage implements PageInterface {

    private final String url = "/szmd";
    private NavigationBarPanel navigationBarPanel;

    @Find(by = By.CSS_SELECTOR, using = "title-lane[key='pages.szmd']")
    private WebElement title;

    public void expect_title_lane_is_displayed(){
        expectations().expect(title).toBe().displayed();
    }

    public void i_am_on_the_page(){
        expect_url_is_$(url);
        expect_title_lane_is_displayed();
    }
}
