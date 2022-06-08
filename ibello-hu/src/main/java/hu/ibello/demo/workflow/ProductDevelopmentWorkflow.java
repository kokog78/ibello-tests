package hu.ibello.demo.workflow;

import hu.ibello.core.Name;
import hu.ibello.demo.steps.ChangesSteps;
import hu.ibello.demo.steps.NavigationSteps;
import hu.ibello.steps.StepLibrary;

@Name("Product development")
public class ProductDevelopmentWorkflow extends StepLibrary {

    private NavigationSteps navigationSteps;
    private ChangesSteps changesSteps;

    public void I_am_on_product_development_page() {
        navigationSteps.I_open_the_homepage();
        navigationSteps.i_navigate_from_homepage_to_changes_page();
    }

    public void I_collect_the_version_numbers() {
        changesSteps.I_collect_the_version_numbers();
    }
    public void The_version_numbers_are_the_same() {
        changesSteps.The_version_numbers_are_the_same();
    }

    public void I_collect_the_version_dates() {
        changesSteps.I_collect_the_version_dates();
    }
    public void The_version_dates_are_the_same() {
        changesSteps.The_version_dates_are_the_same();
    }

    public void I_collect_the_version_descriptions() {
        changesSteps.I_collect_the_version_descriptions();
    }
    public void The_version_descriptions_are_filled() {
        changesSteps.The_version_descriptions_are_filled();
    }

    public void I_collect_the_version_changes() {
        changesSteps.I_collect_the_version_icons();
    }
    public void The_ordering_of_version_changes_is_the_same() {
        changesSteps.The_version_icons_order_are_the_same();
    }

}
