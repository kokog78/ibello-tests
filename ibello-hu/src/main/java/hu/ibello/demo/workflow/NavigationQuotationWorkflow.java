package hu.ibello.demo.workflow;

import hu.ibello.core.Name;
import hu.ibello.demo.steps.NavigationSteps;
import hu.ibello.steps.StepLibrary;

@Name("navigation quotation")
public class NavigationQuotationWorkflow extends StepLibrary{

    private NavigationSteps navigationSteps;

    public void test_init() {
        navigationSteps.I_open_the_homepage();
    }

    public void from_homepage_i_navigate_to_services_page() {
        navigationSteps.i_use_navbar_to_navigate_to_services_page();
    }

    public void i_am_on_homepage() {
        navigationSteps.I_am_on_homepage();
    }

    public void i_am_on_services_page() {
        navigationSteps.i_am_on_services_page();
    }

    public void i_am_on_quotation_page_and_automated_tests_is_selected() {
        navigationSteps.i_am_on_quotation_page();
        navigationSteps.i_see_that_automated_test_for_apps_is_selected();
    }

    public void i_am_on_quotation_page_and_consultancy_is_selected() {
        navigationSteps.i_am_on_quotation_page();
        navigationSteps.i_see_that_consultancy_is_selected();
    }

    public void i_am_on_quotation_page_and_dev_and_test_training_is_selected() {
        navigationSteps.i_am_on_quotation_page();
        navigationSteps.i_see_that_training_is_selected();
    }

    public void i_am_on_quotation_page_and_online_automated_test_is_selected() {
        navigationSteps.i_am_on_quotation_page();
        navigationSteps.i_see_that_online_automated_testing_is_selected();
    }

    public void i_am_on_quotation_page_and_test_framework_is_selected() {
        navigationSteps.i_am_on_quotation_page();
        navigationSteps.i_see_that_test_framework_is_selected();
    }

    public void i_navigate_directly_to_services_page_using_the_navbar() {
        navigationSteps.i_navigate_to_services_page_directly_from_navbar();
    }

    public void i_request_quotation_for_automated_tests() {
        navigationSteps.i_make_a_request_for_automated_testing_for_applications();
    }

    public void i_request_quotation_for_consultancy() {
        navigationSteps.i_make_a_request_for_consultancy();
    }

    public void i_request_quotation_for_dev_and_test_training() {
        navigationSteps.i_make_a_request_for_trainings();
    }

    public void i_request_quotation_for_online_automated_test() {
        navigationSteps.i_make_a_request_for_online_automated_testing();
    }

    public void i_request_quotation_for_test_framework() {
        navigationSteps.i_make_a_request_for_test_framework_building();
    }

}
