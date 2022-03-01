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

    private final String urlTestParameter = "?client=test";

    @Find(by = By.CSS_SELECTOR, using = "h1[t='titles.landing-early-testing-services']")
    private WebElement earlyTestingTitle;

    @Find(by = By.CSS_SELECTOR, using = "h1[t='titles.landing-test-automation-services']")
    private WebElement automationTestingTitle;

    @Find(by = By.CSS_SELECTOR, using = "h1[t='titles.landing-test-automation-mentoring']")
    private WebElement automationMentoringTitle;

    public void I_am_on_the_early_testing_page() {
        expect_url_is_$(getConfigurationValue("LandingPage.urlEarlyTesting.text").toString());
        expectations().expect(earlyTestingTitle).toBe().displayed();
    }

    public void I_am_on_the_automation_services_page(){
        expect_url_is_$(getConfigurationValue("LandingPage.urlAutomationServices.text").toString());
        expectations().expect(automationTestingTitle).toBe().displayed();
    }

    public void I_am_on_the_automation_mentoring_page(){
        expect_url_is_$(getConfigurationValue("LandingPage.urlAutomationMentoring.text").toString());
        expectations().expect(automationMentoringTitle).toBe().displayed();
    }
    
    public int getOfferButtonsCount() {
    	return requestOfferButtons().size();
    }
    
    @Name("click on ${0}. request offer button")
    public void click_on_$_request_offer_button(int index) {
    	doWith(requestOfferButtons().get(index-1)).click();
    }

    public int getMeetingButtonsCount() {
        return requestMeetingButtons().size();
    }

    @Name("click on ${0}. request meeting button")
    public void click_on_$_request_meeting_button(int index) {
        doWith(requestMeetingButtons().get(index-1)).click();
    }

    public void I_directly_return_to_early_testing_page(){
        browser().openURL(getConfigurationValue("LandingPage.urlEarlyTesting.text").toString() + urlTestParameter);
    }

    public void I_directly_return_to_automation_services_page(){
        browser().openURL(getConfigurationValue("LandingPage.urlAutomationServices.text").toString() + urlTestParameter);
    }

    public void I_directly_return_to_automation_mentoring_page(){
        browser().openURL(getConfigurationValue("LandingPage.urlAutomationMentoring.text").toString() + urlTestParameter);
    }

    private void expect_url_is_$(String url) {
        Pattern pattern = Pattern.compile(url + ".*");
        expectations().assume(browser()).toHave().url(pattern);
    }
    
    private WebElements requestOfferButtons() {
    	String text = getConfigurationValue("LandingPage.requestOfferButton.text").toString();
    	return find().using(By.BUTTON_TEXT, text).all();
    }

    private WebElements requestMeetingButtons() {
        String text = getConfigurationValue("LandingPage.requestMeetingButton.text").toString();
        return find().using(By.BUTTON_TEXT, text).all();
    }

}
