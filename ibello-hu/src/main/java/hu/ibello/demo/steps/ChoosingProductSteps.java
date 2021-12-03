package hu.ibello.demo.steps;

import hu.ibello.core.Name;
import hu.ibello.demo.model.ProductToOrder;
import hu.ibello.demo.pages.OrderPage;
import hu.ibello.steps.StepLibrary;

import static hu.ibello.demo.model.ProductNames.*;

@Name("Choosing product to order")
public class ChoosingProductSteps extends StepLibrary {

    private OrderPage orderPage;

    public void i_use_$_test_data_to_select_products(ProductToOrder data) {
        if (data != null) {
            if(orderPage.getNumberOfProducts()>5){
                change_number_of_product(data.getEvaluation(), EVALUATION.toString());
            }
            change_number_of_product(data.getServer(), SERVER.toString());
            change_number_of_product(data.getAnalyzer(), ANALYZER.toString());
            change_number_of_product(data.getCreator(), CREATOR.toString());
        }
    }

    private void change_number_of_product(int expectedNum, String productName) {
        int currentNum = getNumberOfProduct(productName);
        while (expectedNum != currentNum) {
            if (expectedNum > currentNum) {
                orderPage.click_increase_button_with_$_product(productName);
            }
            if (expectedNum < currentNum) {
                orderPage.click_decrease_button_with_$_product(productName);
            }
            currentNum = getNumberOfProduct(productName);
        }
    }

    public void i_see_that_server_is_selected() {
        check_if_order_with_$_is_selected(SERVER.toString());
    }

    public void i_see_that_analyzer_is_selected() {
        check_if_order_with_$_is_selected(ANALYZER.toString());
    }

    public void i_see_that_creator_is_selected() {
        check_if_order_with_$_is_selected(CREATOR.toString());
    }

    public void i_see_that_team_10_is_selected() {
        check_if_order_with_$_is_selected(TEAM10.toString());
    }

    private void check_if_order_with_$_is_selected(String productName) {
        // TODO ez a metódus azt ellenőrzi, hogy ha az ibello.hu főoldalán az egyik terméknél a megrendelés gombra kattintok
        //  akkor az oldal átnavigál-e az order oldalra úgy, hogy a kattintásnak megfelelő terméknél 1 van kiválasztva. Van már egy privát
        //  metódus (getNumberOfProduct(String selectedProductName)) ami visszaadja, hogy az adott terméknél mennyi van kiválasztva. Kellene
        //  az OrderPage oldalleíróban egy olyan metódus ami megkapja ezt a számot és a terméket, majd expectation().assume()... metódusláncot használva
        //  ellenőrzi, hogy az érték 1 (pontosan 1 mert úgy kellene működnie az oldalnak).
        int currentNumberOfProduct = orderPage.get_number_of_selection_$_product(productName);
        if(currentNumberOfProduct<1){
            throw new AssertionError(productName + " Is not selected");
        }
    }

    private int getNumberOfProduct(String selectedProductName){
        return orderPage.get_number_of_selection_$_product(selectedProductName);
    }
}
