package hu.ibello.demo.pages;

import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;

public class MeetingPage extends AbstractPage{

    private static final String url = "https://calendly.com/ibello-automation";

    @Find(by = By.CSS_SELECTOR, using = "img[src$='467994bf.jpg'")
    private WebElement portraitImage;

    @Override
    public void I_am_on_the_page(){
        expect_url_is_$(url);
        expectations().expect(portraitImage).toBe().displayed();
    }
}
