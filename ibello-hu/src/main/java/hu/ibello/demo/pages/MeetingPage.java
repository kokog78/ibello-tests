package hu.ibello.demo.pages;

import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;

public class MeetingPage extends AbstractPage{

    private static final String url = "https://calendly.com/ibello-automation";

    @Find(by = By.CSS_SELECTOR, using = "img[alt='Avatar']")
	private WebElement calendlyProfileImage;

	@Find(by = By.TEXT, using = "${MeetingPage.calendlyProfileName.text}")
	private WebElement calendlyProfileName;

    @Override
    public void I_am_on_the_page(){
        expect_url_is_$(url);
        expectations().expect(calendlyProfileImage).toBe().displayed();
        expectations().expect(calendlyProfileName).toBe().displayed();
    }
}
