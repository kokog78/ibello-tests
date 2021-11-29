package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;

@Name("Questions page")
public class QuestionsPage extends AbstractPage {

    private final String url = "/questions-manager";

    @Find(by = By.CSS_SELECTOR, using = "title-lane[key='titles.questions']")
    private WebElement questionsTitle;

    @Override
    public void I_am_on_the_page() {
        expect_url_is_$(url);
        expectations().expect(questionsTitle).toBe().displayed();
    }
}
