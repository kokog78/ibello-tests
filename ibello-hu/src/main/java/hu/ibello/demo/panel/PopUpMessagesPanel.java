package hu.ibello.demo.panel;

import hu.ibello.demo.tools.Timeout;
import hu.ibello.elements.WebElement;
import hu.ibello.elements.WebElements;
import hu.ibello.pages.PageObject;
import hu.ibello.search.By;
import hu.ibello.search.Find;
import hu.ibello.search.Relation;
import hu.ibello.search.RelationType;

public class PopUpMessagesPanel extends PageObject {

    @Find(by = By.CLASS_NAME, using = "error")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CSS_SELECTOR, using = "toast-component")
    private WebElement errorMessage;

    @Find(by = By.CLASS_NAME, using = "success")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CSS_SELECTOR, using = "toast-component")
    private WebElement successMessage;

    public void assume_error_message_is_displayed() {
        expectations().assume(errorMessage).toBe().displayed();
    }

    public void assume_error_message_is_not_displayed() {
        expectations().withTimeout(Timeout.LONG).assume(errorMessage).toNotBe().displayed();
    }

    public void assume_$_error_messages_are_displayed(int expectedNumberOfErrors) {
        WebElements errorMessages = errorMessage.find().using(By.CSS_SELECTOR, "div").all();
        int displayedErrors = errorMessages.size();
        if (expectedNumberOfErrors != displayedErrors) {
            throw new AssertionError(String.format("There are %d error(s) displayed but %d are expected!"
                    , displayedErrors, expectedNumberOfErrors));
        }
    }
    
    public void acknowledge_the_error_message() {
        doWith(errorMessage).click();
    }

}
