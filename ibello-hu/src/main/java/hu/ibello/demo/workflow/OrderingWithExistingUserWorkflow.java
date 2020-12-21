package hu.ibello.demo.workflow;

import hu.ibello.core.Name;
import hu.ibello.demo.model.ExistingUserData;
import hu.ibello.demo.model.ProductToOrder;
import hu.ibello.demo.steps.ChoosingProductSteps;
import hu.ibello.demo.steps.NavigationSteps;
import hu.ibello.demo.steps.OrderingWithExistingUserSteps;
import hu.ibello.steps.StepLibrary;

@Name("Existing user order")
public class OrderingWithExistingUserWorkflow extends StepLibrary{

    private NavigationSteps navigationSteps;
    private OrderingWithExistingUserSteps orderingSteps;
    private ChoosingProductSteps choosingProductSteps;

    public void i_want_to_take_an_order() {
        navigationSteps.i_am_on_order_page();
    }

    public void i_navigate_to_the_order_page() {
        navigationSteps.i_open_the_homepage();
        navigationSteps.i_navigate_from_homepage_to_ibello_page();
        navigationSteps.i_navigate_from_ibello_page_to_order_page();
    }

    public void the_user_data_will_be_valid() {
        ExistingUserData data = testData().fromJson(ExistingUserData.class).load();
        orderingSteps.i_use_$_test_data_to_fill_out_the_ordering_form_with_existing_user(data);
    }

    public void the_username_will_be_invalid() {
        ExistingUserData data = testData().fromJson(ExistingUserData.class).withId("invalid_user").load();
        orderingSteps.i_use_$_test_data_to_fill_out_the_ordering_form_with_existing_user(data);
    }

    public void the_password_will_be_invalid() {
        ExistingUserData data = testData().fromJson(ExistingUserData.class).withId("invalid_pwd").load();
        orderingSteps.i_use_$_test_data_to_fill_out_the_ordering_form_with_existing_user(data);
    }

    public void the_product_will_be_valid() {
        ProductToOrder data = testData().fromJson(ProductToOrder.class).load();
        choosingProductSteps.i_use_$_test_data_to_select_products(data);
    }

    public void the_product_will_be_invalid() {
        ProductToOrder data = testData().fromJson(ProductToOrder.class).withId("invalid").load();
        choosingProductSteps.i_use_$_test_data_to_select_products(data);
    }

    public void i_send_the_order() {
        orderingSteps.i_send_the_order();
    }

    public void i_see_that_there_is_an_error_message() {
        orderingSteps.i_see_the_error_message();
    }

    public void i_see_that_the_order_is_successful() {
        orderingSteps.i_see_the_success_message();
    }

}
