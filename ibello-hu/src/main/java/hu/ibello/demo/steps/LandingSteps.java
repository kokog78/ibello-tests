package hu.ibello.demo.steps;

import hu.ibello.core.Internal;
import hu.ibello.core.Name;
import hu.ibello.demo.pages.LandingPage;
import hu.ibello.demo.pages.QuotationPage;
import hu.ibello.steps.StepLibrary;

@Name("Landing")
public class LandingSteps extends StepLibrary {

    private LandingPage landingPage;
    private QuotationPage quotationPage;

    // TODO egy új oldal-leíró használata a külsős (meeting) oldalhoz. Leszármazhatsz az AbstractPage osztályból
    // TODO Egyedi gombnyomásért felelős metódusok átnevezése pl.: click_on_first_request_button_for_early_testing
    //  és a különböző gombok tesztelését kiszervezni külön @Internal metódusokba, ezeket majd az osztály végére rakd

    public void I_test_the_request_an_offer_buttons_on_early_testing_services_page(){
        testing_first_request_button_for_early_testing();
        landingPage.click_second_request_button();
        quotationPage.I_am_on_the_page();
        landingPage.I_directly_return_to_early_testing_page();
        landingPage.I_am_on_the_early_testing_page();
        landingPage.click_third_request_button();
        quotationPage.I_am_on_the_page();
        landingPage.I_directly_return_to_early_testing_page();
        landingPage.I_am_on_the_early_testing_page();
        landingPage.click_fourth_request_button();
        quotationPage.I_am_on_the_page();
        landingPage.I_directly_return_to_early_testing_page();
        landingPage.I_am_on_the_early_testing_page();
    }

    public void I_test_the_request_an_offer_buttons_on_test_automation_services_page(){
        landingPage.click_first_request_automation_testing_button();
        quotationPage.I_am_on_the_page();
        landingPage.I_directly_return_to_automation_services_page();
        landingPage.I_am_on_the_automation_services_page();
        landingPage.click_second_request_button();
        quotationPage.I_am_on_the_page();
        landingPage.I_directly_return_to_automation_services_page();
        landingPage.I_am_on_the_automation_services_page();
        landingPage.click_third_request_button();
        quotationPage.I_am_on_the_page();
        landingPage.I_directly_return_to_automation_services_page();
        landingPage.I_am_on_the_automation_services_page();
        landingPage.click_fourth_request_button();
        quotationPage.I_am_on_the_page();
        landingPage.I_directly_return_to_automation_services_page();
        landingPage.I_am_on_the_automation_services_page();
    }

    public void I_test_the_request_an_offer_buttons_on_test_automation_mentoring_page(){
        landingPage.click_first_request_automation_mentoring_button();
        quotationPage.I_am_on_the_page();
        landingPage.I_directly_return_to_automation_mentoring_page();
        landingPage.I_am_on_the_automation_mentoring_page();
        landingPage.click_second_request_button();
        quotationPage.I_am_on_the_page();
        landingPage.I_directly_return_to_automation_mentoring_page();
        landingPage.I_am_on_the_automation_mentoring_page();
        landingPage.click_third_request_button();
        quotationPage.I_am_on_the_page();
        landingPage.I_directly_return_to_automation_mentoring_page();
        landingPage.I_am_on_the_automation_mentoring_page();
        landingPage.click_fourth_request_button();
        quotationPage.I_am_on_the_page();
        landingPage.I_directly_return_to_automation_mentoring_page();
        landingPage.I_am_on_the_automation_mentoring_page();
    }

    public void I_test_the_request_a_meeting_buttons_on_early_testing_services_page(){
        landingPage.click_first_meeting_button();
        landingPage.I_am_on_the_meeting_page();
        landingPage.I_directly_return_to_early_testing_page();
        landingPage.I_am_on_the_early_testing_page();
        landingPage.click_second_meeting_button();
        landingPage.I_am_on_the_meeting_page();
        landingPage.I_directly_return_to_early_testing_page();
        landingPage.I_am_on_the_early_testing_page();
    }

    public void I_test_the_request_a_meeting_buttons_on_test_automation_services_page(){
        landingPage.click_first_meeting_button();
        landingPage.I_am_on_the_meeting_page();
        landingPage.I_directly_return_to_automation_services_page();
        landingPage.I_am_on_the_automation_services_page();
        landingPage.click_second_meeting_button();
        landingPage.I_am_on_the_meeting_page();
        landingPage.I_directly_return_to_automation_services_page();
        landingPage.I_am_on_the_automation_services_page();
    }

    public void I_test_the_request_a_meeting_buttons_on_test_automation_mentoring_page(){
        landingPage.click_first_meeting_button();
        landingPage.I_am_on_the_meeting_page();
        landingPage.I_directly_return_to_automation_mentoring_page();
        landingPage.I_am_on_the_automation_mentoring_page();
        landingPage.click_second_meeting_button();
        landingPage.I_am_on_the_meeting_page();
        landingPage.I_directly_return_to_automation_mentoring_page();
        landingPage.I_am_on_the_automation_mentoring_page();
    }

    @Internal
    public void testing_first_request_button_for_early_testing() {
        landingPage.click_on_first_request_button_for_early_testing();
        quotationPage.I_am_on_the_page();
        landingPage.I_directly_return_to_early_testing_page();
        landingPage.I_am_on_the_early_testing_page();
    }

}
