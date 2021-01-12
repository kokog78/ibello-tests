package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;

@Name("Gradle plugin page")
public class IbelloPluginPage extends AbstractPage implements PageInterface {

    @Find(by = By.CSS_SELECTOR, using = "[id='ibello-gradle-plugin']")
    private WebElement id;

    public void expect_ibello_gradle_plugin_lane_is_displayed() {
        expectations().expect(id).toBe().displayed();
    }


    public void i_am_on_the_page() {
        expect_url_is_$("/news-ibello-gradle-plugin");
        expect_ibello_gradle_plugin_lane_is_displayed();
    }
}
