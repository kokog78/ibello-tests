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
    private static final String urlMeetingRequest = "https://calendly.com/ibello-automation";

    // TODO túl általános h1 selector lecserélése, pl. h1[t='titles.landing-early-testing-services']
    @Find(by = By.CSS_SELECTOR, using = "h1")
    private WebElement earlyTestingTitle;

    // TODO ugyanaz mint az earlyTestingTitle esetében
    @Find(by = By.CSS_SELECTOR, using = "h1")
    private WebElement automationTestingTitle;

    // TODO ugyanaz mint az earlyTestingTitle esetében
    @Find(by = By.CSS_SELECTOR, using = "h1")
    private WebElement automationMentoringTitle;

    //the 3 landing pages first offer buttons
    @Find(by = By.CSS_SELECTOR, using = "early-testing-service-lane .convert .btn")
    private WebElement firstRequestEarlyTestingButton;

    @Find(by = By.CSS_SELECTOR, using = "test-automation-service-lane .convert .btn")
    private WebElement firstRequestAutomationTestingButton;

    @Find(by = By.CSS_SELECTOR, using = "test-automation-mentoring-lane .convert .btn")
    private WebElement firstRequestAutomationMentoringButton;

    //the last 3 buttons can be accessed the same way on the 3 landing pages
    @Find(by = By.CSS_SELECTOR, using = ".lane-quick-convert .btn")
    private WebElement secondRequestButton;

    @Find(by = By.CSS_SELECTOR, using = ".lane-convert .btn:nth-child(1)")
    private WebElements thirdAndFourthRequestButtons;

    //meeting buttons, can be used on 3 pages
    @Find(by = By.CSS_SELECTOR, using = ".lane-convert .btn:nth-child(2)")
    private WebElements meetingButtons;

    //checking the page to be landing-early-testing-services
    public void I_am_on_the_early_testing_page() {
        expect_url_is_$(urlEarlyTesting);
        expectations().expect(earlyTestingTitle).toBe().displayed();
    }

    //checking the page to be landing-test-automation-services
    public void I_am_on_the_automation_services_page(){
        expect_url_is_$(urlAutomationServices);
        expectations().expect(automationTestingTitle).toBe().displayed();
    }

    //checking the page to be landing-test-automation-mentoring
    public void I_am_on_the_automation_mentoring_page(){
        expect_url_is_$(urlAutomationMentoring);
        expectations().expect(automationMentoringTitle).toBe().displayed();
    }

    //pressing landing-early-testing-services page first offer button
    public void click_on_first_request_button_for_early_testing(){
        doWith(firstRequestEarlyTestingButton).click();
    }

    //pressing landing-early-testing-services page first offer button
    public void click_first_request_automation_testing_button(){
        doWith(firstRequestAutomationTestingButton).click();
    }

    //pressing landing-early-testing-services page first offer button
    public void click_first_request_automation_mentoring_button(){
        doWith(firstRequestAutomationMentoringButton).click();
    }

    //pressing second offer button, works for all 3 page
    public void click_second_request_button(){
        doWith(secondRequestButton).click();
    }

    //pressing third offer button, works for all 3 page
    public void click_third_request_button(){
        doWith(thirdAndFourthRequestButtons.get(0)).click();
    }

    //pressing fourth offer button, works for all 3 page
    public void click_fourth_request_button(){
        doWith(thirdAndFourthRequestButtons.get(1)).click();
    }

    //pressing the meeting buttons, works for all 3 landing pages
    public void click_first_meeting_button(){
        doWith(meetingButtons.get(0)).click();
    }

    public void click_second_meeting_button(){
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

    public void I_am_on_the_meeting_page() {
        expect_url_is_$(urlMeetingRequest);
        //expectations().expect(earlyTestingTitle).toBe().displayed();
    }
}
