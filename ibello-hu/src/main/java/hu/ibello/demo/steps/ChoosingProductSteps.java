package hu.ibello.demo.steps;

import hu.ibello.core.Name;
import hu.ibello.demo.model.ProductToOrder;
import hu.ibello.demo.pages.OrderPage;
import hu.ibello.steps.StepLibrary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Name("Choosing product to order")
public class ChoosingProductSteps extends StepLibrary {

    private OrderPage orderPage;
    private final List<String> productNames = new ArrayList<>(Arrays.asList("evaluation", "server", "analyzer", "creator", "team 5", "team 10"));

    public void i_use_$_test_data_to_select_products(ProductToOrder data) {
        if (data != null) {
            change_number_of_product(data.getEvaluation(), 1);
            change_number_of_product(data.getServer(), 2);
            change_number_of_product(data.getAnalyzer(), 3);
            change_number_of_product(data.getCreator(), 4);
        }
    }

    private void change_number_of_product(int expectedNum, int productIndex) {
        productIndex--;
        int currentNum = Integer.parseInt(orderPage.getNumberOfProduct(productIndex));
        while (expectedNum != currentNum) {
            if (expectedNum > currentNum) {
                orderPage.click_increase_button_with_$_index(productIndex);
            }
            if (expectedNum < currentNum) {
                orderPage.click_decrease_button_with_$_index(productIndex);
            }
            currentNum = Integer.parseInt(orderPage.getNumberOfProduct(productIndex));
        }
    }

    public void i_see_that_server_is_selected() {
        check_if_order_with_$_index_is_selected(1);
    }

    public void i_see_that_analyzer_is_selected() {
        check_if_order_with_$_index_is_selected(2);
    }

    public void i_see_that_creator_is_selected() {
        check_if_order_with_$_index_is_selected(3);
    }

    public void i_see_that_team_10_is_selected() {
        check_if_order_with_$_index_is_selected(5);
    }

    private void check_if_order_with_$_index_is_selected(int productIndex) {
        String product;
        if (productNames.size()<=productIndex) {
            product = "";
        } else {
            product = productNames.get(productIndex);
        }
        for (int index = 0; index < 4; index++) {
            int currentNum = Integer.parseInt(orderPage.getNumberOfProduct(index));
            if (index == productIndex) {
                if (currentNum != 1) {
                    throw new AssertionError(String.format("The %s is not selected!", product));
                }
            }
            if (currentNum > 0 && index != productIndex) {
                throw new AssertionError("There is unexpected product selection!");
            }
        }
    }
}
