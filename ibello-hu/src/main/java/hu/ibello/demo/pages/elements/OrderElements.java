package hu.ibello.demo.pages.elements;
import hu.ibello.elements.ElementRepository;
import hu.ibello.elements.WebElement;

public class OrderElements extends ElementRepository{

    public OrderElements() {
        setRepositoryPath("order-elements.repo");
    }

    public WebElement menuComponent() {
        return element("menuComponent");
    }

    public WebElement orderLane() {
        return element("orderLane");
    }

    public WebElement existingUserRadioButton() {
        return element("existingUserRadioButton");
    }

    public WebElement usernameOrEmailField() {
        return element("usernameOrEmailField");
    }

    public WebElement sendingOrderButton() {
        return element("sendingOrderButton");
    }

    public WebElement passwordButton() {
        return element("passwordButton");
    }

    public WebElement increaseButton() {
        return element("increaseButton");
    }

    public WebElement ecreaseButton() {
        return element("ecreaseButton");
    }

    public WebElement numberOfProducts() {
        return element("numberOfProducts");
    }

    public WebElement newUserRadioButton() {
        return element("newUserRadioButton");
    }

    public WebElement title() {
        return element("title");
    }
}
