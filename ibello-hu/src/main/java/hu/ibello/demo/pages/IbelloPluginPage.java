package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;

@Name("Gradle plugin page")
public class IbelloPluginPage extends AbstractPage {

    @Find(by = By.CSS_SELECTOR, using = "[id='ibello-gradle-plugin']")
    private WebElement gradlePluginId;

    @Override
    public void I_am_on_the_page() {
        expect_url_is_$("/news-ibello-gradle-plugin");
        expectations().expect(gradlePluginId).toBe().displayed();
    }
}
