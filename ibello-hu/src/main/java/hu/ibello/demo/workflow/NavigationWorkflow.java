package hu.ibello.demo.workflow;

import hu.ibello.core.Name;
import hu.ibello.demo.steps.NavigationSteps;
import hu.ibello.steps.StepLibrary;

@Name("navigation")
public class NavigationWorkflow extends StepLibrary{

    private NavigationSteps navigationSteps;

    public void test_init() {
        navigationSteps.I_open_the_homepage();
    }

    public void from_homepage_header_i_navigate_to_product_page() {
        navigationSteps.i_navigate_from_homepage_header_to_product_page();
    }

    public void from_homepage_header_i_navigate_to_services_page() {
        navigationSteps.i_navigate_from_homepage_header_to_services_page();
    }

    public void from_homepage_i_navigate_to_about_page() {
        navigationSteps.i_use_navbar_to_navigate_to_about_page();
    }

    public void from_homepage_i_navigate_to_documentations_page() {
        navigationSteps.i_use_navbar_to_navigate_to_documentations_page();
    }

    public void from_homepage_i_navigate_to_interest_page() {
        navigationSteps.i_use_navbar_to_navigate_to_interest_page();
    }

    public void from_homepage_i_navigate_to_product_page() {
        navigationSteps.i_use_navbar_to_navigate_to_product_page();
    }

    public void from_homepage_i_navigate_to_services_page() {
        navigationSteps.i_use_navbar_to_navigate_to_services_page();
    }

    public void from_homepage_i_navigate_to_support_page() {
        navigationSteps.i_use_navbar_to_navigate_to_support_page();
    }

    public void from_documentations_page_i_navigate_to_change_log_page() {
        navigationSteps.i_navigate_from_documentations_page_to_changelog_page();
    }

    public void from_installation_documentation_page_i_navigate_to_documentations_page() {
        navigationSteps.i_navigate_from_installation_documentation_page_to_documentations_page();
    }

    public void from_interest_page_i_navigate_to_documentations_page() {
        navigationSteps.i_navigate_from_interest_page_to_documentations_page();
    }

    public void from_interest_page_i_navigate_to_installation_documentation_page() {
        navigationSteps.i_navigate_from_interest_page_to_installation_documentation_page();
    }

    public void from_product_page_header_i_navigate_to_interest_page() {
        navigationSteps.i_navigate_from_product_page_header_to_interest_page();
    }

    public void from_product_page_i_navigate_to_order_page() {
        navigationSteps.i_navigate_from_product_page_to_order_page();
    }

    public void from_services_page_i_request_guotation() {
        navigationSteps.i_navigate_from_services_page_to_quotation_page();
    }

    public void from_support_page_header_i_navigate_to_product_page() {
        navigationSteps.i_navigate_from_support_page_header_to_product_page();
    }

    public void from_support_page_header_i_navigate_to_services_page() {
        navigationSteps.i_navigate_from_support_page_header_to_services_page();
    }

    public void from_support_page_i_navigate_to_change_log_page() {
        navigationSteps.i_navigate_from_support_page_to_changelog_page();
    }

    public void from_support_page_i_navigate_to_documentations_page() {
        navigationSteps.i_navigate_from_support_page_to_documentations_page();
    }

    public void from_support_page_i_navigate_to_installation_documentation_page() {
        navigationSteps.i_navigate_from_support_page_to_installation_documentation_page();
    }

    public void from_changelog_page_i_navigate_to_documentations_page() {
       navigationSteps.i_navigate_from_changelog_page_to_documentations_page();
    }

    public void i_am_on_about_page() {
        navigationSteps.i_am_on_about_page();
    }

    public void i_am_on_homepage() {
        navigationSteps.I_am_on_homepage();
    }

    public void i_am_on_product_page() {
        navigationSteps.i_am_on_product_page();
    }

    public void i_am_on_services_page() {
        navigationSteps.i_am_on_services_page();
    }

    public void i_am_on_support_page() {
        navigationSteps.i_am_on_support_page();
    }

    public void i_am_on_changelog_page() {
        navigationSteps.i_am_on_changelog_page();
    }

    public void i_am_on_documentations_page() {
        navigationSteps.i_am_on_documentations_page();
    }

    public void i_am_on_installation_documentation_page() {
        navigationSteps.i_am_on_installation_documentation_page();
    }

    public void i_am_on_interest_page() {
        navigationSteps.i_am_on_interest_page();
    }

    public void i_am_on_pricing_page() {
        navigationSteps.i_am_on_pricing_page();
    }

    public void i_am_on_order_page_and_no_product_is_selected() {
        navigationSteps.i_am_on_order_page();
        navigationSteps.i_see_that_no_product_is_selected();
    }

    public void i_am_on_quotation_page_without_selected_service() {
        navigationSteps.i_am_on_quotation_page();
        navigationSteps.i_see_that_test_nothing_is_selected();
    }

    public void i_navigate_directly_to_about_page_using_the_navbar() {
        navigationSteps.i_navigate_to_about_page_directly_from_navbar();
    }

    public void i_navigate_directly_to_homepage_using_the_navbar() {
        navigationSteps.i_navigate_to_homepage_directly_from_navbar();
    }

    public void i_navigate_directly_to_product_page_using_the_navbar() {
        navigationSteps.i_navigate_to_product_page_directly_from_navbar();
    }

    public void i_navigate_directly_to_services_page_using_the_navbar() {
        navigationSteps.i_navigate_to_services_page_directly_from_navbar();
    }

    public void i_navigate_directly_to_support_page_using_the_navbar() {
        navigationSteps.i_navigate_to_support_page_directly_from_navbar();
    }

}
