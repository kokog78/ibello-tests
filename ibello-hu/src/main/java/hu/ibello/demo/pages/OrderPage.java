package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.demo.pages.elements.OrderElementsRead;


@Name("Order page")
public class OrderPage extends AbstractPage {

    private final String url = "/order";
    private OrderElementsRead orderElementsRead;

    @Override
    public void I_am_on_the_page() {
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

    public void click_decrease_button_with_$_product(String productName) {
        doWith(orderElementsRead.decreaseButton().applyParameters(productName)).click();
    }

    public void click_increase_button_with_$_product(String productName) {
        doWith(orderElementsRead.increaseButton().applyParameters(productName)).click();
    }

    public int get_number_of_selection_$_product(String productName) {
       return Integer.parseInt(get(orderElementsRead.numberOfProduct().applyParameters(productName)).text());
    }

    public String getNumberOfProduct(int index) {
        return get(orderElementsRead.numberOfProducts().get(index)).text();
    }

    public int getNumberOfProducts(){
        return orderElementsRead.numberOfProducts().size();
    }

    public void click_sending_order_button() {
        doWith(orderElementsRead.sendingOrderButton()).click();
    }
}
