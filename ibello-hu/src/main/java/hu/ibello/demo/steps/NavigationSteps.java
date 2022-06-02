package hu.ibello.demo.steps;

import hu.ibello.core.Name;
import hu.ibello.demo.pages.*;
import hu.ibello.demo.panel.NavigationBarPanel;
import hu.ibello.steps.StepLibrary;

@Name("Navigation steps")
public class NavigationSteps extends StepLibrary {

    private NavigationBarPanel navigationBar;
    private HomePage homePage;
    private ProductPage productPage;
    private OrderPage orderPage;
    private ServicesPage servicesPage;
    private AboutPage aboutPage;
    private ProductPricingPage productPricingPage;
    private DocumentationsPage documentationsPage;
    private DownloadPage downloadPage;
    private SupportPage supportPage;
    private ChangelogPage changelogPage;
    private InstallationDocPage installationDocPage;
    private QuotationPage quotationPage;
    private LovelyJobsAwardPage lovelyJobsAwardPage;
    private QuestionsPage questionsPage;
    private ChangesPage changesPage;
    private IbelloPluginPage ibelloPluginPage;
    private ServiceDetailsPage serviceDetailsPage;
    private TestAutomationPage testAutomationPage;
    private UnsubscribePage unsubscribePage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private BlogPage blogpage;
    private LandingPage landingPage;
    private static final String homeSupportUrl = "home-support";
    private static final String homeServicesUrl = "home-services";
    private static final String homeIbelloUrl = "home-ibello";
    private static final String homeAboutUrl = "home-about";
    private static final String installionUrl = "documentation-installation";
    private static final String changelogUrl = "documentation-changelog";
    private static final String supportUrl = "support";
    private static final String downloadUrl = "download";
    private static final String documentationUrl = "all-docs";
    private static final String pricingUrl = "pricing-details";
    private static final String managerUrl = "flow?id=manager";
    private static final String aboutUrl = "about";
    private static final String servicesUrl = "services";
    private static final String serviceDetailsUrl = "service-details";
    private static final String productPageUrl = "/product";
    private static final String quotationUrl = "/quotation";
    private static final String szmdUrl = "/szmd";
    private static final String questionsUrl = "/questions";
    private static final String changesUrl = "/changes";
    private static final String gradlePluginUrl = "/news-ibello-gradle-plugin";
    private static final String orderUrl = "/order";
    private static final String testAutomationUrl = "/landing-test-automation";
    private static final String unsubscribeUrl = "/unsubscribe";
    private static final String loginUrl = "/clients/#login";
    private static final String registrationUrl = "/clients/#registration";
    private static final String blogUrl = "blog";

    public void I_open_the_homepage() {
        homePage.I_open_homepage();
        homePage.I_am_on_the_page();
    }

    public boolean am_i_on_hompage() {
        return homePage.is_the_page_open();
    }

    public void I_am_on_homepage() {
        homePage.I_am_on_the_page();
        navigationBar.expect_menu_component_is_displayed();
    }

    public void i_navigate_from_homepage_to_ibello_page() {
        navigationBar.click_product_link();
        homePage.click_learn_more_button();
        productPage.I_am_on_the_page();
    }

    public void i_navigate_from_ibello_page_to_order_page() {
        productPage.click_order_button();
        navigationBar.expect_menu_component_is_displayed();
        orderPage.I_am_on_the_page();
        navigationBar.expect_menu_component_is_displayed();
    }

    public void i_navigate_from_homepage_header_to_product_page() {
        homePage.click_learn_more_button();
    }

    public void i_navigate_from_homepage_header_to_services_page() {
        navigationBar.click_services_link();
        homePage.click_work_with_us_button();
        servicesPage.I_am_on_the_page();
    }

    public void i_navigate_from_homepage_to_changes_page() {
        homePage.click_changes_button();
    }

    public void i_navigate_to_homepage_directly_from_navbar() {
        navigationBar.click_home_link();
        homePage.I_am_on_the_page();
        navigationBar.expect_menu_component_is_displayed();
    }

    public void i_am_on_order_page() {
        orderPage.I_am_on_the_page();
        navigationBar.expect_menu_component_is_displayed();
    }

    public void i_am_on_product_page() {
        productPage.I_am_on_the_page();
        navigationBar.expect_menu_component_is_displayed();
    }

    public void i_am_on_services_page() {
        servicesPage.I_am_on_the_page();
        navigationBar.expect_menu_component_is_displayed();
    }

    public void i_am_on_about_page() {
        aboutPage.I_am_on_the_page();
        navigationBar.expect_menu_component_is_displayed();
    }

    public void i_am_on_pricing_page() {
        productPricingPage.I_am_on_the_page();
        navigationBar.expect_menu_component_is_displayed();
    }

    public void i_am_on_documentations_page() {
        documentationsPage.I_am_on_the_page();
        navigationBar.expect_menu_component_is_displayed();
    }

    public void i_am_on_interest_page() {
        downloadPage.I_am_on_the_page();
        navigationBar.expect_menu_component_is_displayed();
    }

    public void i_am_on_support_page() {
        supportPage.I_am_on_the_page();
        navigationBar.expect_menu_component_is_displayed();
    }

    public void i_am_on_changelog_page() {
        changelogPage.I_am_on_the_page();
        navigationBar.expect_menu_component_is_displayed();
    }

    public void i_am_on_installation_documentation_page() {
        installationDocPage.I_am_on_the_page();
        navigationBar.expect_menu_component_is_displayed();
    }

    public void i_am_on_quotation_page() {
        quotationPage.I_am_on_the_page();
        navigationBar.expect_menu_component_is_displayed();
    }

    public void i_use_navbar_to_navigate_to_about_page() {
        navigationBar.click_about_us_link();
        homePage.expect_url_is_$(homeAboutUrl);
        homePage.click_meet_us_button();
        aboutPage.I_am_on_the_page();
    }

    public void i_use_navbar_to_navigate_to_documentations_page() {
        navigationBar.click_support_link();
        homePage.expect_url_is_$(homeSupportUrl);
        homePage.click_documentations_button();
        documentationsPage.I_am_on_the_page();
    }

    public void i_use_navbar_to_navigate_to_interest_page() {
        navigationBar.click_product_link();
        homePage.expect_url_is_$(homeIbelloUrl);
        homePage.click_try_it_button();
        downloadPage.I_am_on_the_page();
    }

    public void i_use_navbar_to_navigate_to_product_page() {
        navigationBar.click_product_link();
        homePage.expect_url_is_$(homeIbelloUrl);
        homePage.click_learn_more_button();
    }

    public void i_use_navbar_to_navigate_to_services_page() {
        navigationBar.click_services_link();
        homePage.expect_url_is_$(homeServicesUrl);
        homePage.click_work_with_us_button();
    }

    public void i_use_navbar_to_navigate_to_support_page() {
        navigationBar.click_support_link();
        homePage.expect_url_is_$(homeSupportUrl);
        homePage.click_more_options_button();
    }

    public void i_navigate_from_documentations_page_to_changelog_page() {
        documentationsPage.click_read_it_button();
    }

    public void i_navigate_from_installation_documentation_page_to_documentations_page() {
        installationDocPage.click_more_doc_button();
    }

    public void i_navigate_from_interest_page_to_documentations_page() {
        downloadPage.click_read_it_button();
    }

    public void i_navigate_from_interest_page_to_installation_documentation_page() {
        downloadPage.click_install_guide_button();
    }

    public void i_navigate_to_about_page_directly_from_navbar() {
        navigationBar.click_about_direct_link();
    }

    public void i_navigate_to_product_page_directly_from_navbar() {
        navigationBar.click_product_direct_link();
    }

    public void i_navigate_to_services_page_directly_from_navbar() {
        navigationBar.click_services_direct_link();
    }

    public void i_navigate_to_support_page_directly_from_navbar() {
        navigationBar.click_support_direct_link();
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
        servicesPage.open_service_with_index_$(3);
        servicesPage.click_request_test_framework_button();
    }

    public void i_make_a_request_for_consultancy() {
        servicesPage.open_service_with_index_$(6);
        servicesPage.click_request_consultancy_button();
    }

    public void i_make_a_request_for_trainings() {
        servicesPage.open_service_with_index_$(7);
        servicesPage.click_request_trainings_button();
    }

    public void i_navigate_from_product_page_to_order_page() {
        productPage.click_order_button();
    }


    public void i_see_that_no_product_is_selected() {
        for (int index = 0; index < 4; index++) {
            int currentNum = Integer.parseInt(orderPage.getNumberOfProduct(index));
            if (currentNum != 0) {
                throw new AssertionError("There is unexpected product selection!");
            }
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
        productPage.click_details_technics_button();
        productPage.click_download_button();
    }

    public void i_navigate_from_changelog_page_to_documentations_page() {
        changelogPage.click_more_documentation_button();
    }

    public void i_see_that_online_automated_testing_is_selected() {
        quotationPage.assume_online_testing_checkbox_is_selected();
        quotationPage.assume_automated_tests_checkbox_is_not_selected();
        quotationPage.assume_framework_checkbox_is_not_selected();
        quotationPage.assume_consultancy_checkbox_is_not_selected();
        quotationPage.assume_traingings_checkbox_is_not_selected();
    }

    public void i_see_that_consultancy_is_selected() {
        quotationPage.assume_online_testing_checkbox_is_not_selected();
        quotationPage.assume_automated_tests_checkbox_is_not_selected();
        quotationPage.assume_framework_checkbox_is_not_selected();
        quotationPage.assume_consultancy_checkbox_is_selected();
        quotationPage.assume_traingings_checkbox_is_not_selected();
    }

    public void i_see_that_training_is_selected() {
        quotationPage.assume_online_testing_checkbox_is_not_selected();
        quotationPage.assume_automated_tests_checkbox_is_not_selected();
        quotationPage.assume_framework_checkbox_is_not_selected();
        quotationPage.assume_consultancy_checkbox_is_not_selected();
        quotationPage.assume_traingings_checkbox_is_selected();
    }

    public void i_see_that_test_framework_is_selected() {
        quotationPage.assume_online_testing_checkbox_is_not_selected();
        quotationPage.assume_automated_tests_checkbox_is_not_selected();
        quotationPage.assume_framework_checkbox_is_selected();
        quotationPage.assume_consultancy_checkbox_is_not_selected();
        quotationPage.assume_traingings_checkbox_is_not_selected();
    }

    public void i_see_that_test_nothing_is_selected() {
        quotationPage.assume_online_testing_checkbox_is_not_selected();
        quotationPage.assume_automated_tests_checkbox_is_not_selected();
        quotationPage.assume_framework_checkbox_is_not_selected();
        quotationPage.assume_consultancy_checkbox_is_not_selected();
        quotationPage.assume_traingings_checkbox_is_not_selected();
    }

    public void i_see_that_automated_test_for_apps_is_selected() {
        quotationPage.assume_online_testing_checkbox_is_not_selected();
        quotationPage.assume_automated_tests_checkbox_is_selected();
        quotationPage.assume_framework_checkbox_is_not_selected();
        quotationPage.assume_consultancy_checkbox_is_not_selected();
        quotationPage.assume_traingings_checkbox_is_not_selected();
    }

    public void i_navigate_from_homepage_to_the_order_page_with_one_server_product() {
        homePage.click_order_server_button();
        orderPage.I_am_on_the_page();
    }

    public void i_navigate_from_homepage_to_the_order_page_with_one_analyzer_product() {
        homePage.click_order_analyzer_button();
        orderPage.I_am_on_the_page();
    }

    public void i_navigate_from_homepage_to_the_order_page_with_one_creator_product() {
        homePage.click_order_creator_button();
        orderPage.I_am_on_the_page();
    }

    public void i_navigate_from_homepage_to_the_order_page_with_one_team_product() {
        homePage.click_order_team_button();
        orderPage.I_am_on_the_page();
    }
    public void I_navigate_from_homepage_to_the_blog_page() {
        navigationBar.click_blog_direct_link();
        blogpage.I_am_on_the_page();
    }

    public void I_navigate_from_services_page_to_early_testing_services_page(){
        servicesPage.click_request_early_testing_button();
        landingPage.I_am_on_the_early_testing_page();
    }

    public void I_navigate_from_services_page_to_test_automation_services_page(){
        servicesPage.click_request_automation_services_button();
        landingPage.I_am_on_the_automation_services_page();
    }

    public void I_navigate_from_services_page_to_test_automation_mentoring_page(){
        servicesPage.click_request_automation_mentoring_button();
        landingPage.I_am_on_the_automation_mentoring_page();
    }
}
