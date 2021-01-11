package hu.ibello.demo.steps;

import hu.ibello.core.Name;
import hu.ibello.demo.pages.*;
import hu.ibello.demo.panel.NavigationBarPanel;
import hu.ibello.steps.StepLibrary;

@Name("Sitemap steps")
public class SitemapSteps extends StepLibrary {

    private SitemapPage sitemapPage;
    private NavigationBarPanel navigationBar;
    private LovelyJobsAwardPage lovelyJobsAwardPage;
    private QuestionsPage questionsPage;
    private ChangesPage changesPage;
    private IbelloPluginPage gradlePluginPage;
    private HomePage homePage;
    private DocumentationsPage documentationsPage;
    private DownloadPage downloadPage;
    private ProductPricingPage productPricingPage;
    private ServiceDetailsPage serviceDetailsPage;
    private OrderPage orderPage;
    private QuotationPage quotationPage;
    private ProductPage productPage;
    private ServicesPage servicesPage;
    private SupportPage supportPage;
    private AboutPage aboutPage;
    private TestAutomationPage testAutomationPage;
    private UnsubscribePage unsubscribePage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private DocumentationInstallationPage documentationInstallationPage;
    private AbstractDocumentationPage abstractDocumentationPage;

    private static final String szmdUrl = "szmd";
    private static final String questionsUrl = "questions-manager";
    private static final String changesUrl = "changes";
    private static final String gradlePluginUrl = "news-ibello-gradle-plugin";
    private static final String homeURL = "home";
    private static final String docsURL = "all-docs";
    private static final String downloadURL = "download";
    private static final String productPricingUrl = "pricing-details";
    private static final String serviceDetailsUrl = "service-details";
    private static final String orderUrl = "order";
    private static final String quotationUrl = "quotation";
    private static final String productUrl = "product";
    private static final String servicesUrl = "services";
    private static final String supportUrl = "support";
    private static final String aboutUrl = "about";
    private static final String testAutomationUrl = "landing-test-automation";
    private static final String unsubscribeUrl = "unsubscribe";
    private static final String loginUrl = "clients/#login";
    private static final String registrationUrl = "clients/#registration";
    private static final String documentationInstallationUrl = "documentation-installation";

    public void i_open_sitemap_page() {
        sitemapPage.i_open_sitemap_page();
    }

    public void i_am_on_sitemap_page() {
        sitemapPage.expect_url_is_sitemap();
        sitemapPage.expect_sitemap_lane_is_displayed();
        navigationBar.expect_menu_component_is_displayed();
    }

    public void i_am_not_on_sitemap_page() {
        sitemapPage.expect_url_is_not_sitemap();
        sitemapPage.expect_sitemap_lane_is_not_displayed();
        navigationBar.expect_menu_component_is_displayed();
    }

    public void i_verify_all_links() {
        int linkCount = sitemapPage.get_link_count();
        for (int i = 0; i < linkCount; i++) {
            String link = sitemapPage.get_link(i);
            sitemapPage.click_link_$(i);
            i_am_not_on_sitemap_page();
            verify_specific_links(link);
            i_open_sitemap_page();
            i_am_on_sitemap_page();
        }
    }

    private void verify_specific_links(String link) {
        if (link != null) {
            String path = link.replace("https://ibello.hu/", "").replace("https://ibello.eu/", "");
            switch (path) {
                case szmdUrl:
                    lovelyJobsAwardPage.i_am_on_the_page();
                    break;
                case questionsUrl:
                    questionsPage.i_am_on_the_page();
                    break;
                case changesUrl:
                    changesPage.i_am_on_the_page();
                    break;
                case gradlePluginUrl:
                    gradlePluginPage.i_am_on_the_page();
                    break;
                case homeURL:
                    homePage.i_am_on_the_page();
                    break;
                case docsURL:
                    documentationsPage.i_am_on_the_page();
                    break;
                case downloadURL:
                    downloadPage.i_am_on_the_page();
                    break;
                case productPricingUrl:
                    productPricingPage.i_am_on_the_page();
                    break;
                case serviceDetailsUrl:
                    serviceDetailsPage.i_am_on_the_page();
                    break;
                case orderUrl:
                    orderPage.i_am_on_the_page();
                    break;
                case quotationUrl:
                    quotationPage.i_am_on_the_page();
                    break;
                case productUrl:
                    productPage.i_am_on_the_page();
                    break;
                case servicesUrl:
                    servicesPage.i_am_on_the_page();
                    break;
                case supportUrl:
                    supportPage.i_am_on_the_page();
                    break;
                case aboutUrl:
                    aboutPage.i_am_on_the_page();
                    break;
                case testAutomationUrl:
                    testAutomationPage.i_am_on_the_page();
                    break;
                case unsubscribeUrl:
                    unsubscribePage.i_am_on_the_page();
                    break;
                case loginUrl:
                    loginPage.i_am_on_the_page();
                    break;
                case registrationUrl:
                    registrationPage.i_am_on_the_page();
                    break;
                case documentationInstallationUrl:
                    abstractDocumentationPage.i_am_on_the_page();
                    break;
            }
        }
    }
}
