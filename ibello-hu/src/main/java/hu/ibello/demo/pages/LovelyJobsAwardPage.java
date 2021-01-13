package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.demo.panel.NavigationBarPanel;
import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;

@Name("Lovely jobs award page")
public class LovelyJobsAwardPage extends AbstractPage {

    private final String url = "/szmd";

    private NavigationBarPanel navigationBarPanel;

    @Find(by = By.CSS_SELECTOR, using = "title-lane[key='pages.szmd']")
    private WebElement szmdTitle;

    @Override
    public void i_am_on_the_page() {
        expect_url_is_$(url);
        expectations().expect(szmdTitle).toBe().displayed();
    }
}
