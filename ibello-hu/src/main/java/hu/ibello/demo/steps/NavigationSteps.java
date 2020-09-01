package hu.ibello.demo.steps;

import hu.ibello.core.Name;
import hu.ibello.demo.model.LanguageSelection;
import hu.ibello.demo.pages.*;
import hu.ibello.demo.panel.NavigationBarPanel;
import hu.ibello.steps.StepLibrary;

@Name("Navigation steps")
public class NavigationSteps extends StepLibrary {

    private NavigationBarPanel navigationBar;
    private HomePage homePage;
    private IbelloPage ibelloPage;
    private OrderPage orderPage;
    private ServicesPage servicesPage;
    private AboutPage aboutPage;
    private ManagerPage managerPage;
    private PricingPage pricingPage;
    private DocumentationsPage documentationsPage;
    private InterestPage interestPage;
    private SupportPage supportPage;
    private ChangelogPage changelogPage;
    private InstallationDocPage installationDocPage;
    private QuotationPage quotationPage;

    public void i_open_the_homepage() {
        homePage.i_open_homepage();
    }

    public void i_am_on_homepage() {
        String url = "/#home";
        homePage.expect_url_is_$(url);
        homePage.i_expect_main_lane_is_displayed();
        navigationBar.expect_menu_component_is_displayed();
    }

    public void select_language_based_on_$_test_data(LanguageSelection data) {
        if (data != null && data.getLanguage() != null) {
            navigationBar.click_language_link();
            switch (data.getLanguage()) {
                case HUNGARIAN:
                    navigationBar.click_hungarian_link();
                    break;
                case ENGLISH:
                    navigationBar.click_english_link();
                    break;
                default:
                    break;
            }
        }
    }

    public void i_navigate_from_homepage_to_the_order_page() {
        homePage.click_our_product_button();
        navigationBar.expect_menu_component_is_displayed();
        ibelloPage.expect_ibello_lane_is_displayed();
        ibelloPage.click_order_button();
        orderPage.expect_order_lane_is_displayed();
        navigationBar.expect_menu_component_is_displayed();
    }

    public void i_navigate_from_homepage_header_to_product_page() {
        homePage.click_our_product_button();
    }

    public void i_navigate_from_homepage_header_to_services_page() {
        homePage.click_our_services_button();
    }

    public void i_navigate_to_homepage_directly_from_navbar() {
        navigationBar.click_home_link();
    }

    public void i_am_on_order_page() {
        orderPage.expect_order_lane_is_displayed();
        navigationBar.expect_menu_component_is_displayed();
    }

    public void i_am_on_product_page() {
        String url = "/#ibello";
        ibelloPage.expect_url_is_$(url);
        ibelloPage.expect_ibello_lane_is_displayed();
        navigationBar.expect_menu_component_is_displayed();
    }

    public void i_am_on_services_page() {
        String url = "/#services";
        servicesPage.expect_url_is_$(url);
        servicesPage.expect_services_lane_is_displayed();
        navigationBar.expect_menu_component_is_displayed();
    }

    public void i_am_on_about_page() {
        String url = "/#about";
        aboutPage.expect_url_is_$(url);
        aboutPage.expect_about_lane_is_displayed();
        navigationBar.expect_menu_component_is_displayed();
    }

    public void i_am_on_manager_page() {
        String url = "#flow?id=manager";
        managerPage.expect_url_is_$(url);
        managerPage.expect_flow_lane_is_displayed();
        navigationBar.expect_menu_component_is_displayed();
    }

    public void i_am_on_pricing_page() {
        String url = "/#pricing-details";
        pricingPage.expect_url_is_$(url);
        pricingPage.expect_details_lane_is_displayed();
        navigationBar.expect_menu_component_is_displayed();
    }

    public void i_am_on_documentations_page() {
        String url = "/public/#all-docs";
        documentationsPage.expect_url_is_$(url);
        documentationsPage.expect_docs_lane_is_displayed();
        navigationBar.expect_menu_component_is_displayed();
    }

    public void i_am_on_interest_page() {
        String url = "/public/#interest";
        interestPage.expect_url_is_$(url);
        interestPage.expect_workflow_lane_is_displayed();
        navigationBar.expect_menu_component_is_displayed();
    }

    public void i_am_on_support_page() {
        String url = "/public/#support";
        supportPage.expect_url_is_$(url);
        supportPage.expect_welcome_lane_is_displayed();
        supportPage.expect_login_lane_is_displayed();
        navigationBar.expect_menu_component_is_displayed();
    }

    public void i_am_on_changelog_page() {
        String url = "/public/#documentation-changelog";
        supportPage.expect_url_is_$(url);
        changelogPage.expect_doc_lane_is_displayed();
        navigationBar.expect_menu_component_is_displayed();
    }

    public void i_am_on_installation_documentation_page() {
        String url = "/public/#documentation-installation";
        installationDocPage.expect_url_is_$(url);
        installationDocPage.expect_doc_lane_is_displayed();
        navigationBar.expect_menu_component_is_displayed();
    }

    public void i_am_on_quotation_page() {
        String url = "/public/#quotation";
        quotationPage.expect_url_is_$(url);
        quotationPage.expect_quote_services_lane_is_displayed();
        navigationBar.expect_menu_component_is_displayed();
    }

    public void i_use_navbar_to_navigate_to_about_page() {
        navigationBar.click_about_us_link();
        String url = "/#home-about";
        homePage.expect_url_is_$(url);
        homePage.click_meet_us_button();
    }

    public void i_use_navbar_to_navigate_to_documentations_page() {
        navigationBar.click_support_link();
        String url = "/#home-support";
        homePage.expect_url_is_$(url);
        homePage.click_documentations_button();
    }

    public void i_use_navbar_to_navigate_to_interest_page() {
        navigationBar.click_product_link();
        String url = "/#home-ibello";
        homePage.expect_url_is_$(url);
        homePage.click_try_it_button();
    }

    public void i_use_navbar_to_navigate_to_product_page() {
        navigationBar.click_product_link();
        String url = "/#home-ibello";
        homePage.expect_url_is_$(url);
        homePage.click_learn_more_button();
    }

    public void i_use_navbar_to_navigate_to_services_page() {
        navigationBar.click_product_link();
        String url = "/#home-services";
        homePage.expect_url_is_$(url);
        homePage.click_work_with_us_button();
    }

    public void i_use_navbar_to_navigate_to_support_page() {
        navigationBar.click_support_link();
        String url = "/#home-support";
        homePage.expect_url_is_$(url);
        homePage.click_more_options_button();
    }

    public void i_navigate_from_documentations_page_to_changelog_page() {
        documentationsPage.click_read_it_button();
    }

    public void i_navigate_from_installation_documentation_page_to_documentations_page() {
        installationDocPage.click_more_doc_button();
    }

    public void i_navigate_from_interest_page_to_documentations_page() {
        interestPage.click_read_it_button();
    }

    public void i_navigate_from_interest_page_to_installation_documentation_page() {
        interestPage.click_install_guide_button();
    }

    public void i_navigate_to_about_page_directly_from_navbar() {
        navigationBar.click_about_us_link();
    }

    public void i_navigate_to_product_page_directly_from_navbar() {
        navigationBar.click_product_link();
    }

    public void i_navigate_to_services_page_directly_from_navbar() {
        navigationBar.click_services_link();
    }

    public void i_navigate_to_support_page_directly_from_navbar() {
        navigationBar.click_support_link();
    }

    public void i_navigate_from_services_page_to_quotation_page() {
        servicesPage.click_request_button();
    }

    public void i_make_a_request_for_online_automated_testing() {
        servicesPage.open_service_with_index_$(0);
        servicesPage.click_request_online_testing_button();
    }

    public void i_make_a_request_for_automated_testing_for_applications() {
        servicesPage.open_service_with_index_$(1);
        servicesPage.click_request_automated_test_button();
    }

    public void i_make_a_request_for_test_framework_building() {
        servicesPage.open_service_with_index_$(2);
        servicesPage.click_request_test_framework_button();
    }

    public void i_make_a_request_for_consultancy() {
        servicesPage.open_service_with_index_$(3);
        servicesPage.click_request_consultancy_button();
    }

    public void i_make_a_request_for_trainings() {
        servicesPage.open_service_with_index_$(4);
        servicesPage.click_request_trainings_button();
    }

    public void i_see_that_online_automated_testing_is_selected() {
    }

    public void i_navigate_from_product_page_to_order_page() {
        ibelloPage.click_order_button();
    }

    public void i_order_a_hunter_product() {
        ibelloPage.click_order_hunter_button();
    }

    public void i_order_a_master_hunter_product() {
        ibelloPage.click_order_master_hunter_button();
    }

    public void i_order_a_sentinel_product() {
        ibelloPage.click_order_sentintel_button();
    }

    public void i_order_an_outpost_product() {
        ibelloPage.click_order_outpost_button();
    }

    public void i_see_that_no_product_is_selected() {
        for (int i = 0; i < 4; i++) {
            check_if_order_with_$_index_is_selected(i);
        }
    }

    public void i_see_that_outpost_is_selected() {
        check_if_order_with_$_index_is_selected(0);
    }

    public void i_see_that_sentinel_is_selected() {
        check_if_order_with_$_index_is_selected(1);
    }

    public void i_see_that_hunter_is_selected() {
        check_if_order_with_$_index_is_selected(2);
    }

    public void i_see_that_master_hunter_is_selected() {
        check_if_order_with_$_index_is_selected(3);
    }

    private void check_if_order_with_$_index_is_selected(int index) {
        int currentNum = Integer.parseInt(orderPage.getNumberOfProduct(index));
        if (currentNum != 0) {
            throw new AssertionError("There is product selection!");
        }
    }

    public void i_navigate_from_support_page_header_to_product_page() {
        supportPage.click_our_product_button();
    }

    public void i_navigate_from_support_page_header_to_services_page() {
        supportPage.click_our_services_button();
    }

    public void i_navigate_from_support_page_to_changelog_page() {
        supportPage.click_changelog_button();
    }

    public void i_navigate_from_support_page_to_documentations_page() {
        supportPage.click_read_it_button();
    }

    public void i_navigate_from_support_page_to_installation_documentation_page() {
        supportPage.click_installation_guide_button();
    }

    public void i_navigate_from_product_page_header_to_interest_page() {
        ibelloPage.click_details_technics_button();
        ibelloPage.click_download_button();
    }
}
