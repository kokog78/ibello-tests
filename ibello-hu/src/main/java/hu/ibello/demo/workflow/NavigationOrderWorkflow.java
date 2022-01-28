package hu.ibello.demo.workflow;

import hu.ibello.core.Name;
import hu.ibello.demo.steps.ChoosingProductSteps;
import hu.ibello.demo.steps.NavigationSteps;
import hu.ibello.steps.StepLibrary;

@Name("navigation order")
public class NavigationOrderWorkflow extends StepLibrary{

    private NavigationSteps navigationSteps;
    private ChoosingProductSteps choosingProductSteps;

    public void test_init() {
        navigationSteps.I_open_the_homepage();
    }

    public void i_am_on_homepage() {
        navigationSteps.I_am_on_homepage();
    }

    public void i_navigate_back_to_homepage(){
        navigationSteps.i_navigate_to_homepage_directly_from_navbar();
    }

    public void from_home_page_i_order_a_server_product(){
        navigationSteps.i_navigate_from_homepage_to_the_order_page_with_one_server_product();
    }

    public void i_am_on_order_page_and_server_is_selected(){
        navigationSteps.i_am_on_order_page();
        choosingProductSteps.i_see_that_server_is_selected();
    }

    public void from_home_page_i_order_an_analyzer_product(){
        navigationSteps.i_navigate_from_homepage_to_the_order_page_with_one_analyzer_product();
    }

    public void i_am_on_order_page_and_analyzer_is_selected(){
        navigationSteps.i_am_on_order_page();
        choosingProductSteps.i_see_that_analyzer_is_selected();
    }

    public void from_home_page_i_order_a_creator_product(){
        navigationSteps.i_navigate_from_homepage_to_the_order_page_with_one_creator_product();
    }

    public void i_am_on_order_page_and_creator_is_selected(){
        navigationSteps.i_am_on_order_page();
        choosingProductSteps.i_see_that_creator_is_selected();
    }

    public void from_home_page_i_order_a_team_product(){
        navigationSteps.i_navigate_from_homepage_to_the_order_page_with_one_team_product();
    }

    public void i_am_on_order_page_and_team_10_is_selected(){
        navigationSteps.i_am_on_order_page();
        choosingProductSteps.i_see_that_team_10_is_selected();
    }
}
