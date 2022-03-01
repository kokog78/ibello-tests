package hu.ibello.demo.steps;

import hu.ibello.core.Internal;
import hu.ibello.core.Name;
import hu.ibello.demo.pages.LandingPage;
import hu.ibello.demo.pages.MeetingPage;
import hu.ibello.demo.pages.QuotationPage;
import hu.ibello.steps.StepLibrary;

@Name("Landing")
public class LandingSteps extends StepLibrary {

    private LandingPage landingPage;
    private QuotationPage quotationPage;
    private MeetingPage meetingPage;

    public void I_test_the_request_an_offer_buttons_on_early_testing_services_page() {
    	int count = landingPage.getOfferButtonsCount();
    	for (int i=0; i<count; i++) {
    		I_test_the_$_request_an_offer_button_on_early_testing_services_page(i+1);
    	}
    }
    
    public void I_test_the_request_an_offer_buttons_on_test_automation_services_page(){
        int count = landingPage.getOfferButtonsCount();
        for (int i=0; i<count; i++) {
            I_test_the_$_request_an_offer_button_on_test_automation_services_page(i+1);
        }
    }

    public void I_test_the_request_an_offer_buttons_on_test_automation_mentoring_page(){
        int count = landingPage.getOfferButtonsCount();
        for (int i=0; i<count; i++) {
            I_test_the_$_request_an_offer_button_on_test_automation_mentoring_page(i+1);
        }
    }

    public void I_test_the_request_a_meeting_buttons_on_early_testing_services_page(){
        int count = landingPage.getMeetingButtonsCount();
        for (int i=0; i<count; i++) {
            I_test_the_$_request_a_meeting_button_on_early_testing_services_page(i+1);
        }
    }

    public void I_test_the_request_a_meeting_buttons_on_test_automation_services_page(){
        int count = landingPage.getMeetingButtonsCount();
        for (int i=0; i<count; i++) {
            I_test_the_$_request_a_meeting_button_on_test_automation_services_page(i+1);
        }
    }

    public void I_test_the_request_a_meeting_buttons_on_test_automation_mentoring_page(){
        int count = landingPage.getMeetingButtonsCount();
        for (int i=0; i<count; i++) {
            I_test_the_$_request_a_meeting_button_on_test_automation_mentoring_page(i+1);
        }
    }

    @Internal
    @Name("I test the ${0}. request an offer button on early testing services page")
    public void I_test_the_$_request_an_offer_button_on_early_testing_services_page(int index) {
    	landingPage.click_on_$_request_offer_button(index);
		quotationPage.I_am_on_the_page();
        landingPage.I_directly_return_to_early_testing_page();
        landingPage.I_am_on_the_early_testing_page();
    }

    @Internal
    @Name("I test the ${0}. request an offer button on test automation services page")
    public void I_test_the_$_request_an_offer_button_on_test_automation_services_page(int index) {
        landingPage.click_on_$_request_offer_button(index);
        quotationPage.I_am_on_the_page();
        landingPage.I_directly_return_to_automation_services_page();
        landingPage.I_am_on_the_automation_services_page();
    }

    @Internal
    @Name("I test the ${0}. request an offer button on test automation mentoring page")
    public void I_test_the_$_request_an_offer_button_on_test_automation_mentoring_page(int index) {
        landingPage.click_on_$_request_offer_button(index);
        quotationPage.I_am_on_the_page();
        landingPage.I_directly_return_to_automation_mentoring_page();
        landingPage.I_am_on_the_automation_mentoring_page();
    }

    @Internal
    @Name("I test the ${0}. request a meeting button on early testing services page")
    public void I_test_the_$_request_a_meeting_button_on_early_testing_services_page(int index) {
        landingPage.click_on_$_request_meeting_button(index);
        meetingPage.I_am_on_the_page();
        landingPage.I_directly_return_to_early_testing_page();
        landingPage.I_am_on_the_early_testing_page();
    }

    @Internal
    @Name("I test the ${0}. request a meeting button on test automation services page")
    public void I_test_the_$_request_a_meeting_button_on_test_automation_services_page(int index) {
        landingPage.click_on_$_request_meeting_button(index);
        meetingPage.I_am_on_the_page();
        landingPage.I_directly_return_to_automation_services_page();
        landingPage.I_am_on_the_automation_services_page();
    }

    @Internal
    @Name("I test the ${0}. request a meeting button on test automation mentoring page")
    public void I_test_the_$_request_a_meeting_button_on_test_automation_mentoring_page(int index) {
        landingPage.click_on_$_request_meeting_button(index);
        meetingPage.I_am_on_the_page();
        landingPage.I_directly_return_to_automation_mentoring_page();
        landingPage.I_am_on_the_automation_mentoring_page();
    }

}
