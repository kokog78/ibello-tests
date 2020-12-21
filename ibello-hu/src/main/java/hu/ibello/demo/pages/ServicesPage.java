package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.elements.WebElements;
import hu.ibello.search.By;
import hu.ibello.search.Find;
import hu.ibello.search.Relation;
import hu.ibello.search.RelationType;

@Name("Services page")
public class ServicesPage extends AbstractPage {

    @Find(by = By.CSS_SELECTOR, using = "welcome-services-lane")
    private WebElement servicesLane;

    @Find(by = By.CSS_SELECTOR, using = "a[href='#quotation']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "lane-convert")
    private WebElement requestButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='#/quotation?service=online_testing']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "lane-service-details")
    private WebElement requestOnlineTestingButton;

    @Find(by = By.CSS_SELECTOR, using = " a[href='#/quotation?service=test_apps']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "lane-service-details")
    private WebElement requestAutomatedTestButton;

    @Find(by = By.CSS_SELECTOR, using = " a[href='#/quotation?service=test_framework']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "lane-service-details")
    private WebElement requestTestFrameworkButton;

    @Find(by = By.CSS_SELECTOR, using = " a[href='#/quotation?service=consultancy']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "lane-service-details")
    private WebElement requestConsultancyButton;

    @Find(by = By.CSS_SELECTOR, using = " a[href='#/quotation?service=trainings']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "lane-service-details")
    private WebElement requestTrainingsButton;

    @Find(by = By.CSS_SELECTOR, using = "h3")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "lane-service-details")
    private WebElements serviceSectors;

    public void expect_services_lane_is_displayed() {
        expectations().expect(servicesLane).toBe().displayed();
    }

    public void click_request_button() {
        doWith(requestButton).click();
    }

    public void click_request_online_testing_button() {
        doWith(requestOnlineTestingButton).click();
    }

    public void click_request_automated_test_button() {
        doWith(requestAutomatedTestButton).click();
    }

    public void click_request_test_framework_button() {
        doWith(requestTestFrameworkButton).click();
    }

    public void click_request_consultancy_button() {
        doWith(requestConsultancyButton).click();
    }

    public void click_request_trainings_button() {
        doWith(requestTrainingsButton).click();
    }

    public void open_service_with_index_$(int serviceIndex) {
        if (!serviceSectors.isEmpty()) {
            doWith(serviceSectors.get(serviceIndex)).click();
        } else {
            throw new AssertionError("There are no available services on the page!");
        }
    }

}
