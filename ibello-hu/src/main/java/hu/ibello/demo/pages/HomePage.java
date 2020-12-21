package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;
import hu.ibello.search.Relation;
import hu.ibello.search.RelationType;

@Name("Home page")
public class HomePage extends AbstractPage {

    @Find(by = By.CSS_SELECTOR, using = "welcome-main-lane")
    private WebElement mainLane;

    @Find(by = By.TEXT, using = "${0}")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CSS_SELECTOR, using = "welcome-main-lane")
    private WebElement text;

    @Find(by = By.ID, using = "contactName")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "contact-info")
    private WebElement contactNameField;

    @Find(by = By.ID, using = "contactEmail")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "contact-info")
    private WebElement contactEmailField;

    @Find(by = By.ID, using = "contactSubject")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "contact-info")
    private WebElement contactSubjectField;

    @Find(by = By.ID, using = "contactText")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "contact-info")
    private WebElement contactTextField;

    @Find(by = By.CSS_SELECTOR, using = "a[href='#']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CSS_SELECTOR, using = "contact-lane")
    private WebElement sendMessageButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='#about']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "lane-about-summary")
    private WebElement meetUsButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='#all-docs']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "lane-support-summary")
    private WebElement documentationsButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='#ibello']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "lane-ibello-summary")
    private WebElement learnMoreButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='#interest']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "lane-ibello-summary")
    private WebElement tryItButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='#services']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "lane-services-summary")
    private WebElement workWithUsButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='#support']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "lane-support-summary")
    private WebElement moreOptionsButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='#order']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "lane-convert")
    private WebElement productButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='#/order?product=SERVER']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "lane-prices")
    private WebElement orderServerButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='#/order?product=ANALYZER']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "lane-prices")
    private WebElement orderAnalyzerButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='#/order?product=CREATOR']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "lane-prices")
    private WebElement orderCreatorButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='#/order?product=TEAM_10']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "lane-prices")
    private WebElement orderTeamButton;

    public void assume_$_text_is_displayed(String textToCheck) {
        expectations().assume(text.applyParameters(textToCheck)).toBe().displayed();
    }

    public void assume_$_text_is_not_displayed(String textToCheck) {
        expectations().assume(text.applyParameters(textToCheck)).toNotBe().displayed();
    }

    public void i_expect_main_lane_is_displayed() {
        expectations().expect(mainLane).toBe().displayed();
    }

    public void set_contact_name_field_to_$(String value) {
        doWith(contactNameField).setValue(value);
    }

    public void set_contact_email_field_to_$(String value) {
        doWith(contactEmailField).setValue(value);
    }

    public void set_contact_subject_field_to_$(String value) {
        doWith(contactSubjectField).setValue(value);
    }

    public void set_contact_text_field_to_$(String value) {
        doWith(contactTextField).setValue(value);
    }

    public void click_send_message_button() {
        doWith(sendMessageButton).click();
    }

    public void i_open_homepage() {
        browser().resize(2000, 1000);
        browser().maximize();
        browser().openURL("/#home");
    }

    public void click_meet_us_button() {
        doWith(meetUsButton).click();
    }

    public void click_documentations_button() {
        doWith(documentationsButton).click();
    }

    public void click_learn_more_button() {
        doWith(learnMoreButton).click();
    }

    public void click_try_it_button() {
        doWith(tryItButton).click();
    }

    public void click_work_with_us_button() {
        doWith(workWithUsButton).click();
    }

    public void click_more_options_button() {
        doWith(moreOptionsButton).click();
    }

    public void click_product_button() {
        doWith(productButton).click();
    }

    public void click_order_server_button() {
        doWith(orderServerButton).click();
    }

    public void click_order_analyzer_button() {
        doWith(orderAnalyzerButton).click();
    }

    public void click_order_creator_button() {
        doWith(orderCreatorButton).click();
    }

    public void click_order_team_button() {
        doWith(orderTeamButton).click();
    }
}
