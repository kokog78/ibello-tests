package hu.ibello.demo.workflow;

import hu.ibello.core.Name;
import hu.ibello.demo.model.ContactData;
import hu.ibello.demo.steps.NavigationSteps;
import hu.ibello.demo.steps.SendingMessageSteps;
import hu.ibello.steps.StepLibrary;

@Name("Message negative")
public class MessageNegativeWorkflow extends StepLibrary{

    private NavigationSteps navigationSteps;
    private SendingMessageSteps sendingMessageSteps;
    private boolean isOpened;

    public void i_want_to_send_a_new_message() {
        if (!isOpened) {
            navigationSteps.i_open_the_homepage();
            isOpened = true;
        }
        navigationSteps.i_am_on_homepage();
    }

    public void the_name_will_be_invalid() {
        ContactData data = testData().fromJson(ContactData.class).withId("invalid_name").load();
        sendingMessageSteps.i_use_$_test_data_to_fill_out_the_form(data);
    }

    public void the_email_will_be_invalid() {
        ContactData data = testData().fromJson(ContactData.class).withId("invalid_email").load();
        sendingMessageSteps.i_use_$_test_data_to_fill_out_the_form(data);
    }

    public void the_subject_will_be_invalid() {
        ContactData data = testData().fromJson(ContactData.class).withId("invalid_subject").load();
        sendingMessageSteps.i_use_$_test_data_to_fill_out_the_form(data);
    }

    public void the_message_will_be_invalid() {
        ContactData data = testData().fromJson(ContactData.class).withId("invalid_message").load();
        sendingMessageSteps.i_use_$_test_data_to_fill_out_the_form(data);
    }

    public void i_send_the_message() {
        sendingMessageSteps.i_send_the_message();
    }

    public void i_see_that_the_there_is_an_error_message() {
        sendingMessageSteps.i_see_the_error_message();
    }

}
