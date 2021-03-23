package hu.ibello.demo.workflow;

import hu.ibello.core.Name;
import hu.ibello.demo.model.ContactData;
import hu.ibello.demo.pages.HomePage;
import hu.ibello.demo.steps.NavigationSteps;
import hu.ibello.demo.steps.SendingMessageSteps;
import hu.ibello.steps.StepLibrary;

@Name("Message")
public class MessageWorkflow extends StepLibrary{

    private NavigationSteps navigationSteps;
    private SendingMessageSteps sendingMessageSteps;
    private HomePage homePage;

    private boolean isOpened;
    private ContactData data;

    public void i_want_to_send_a_new_message() {
        data = new ContactData();
        if (!isOpened) {
            navigationSteps.i_open_the_homepage();
            isOpened = true;
        }
        homePage.i_am_on_the_page();
    }

    public void the_name_will_be_valid() {
        data.setName("Mr. Valid Name");
    }

    public void the_email_will_be_valid() {
        data.setEmail("valid@email.hu");
    }

    public void the_subject_will_be_valid() {
        data.setSubject("Valid subject");
    }

    public void the_message_will_be_valid() {
        data.setMessage("This is a valid message");
    }

    public void the_name_will_be_empty() {
        data.setName("");
    }

    public void the_email_will_be_empty() {
        data.setEmail("");
    }

    public void the_subject_will_be_empty() {
        data.setSubject("");
    }

    public void the_message_will_be_empty() {
        data.setMessage("");
    }

    public void the_email_will_be_invalid() {
        data.setEmail("invalidemail.com");
    }

    public void i_fill_out_the_form() {
        sendingMessageSteps.i_use_$_to_fill_out_the_form(data);
    }

    public void i_send_the_message() {
        sendingMessageSteps.i_send_the_message();
    }

    public void i_see_$_error_messages(int number) {
        sendingMessageSteps.i_see_$_error_messages(number);
    }

    public void i_see_that_sending_the_message_was_successfull() {
        sendingMessageSteps.i_see_the_success_message();
    }

}
