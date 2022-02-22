package hu.ibello.demo.workflow;

import hu.ibello.core.Name;
import hu.ibello.demo.steps.LandingSteps;
import hu.ibello.demo.steps.NavigationSteps;
import hu.ibello.steps.StepLibrary;

@Name("Landing accessibility")
public class LandingAccessibilityWorkflow extends StepLibrary {

    private NavigationSteps navigationSteps;
    private LandingSteps landingSteps;

    public void I_open_the_homepage() {
        navigationSteps.I_open_the_homepage();
    }

    public void From_homepage_i_navigate_to_services_page() {
        navigationSteps.i_navigate_from_homepage_header_to_services_page();
    }

    // TODO felesleges kommentek törlése minden érintett osztályból
    //navigation from sevices page to early testing services page
    public void From_services_page_i_navigate_to_early_testing_services_page() {
        navigationSteps.I_navigate_from_services_page_to_early_testing_services_page();
    }

    //navigation from sevices page to automation services page
    public void From_services_page_i_navigate_to_test_automation_services_page() {
        navigationSteps.I_navigate_from_services_page_to_test_automation_services_page();
    }

    //navigation from sevices page to automation mentoring page
    public void From_services_page_i_navigate_to_test_automation_mentoring_page() {
        navigationSteps.I_navigate_from_services_page_to_test_automation_mentoring_page();
    }

    public void I_test_the_request_an_offer_buttons_on_early_testing_services_page() {
        landingSteps.I_test_the_request_an_offer_buttons_on_early_testing_services_page();
    }

    public void I_test_the_request_a_meeting_buttons_on_early_testing_services_page() {
        landingSteps.I_test_the_request_a_meeting_buttons_on_early_testing_services_page();
    }

    public void I_test_the_request_an_offer_buttons_on_test_automation_services_page() {
        landingSteps.I_test_the_request_an_offer_buttons_on_test_automation_services_page();
    }

    public void I_test_the_request_a_meeting_buttons_on_test_automation_services_page() {
        landingSteps.I_test_the_request_a_meeting_buttons_on_test_automation_services_page();
    }

    public void I_test_the_request_an_offer_buttons_on_test_automation_mentoring_page() {
        landingSteps.I_test_the_request_an_offer_buttons_on_test_automation_mentoring_page();
    }

    public void I_test_the_request_a_meeting_buttons_on_test_automation_mentoring_page() {
        landingSteps.I_test_the_request_a_meeting_buttons_on_test_automation_mentoring_page();
    }

}
