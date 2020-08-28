package hu.ibello.demo.pages;

import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;
import hu.ibello.search.Relation;
import hu.ibello.search.RelationType;

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

    @Find(by = By.CSS_SELECTOR, using = "a[href='#ibello']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "lane-welcome-main")
    private WebElement ourProductButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='#']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CSS_SELECTOR, using = "contact-lane")
    private WebElement sendMessageButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='#services']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "lane-welcome-main")
    private WebElement ourServicesButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='#about']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "lane-about-summary")
    private WebElement meetUsButton;

    private boolean isOpened;

    public void assume_$_text_is_displayed(String textToCheck) {
        expectations().assume(text.applyParameters(textToCheck)).toBe().displayed();
    }

    public void assume_$_text_is_not_displayed(String textToCheck) {
        expectations().assume(text.applyParameters(textToCheck)).toNotBe().displayed();
    }

    public void click_our_product_button() {
        doWith(ourProductButton).click();
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

    private void homepage_is_displayed() {
        i_expect_main_lane_is_displayed();
    }

    public void click_our_services_button() {
        doWith(ourServicesButton).click();
    }

    public void click_meet_us_button() {
        doWith(meetUsButton).click();
    }

    public void i_expect_main_lane_is_displayed() {
        expectations().expect(mainLane).toBe().displayed();
    }

}
