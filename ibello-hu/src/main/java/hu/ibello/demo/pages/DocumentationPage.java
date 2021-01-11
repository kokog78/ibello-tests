package hu.ibello.demo.pages;

import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;

public class DocumentationPage extends AbstractPage implements PageInterface {

    @Find(by = By.CSS_SELECTOR, using = "doc-lane")
    private WebElement docLane;

    private final String url = "/documentation";

    public void i_am_on_the_page(){
        expect_url_is_$(url);
        expectations().expect(docLane).toBe().displayed();
    }
}
