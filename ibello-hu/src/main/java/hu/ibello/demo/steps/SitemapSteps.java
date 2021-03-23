package hu.ibello.demo.steps;

import hu.ibello.core.Name;
import hu.ibello.demo.pages.*;
import hu.ibello.demo.panel.NavigationBarPanel;
import hu.ibello.steps.StepLibrary;

import java.util.HashMap;
import java.util.Map;

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
    private DocumentationPage documentationPage;

    private static final String szmdUrl = "/szmd";
    private static final String questionsUrl = "/questions-manager";
    private static final String changesUrl = "/changes";
    private static final String gradlePluginUrl = "/news-ibello-gradle-plugin";
    private static final String homeURL = "/home";
    private static final String docsURL = "/all-docs";
    private static final String downloadURL = "/download";
    private static final String productPricingUrl = "/pricing-details";
    private static final String serviceDetailsUrl = "/service-details";
    private static final String orderUrl = "/order";
    private static final String quotationUrl = "/quotation";
    private static final String productUrl = "/product";
    private static final String servicesUrl = "/services";
    private static final String supportUrl = "/support";
    private static final String aboutUrl = "/about";
    private static final String testAutomationUrl = "/landing-test-automation";
    private static final String unsubscribeUrl = "/unsubscribe";
    private static final String loginUrl = "/clients/#login";
    private static final String registrationUrl = "/clients/#registration";
    private static final String documentationInstallationUrl = "/documentation-installation";
    private static final String documentationGuidesUrl = "/documentation-guides";
    private static final String documentationApiUrl = "/documentation-api";
    private static final String documentationExamplesUrl = "/documentation-examples";
    private static final String documentationCliUrl = "/documentation-cli";
    private static final String documentationConfigurationUrl = "/documentation-configuration";
    private static final String documentationResultsUrl = "/documentation-results";
    private static final String documentationKpiUrl = "/documentation-kpi";
    private static final String documentationCucumberUrl = "/documentation-cucumber";
    private static final String documentationGenerateUrl = "/documentation-generate";
    private static final String documentationDocgenUrl = "/documentation-docgen";
    private static final String documentationChangelogUrl = "/documentation-changelog";
    private static final String documentationProblemsUrl = "/documentation-problems";

    private Map<String, AbstractPage> pages;

    public void i_open_sitemap_page() {
        sitemapPage.i_open_sitemap_page();
    }

    public void i_am_on_sitemap_page() {
        sitemapPage.i_am_on_the_page();
        navigationBar.expect_menu_component_is_displayed();
    }

    public void i_am_not_on_sitemap_page() {
        sitemapPage.i_am_not_on_the_page();
        navigationBar.expect_menu_component_is_displayed();
    }

    public void i_verify_all_links() throws Exception {
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

    private void verify_specific_links(String link) throws Exception {
        if (link != null) {
            String path = link.replace("https://ibello.hu", "").replace("https://ibello.eu", "");
            AbstractPage page = getPage(path);
            if (page != null){
                page.i_am_on_the_page();
            }else {
                output().recordCustomExpectation("Unknow path: " + path);
            }
        }
    }

    private AbstractPage getPage(String url) {
        if (pages == null) {
            pages = new HashMap<>();
            pages.put(szmdUrl, lovelyJobsAwardPage);
            pages.put(questionsUrl, questionsPage);
            pages.put(changesUrl, changesPage);
            pages.put(gradlePluginUrl, gradlePluginPage);
            pages.put(homeURL, homePage);
            pages.put(docsURL, documentationsPage);
            pages.put(downloadURL, downloadPage);
            pages.put(productPricingUrl, productPricingPage);
            pages.put(serviceDetailsUrl, serviceDetailsPage);
            pages.put(orderUrl, orderPage);
            pages.put(quotationUrl, quotationPage);
            pages.put(productUrl, productPage);
            pages.put(servicesUrl, servicesPage);
            pages.put(supportUrl, supportPage);
            pages.put(aboutUrl, aboutPage);
            pages.put(testAutomationUrl, testAutomationPage);
            pages.put(unsubscribeUrl, unsubscribePage);
            pages.put(loginUrl, loginPage);
            pages.put(registrationUrl, registrationPage);
            pages.put(documentationInstallationUrl, documentationPage);
            pages.put(documentationGuidesUrl, documentationPage);
            pages.put(documentationApiUrl, documentationPage);
            pages.put(documentationExamplesUrl, documentationPage);
            pages.put(documentationCliUrl, documentationPage);
            pages.put(documentationConfigurationUrl, documentationPage);
            pages.put(documentationResultsUrl, documentationPage);
            pages.put(documentationKpiUrl, documentationPage);
            pages.put(documentationCucumberUrl, documentationPage);
            pages.put(documentationGenerateUrl, documentationPage);
            pages.put(documentationDocgenUrl, documentationPage);
            pages.put(documentationChangelogUrl, documentationPage);
            pages.put(documentationProblemsUrl, documentationPage);
        }
        return pages.get(url);
    }
}
