package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;
import hu.ibello.search.Relation;
import hu.ibello.search.RelationType;

@Name("Quotation page")
public class QuotationPage extends AbstractPage {

    private static final String url = "/quotation";

    @Find(by = By.CSS_SELECTOR, using = "quote-services-lane")
    private WebElement quoteServicesLane;

    @Find(by = By.ID, using = "service-online_testing")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "lane-quote-services")
    private WebElement onlineTestingCheckbox;

    @Find(by = By.ID, using = "service-test_apps")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "services")
    private WebElement automatedTestsCheckbox;

    @Find(by = By.ID, using = "service-test_framework")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "service")
    private WebElement frameworkCheckbox;

    @Find(by = By.ID, using = "service-consultancy")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "service")
    private WebElement consultancyCheckbox;

    @Find(by = By.ID, using = "service-trainings")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "service")
    private WebElement traingingsCheckbox;

    @Find(by = By.CSS_SELECTOR, using = "title-lane[key='titles.quotation']")
    private WebElement quotationTitle;

    @Override
    public void I_am_on_the_page() {
        expect_url_is_$(url);
        expectations().expect(quotationTitle).toBe().displayed();
        expectations().expect(quoteServicesLane).toBe().displayed();
    }

    public void assume_online_testing_checkbox_is_selected() {
        expectations().assume(onlineTestingCheckbox).toBe().selected();
    }

    public void assume_online_testing_checkbox_is_not_selected() {
        expectations().assume(onlineTestingCheckbox).toNotBe().selected();
    }

    public void assume_automated_tests_checkbox_is_selected() {
        expectations().assume(automatedTestsCheckbox).toBe().selected();
    }

    public void assume_automated_tests_checkbox_is_not_selected() {
        expectations().assume(automatedTestsCheckbox).toNotBe().selected();
    }

    public void assume_framework_checkbox_is_selected() {
        expectations().assume(frameworkCheckbox).toBe().selected();
    }

    public void assume_framework_checkbox_is_not_selected() {
        expectations().assume(frameworkCheckbox).toNotBe().selected();
    }

    public void assume_consultancy_checkbox_is_selected() {
        expectations().assume(consultancyCheckbox).toBe().selected();
    }

    public void assume_consultancy_checkbox_is_not_selected() {
        expectations().assume(consultancyCheckbox).toNotBe().selected();
    }

    public void assume_traingings_checkbox_is_selected() {
        expectations().assume(traingingsCheckbox).toBe().selected();
    }

    public void assume_traingings_checkbox_is_not_selected() {
        expectations().assume(traingingsCheckbox).toNotBe().selected();
    }
}
