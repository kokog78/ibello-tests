package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.demo.pages.elements.OrderElementsRead;
import hu.ibello.elements.WebElement;
import hu.ibello.elements.WebElements;


@Name("Order page")
public class OrderPage extends AbstractPage {

    private final String url = "/order";
    private OrderElementsRead orderElementsRead;

    @Override
    public void i_am_on_the_page() {
        expect_url_is_$(url);
        expectations().expect(orderElementsRead.orderLane()).toBe().displayed();
        expectations().expect(orderElementsRead.title()).toBe().displayed();
    }

    public void click_existing_user_radio_button() {
        doWith(orderElementsRead.title()).moveTo();
        doWith(orderElementsRead.existingUserRadioButton()).click();
    }


    public void set_username_or_email_field_to_$(String value) {
        doWith(orderElementsRead.usernameOrEmailField()).setValue(value);
    }

    public void set_password_field_to_$(String value) {
        doWith(orderElementsRead.passwordField()).setValue(value);
    }

    public void click_decrease_button_with_$_index(int index) {
        doWith(orderElementsRead.ecreaseButton().get(index)).click();
        // TODO javítani a nevét
    }

    public void click_increase_button_with_$_index(int index) {
        doWith(orderElementsRead.increaseButton().get(index)).click();
    }

    public void click_sending_order_button() {
        doWith(orderElementsRead.sendingOrderButton()).click();
    }

    public String getNumberOfProduct(int index) {
        return get(orderElementsRead.numberOfProducts().get(index)).text();
    }
}
