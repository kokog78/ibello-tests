package hu.ibello.demo.pages.elements;
import hu.ibello.elements.ElementRepository;
import hu.ibello.elements.WebElement;
import hu.ibello.elements.WebElements;

public class OrderElementsRead extends ElementRepository{

    public OrderElementsRead() {
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

    public WebElement passwordField() {
        return element("passwordField");
    }

    public WebElement increaseButton() {
        return element("increaseButton");
    }

    public WebElement decreaseButton() {
        return element("decreaseButton");
    }
    public WebElements numberOfProducts() {
        return elements("numberOfProducts");
    }
    public WebElement numberOfProduct() {
        return element("numberOfProduct");
    }

    public WebElement title() {
        return element("title");
    }
}
