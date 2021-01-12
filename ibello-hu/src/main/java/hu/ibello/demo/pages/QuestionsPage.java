package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;

@Name("Questions Page")
public class QuestionsPage extends AbstractPage implements PageInterface{

    private final String url = "/questions-manager";

    @Find(by = By.CSS_SELECTOR, using = "title-lane[key='titles.questions']")
    private WebElement questionsTitle;

    public void expect_questions_title_lane_is_displayed() {
        expectations().expect(questionsTitle).toBe().displayed();
    }

    public void i_am_on_the_page() {
        expect_url_is_$(url);
        expect_questions_title_lane_is_displayed();
    }
}
