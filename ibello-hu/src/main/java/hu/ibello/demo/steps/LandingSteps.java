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
    	// TODO átírni az early testing mintájára
        testing_first_request_button_for_automation_services();
        testing_second_request_button_for_automation_services();
        testing_third_request_button_for_automation_services();
        testing_fourth_request_button_for_automation_services();
    }

    public void I_test_the_request_an_offer_buttons_on_test_automation_mentoring_page(){
    	// TODO átírni az early testing mintájára
        testing_first_request_button_for_automation_mentoring();
        testing_second_request_button_for_automation_mentoring();
        testing_third_request_button_for_automation_mentoring();
        testing_fourth_request_button_for_automation_mentoring();
    }

    public void I_test_the_request_a_meeting_buttons_on_early_testing_services_page(){
    	// átírni ciklusosra
        testing_first_meeting_button_for_early_testing();
        testing_second_meeting_button_for_early_testing();
    }

    public void I_test_the_request_a_meeting_buttons_on_test_automation_services_page(){
    	// átírni ciklusosra
        testing_first_meeting_button_for_automation_services();
        testing_second_meeting_button_for_automation_services();
    }

    public void I_test_the_request_a_meeting_buttons_on_test_automation_mentoring_page(){
    	// átírni ciklusosra
        testing_first_meeting_button_for_automation_mentoring();
        testing_second_meeting_button_for_automation_mentoring();
    }

    @Internal
    @Name("I test the ${0}. request an offer button")
    public void I_test_the_$_request_an_offer_button_on_early_testing_services_page(int index) {
    	landingPage.click_on_$_request_button(index);
		quotationPage.I_am_on_the_page();
        landingPage.I_directly_return_to_early_testing_page();
        landingPage.I_am_on_the_early_testing_page();
    }
    
    // TODO megszüntetni
    @Internal
    public void testing_first_request_button_for_automation_services(){
        landingPage.click_on_first_request_button_for_automation_services();
        quotationPage.I_am_on_the_page();
        landingPage.I_directly_return_to_automation_services_page();
        landingPage.I_am_on_the_automation_services_page();
    }

    // TODO megszüntetni
    @Internal
    public void testing_second_request_button_for_automation_services(){
        landingPage.click_on_second_request_button();
        quotationPage.I_am_on_the_page();
        landingPage.I_directly_return_to_automation_services_page();
        landingPage.I_am_on_the_automation_services_page();
    }

    // TODO megszüntetni
    @Internal
    public void testing_third_request_button_for_automation_services(){
        landingPage.click_on_third_request_button();
        quotationPage.I_am_on_the_page();
        landingPage.I_directly_return_to_automation_services_page();
        landingPage.I_am_on_the_automation_services_page();
    }

    // TODO megszüntetni
    @Internal
    public void testing_fourth_request_button_for_automation_services(){
        landingPage.click_on_fourth_request_button();
        quotationPage.I_am_on_the_page();
        landingPage.I_directly_return_to_automation_services_page();
        landingPage.I_am_on_the_automation_services_page();
    }

    // TODO megszüntetni
    @Internal
    public void testing_first_request_button_for_automation_mentoring(){
        landingPage.click_on_first_request_button_for_automation_mentoring();
        quotationPage.I_am_on_the_page();
        landingPage.I_directly_return_to_automation_mentoring_page();
        landingPage.I_am_on_the_automation_mentoring_page();
    }

    // TODO megszüntetni
    @Internal
    public void testing_second_request_button_for_automation_mentoring(){
        landingPage.click_on_second_request_button();
        quotationPage.I_am_on_the_page();
        landingPage.I_directly_return_to_automation_mentoring_page();
        landingPage.I_am_on_the_automation_mentoring_page();
    }

    // TODO megszüntetni
    @Internal
    public void testing_third_request_button_for_automation_mentoring(){
        landingPage.click_on_third_request_button();
        quotationPage.I_am_on_the_page();
        landingPage.I_directly_return_to_automation_mentoring_page();
        landingPage.I_am_on_the_automation_mentoring_page();
    }

    // TODO megszüntetni
    @Internal
    public void testing_fourth_request_button_for_automation_mentoring(){
        landingPage.click_on_fourth_request_button();
        quotationPage.I_am_on_the_page();
        landingPage.I_directly_return_to_automation_mentoring_page();
        landingPage.I_am_on_the_automation_mentoring_page();
    }

    // TODO megszüntetni
    @Internal
    public void testing_first_meeting_button_for_early_testing(){
        landingPage.click_on_first_meeting_button();
        meetingPage.I_am_on_the_page();
        landingPage.I_directly_return_to_early_testing_page();
        landingPage.I_am_on_the_early_testing_page();
    }

    // TODO megszüntetni
    @Internal
    public void testing_second_meeting_button_for_early_testing(){
        landingPage.click_on_second_meeting_button();
        meetingPage.I_am_on_the_page();
        landingPage.I_directly_return_to_early_testing_page();
        landingPage.I_am_on_the_early_testing_page();
    }

    // TODO megszüntetni
    @Internal
    public void testing_first_meeting_button_for_automation_services(){
        landingPage.click_on_first_meeting_button();
        meetingPage.I_am_on_the_page();
        landingPage.I_directly_return_to_automation_services_page();
        landingPage.I_am_on_the_automation_services_page();
    }

    // TODO megszüntetni
    @Internal
    public void testing_second_meeting_button_for_automation_services(){
        landingPage.click_on_second_meeting_button();
        meetingPage.I_am_on_the_page();
        landingPage.I_directly_return_to_automation_services_page();
        landingPage.I_am_on_the_automation_services_page();
    }

    // TODO megszüntetni
    @Internal
    public void testing_first_meeting_button_for_automation_mentoring(){
        landingPage.click_on_first_meeting_button();
        meetingPage.I_am_on_the_page();
        landingPage.I_directly_return_to_automation_mentoring_page();
        landingPage.I_am_on_the_automation_mentoring_page();
    }

    // TODO megszüntetni
    @Internal
    public void testing_second_meeting_button_for_automation_mentoring(){
        landingPage.click_on_second_meeting_button();
        meetingPage.I_am_on_the_page();
        landingPage.I_directly_return_to_automation_mentoring_page();
        landingPage.I_am_on_the_automation_mentoring_page();
    }

}
