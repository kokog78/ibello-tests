package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.elements.WebElements;
import hu.ibello.pages.PageObject;
import hu.ibello.search.By;
import hu.ibello.search.Find;

import java.util.regex.Pattern;

@Name("Landing page")
public class LandingPage extends PageObject {

    private final String urlEarlyTesting = "/landing-early-testing-services";
    private final String urlAutomationServices = "/landing-test-automation-services";
    private final String urlAutomationMentoring = "/landing-test-automation-mentoring";
    private final String urlDirectEarlyTesting = "/landing-early-testing-services?client=test";
    private final String urlDirectAutomationServices = "/landing-test-automation-services?client=test";
    private final String urlDirectAutomationMentoring = "/landing-test-automation-mentoring?client=test";

    @Find(by = By.CSS_SELECTOR, using = "h1[t='titles.landing-early-testing-services']")
    private WebElement earlyTestingTitle;

    @Find(by = By.CSS_SELECTOR, using = "h1[t='titles.landing-test-automation-services']")
    private WebElement automationTestingTitle;

    @Find(by = By.CSS_SELECTOR, using = "h1[t='titles.landing-test-automation-mentoring']")
    private WebElement automationMentoringTitle;

    @Find(by = By.CSS_SELECTOR, using = "early-testing-service-lane .convert .btn")
    private WebElement firstRequestEarlyTestingButton;

    @Find(by = By.CSS_SELECTOR, using = "test-automation-service-lane .convert .btn")
    private WebElement firstRequestAutomationTestingButton;

    @Find(by = By.CSS_SELECTOR, using = "test-automation-mentoring-lane .convert .btn")
    private WebElement firstRequestAutomationMentoringButton;

    @Find(by = By.CSS_SELECTOR, using = ".lane-quick-convert .btn")
    private WebElement secondRequestButton;

    @Find(by = By.CSS_SELECTOR, using = ".lane-convert .btn:nth-child(1)")
    private WebElements thirdAndFourthRequestButtons;

    @Find(by = By.CSS_SELECTOR, using = ".lane-convert .btn:nth-child(2)")
    private WebElements meetingButtons;

    public void I_am_on_the_early_testing_page() {
        expect_url_is_$(urlEarlyTesting);
        expectations().expect(earlyTestingTitle).toBe().displayed();
    }

    public void I_am_on_the_automation_services_page(){
        expect_url_is_$(urlAutomationServices);
        expectations().expect(automationTestingTitle).toBe().displayed();
    }

    public void I_am_on_the_automation_mentoring_page(){
        expect_url_is_$(urlAutomationMentoring);
        expectations().expect(automationMentoringTitle).toBe().displayed();
    }

    public void click_on_first_request_button_for_early_testing(){
        doWith(firstRequestEarlyTestingButton).click();
    }

    public void click_on_first_request_button_for_automation_services(){
        doWith(firstRequestAutomationTestingButton).click();
    }

    public void click_on_first_request_button_for_automation_mentoring(){
        doWith(firstRequestAutomationMentoringButton).click();
    }

    public void click_on_second_request_button(){
        doWith(secondRequestButton).click();
    }

    public void click_on_third_request_button(){
        doWith(thirdAndFourthRequestButtons.get(0)).click();
    }

    public void click_on_fourth_request_button(){
        doWith(thirdAndFourthRequestButtons.get(1)).click();
    }

    public void click_on_first_meeting_button(){
        doWith(meetingButtons.get(0)).click();
    }

    public void click_on_second_meeting_button(){
        doWith(meetingButtons.get(1)).click();
    }

    public void I_directly_return_to_early_testing_page(){
        browser().openURL(urlDirectEarlyTesting);
    }

    public void I_directly_return_to_automation_services_page(){
        browser().openURL(urlDirectAutomationServices);
    }

    public void I_directly_return_to_automation_mentoring_page(){
        browser().openURL(urlDirectAutomationMentoring);
    }

    private void expect_url_is_$(String url) {
        Pattern pattern = Pattern.compile(url + ".*");
        expectations().assume(browser()).toHave().url(pattern);
    }

}
