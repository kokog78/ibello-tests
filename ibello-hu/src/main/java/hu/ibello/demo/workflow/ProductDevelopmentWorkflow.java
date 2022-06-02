package hu.ibello.demo.workflow;

import hu.ibello.core.Name;
import hu.ibello.demo.steps.ChangesSteps;
import hu.ibello.demo.steps.NavigationSteps;
import hu.ibello.steps.StepLibrary;

@Name("Product development")
public class ProductDevelopmentWorkflow extends StepLibrary {

    private NavigationSteps navigationSteps;
    private ChangesSteps changesSteps;

    public void I_am_on_homepage() {
        navigationSteps.I_open_the_homepage();
    }

    public void I_navigate_to_product_development_page() {
        navigationSteps.i_navigate_from_homepage_to_changes_page();
    }

    public void The_version_numbers_are_the_same() {
        changesSteps.I_compare_the_version_numbers();
    }

    public void The_version_dates_are_the_same() {
        changesSteps.I_compare_the_version_dates();
    }

    public void The_version_changes_are_described() {
        changesSteps.I_see_the_changes_are_described();
    }

    public void The_version_changes_order_are_the_same() {
        changesSteps.I_compare_the_icons_order();
    }

}
