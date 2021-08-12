package hu.ibello.demo.steps;

import hu.ibello.core.Name;
import hu.ibello.demo.pages.OrderResultPage;
import hu.ibello.demo.panel.PopUpMessagesPanel;
import hu.ibello.demo.model.ExistingUserData;
import hu.ibello.demo.pages.OrderPage;
import hu.ibello.steps.StepLibrary;

@Name("Ordering with existing user steps")
public class OrderingWithExistingUserSteps extends StepLibrary {

    private OrderPage orderPage;
    private PopUpMessagesPanel popUpMessagesPanel;
    private OrderResultPage orderResultPage;

    public void i_send_the_order() {
        orderPage.click_sending_order_button();
    }

    public void i_use_$_test_data_to_fill_out_the_ordering_form_with_existing_user(ExistingUserData data) {
        if (data != null) {
                orderPage.click_existing_user_radio_button();

            if (data.getNameOrEmail() != null) {
                orderPage.set_username_or_email_field_to_$(data.getNameOrEmail());
            }
            if (data.getInvalidPwd() != null) {
                orderPage.set_password_field_to_$(data.getInvalidPwd());
            } else {
                String pwd = getConfigurationValue("validUserPwd").toString();
                orderPage.set_password_field_to_$(pwd);
            }
        }
    }

    public void i_see_the_error_message() {
        popUpMessagesPanel.assume_error_message_is_displayed();
        popUpMessagesPanel.assume_error_message_is_not_displayed();
    }

    public void i_see_the_order_result_page() {
        orderResultPage.i_am_on_the_page();
    }

}
