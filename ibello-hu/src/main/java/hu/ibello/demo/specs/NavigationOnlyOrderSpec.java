package hu.ibello.demo.specs;

import hu.ibello.core.Specification;
import hu.ibello.core.Test;
import hu.ibello.demo.workflow.NavigationOrderWorkflow;

@Specification
public class NavigationOnlyOrderSpec {

    private NavigationOrderWorkflow navigationOrderWorkflow;

    @Test
    public void navigation_only_order_spec() {
        navigationOrderWorkflow.test_init();
        navigationOrderWorkflow.i_am_on_homepage();
        navigationOrderWorkflow.from_home_page_i_order_a_server_product();
        navigationOrderWorkflow.i_am_on_order_page_and_server_is_selected();
        navigationOrderWorkflow.i_navigate_back_to_homepage();
        navigationOrderWorkflow.from_home_page_i_order_an_analyzer_product();
        navigationOrderWorkflow.i_am_on_order_page_and_analyzer_is_selected();
        navigationOrderWorkflow.i_navigate_back_to_homepage();
        navigationOrderWorkflow.from_home_page_i_order_a_creator_product();
        navigationOrderWorkflow.i_am_on_order_page_and_creator_is_selected();
        navigationOrderWorkflow.i_navigate_back_to_homepage();
        navigationOrderWorkflow.from_home_page_i_order_a_team_product();
        navigationOrderWorkflow.i_am_on_order_page_and_team_10_is_selected();
        navigationOrderWorkflow.i_navigate_back_to_homepage();
    }
}
