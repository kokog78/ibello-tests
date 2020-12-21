package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.elements.WebElements;
import hu.ibello.search.By;
import hu.ibello.search.Find;
import hu.ibello.search.Relation;
import hu.ibello.search.RelationType;

@Name("Order page")
public class OrderPage extends AbstractPage {

    @Find(by = By.CSS_SELECTOR, using = "order-pack-lane")
    private WebElement orderLane;

    @Find(by = By.ID, using = "existing-user")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "user")
    private WebElement existingUserRadioButton;

    @Find(by = By.NAME, using = "usernameOrEmail")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "user")
    private WebElement usernameOrEmailField;

    @Find(by = By.NAME, using = "password")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "user")
    private WebElement passwordField;

    @Find(by = By.BUTTON_CLASS, using = "send")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CSS_SELECTOR, using = "order-pack-lane")
    private WebElement sendingOrderButton;

    @Find(by = By.BUTTON_TEXT, using = "−")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "products")
    private WebElements decreaseButtons;

    @Find(by = By.BUTTON_TEXT, using = "+")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "products")
    private WebElements increaseButtons;

    @Find(by = By.CLASS_NAME, using = "number")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "products")
    private WebElements numberOfProducts;

    public void expect_order_lane_is_displayed() {
        expectations().expect(orderLane).toBe().displayed();
    }

    public void click_existing_user_radio_button() {
        doWith(existingUserRadioButton).click();
    }

    public void set_username_or_email_field_to_$(String value) {
        doWith(usernameOrEmailField).setValue(value);
    }

    public void set_password_field_to_$(String value) {
        doWith(passwordField).setValue(value);
    }

    public void click_decrease_button_with_$_index(int index) {
        doWith(decreaseButtons.get(index)).click();
    }

    public void click_increase_button_with_$_index(int index) {
        doWith(increaseButtons.get(index)).click();
    }

    public void click_sending_order_button() {
        doWith(sendingOrderButton).click();
    }

    public String getNumberOfProduct(int index) {
        return get(numberOfProducts.get(index)).text();
    }

}
