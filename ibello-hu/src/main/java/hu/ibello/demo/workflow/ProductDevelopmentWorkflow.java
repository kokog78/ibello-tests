package hu.ibello.demo.workflow;

import hu.ibello.core.Name;
import hu.ibello.demo.model.Languages;
import hu.ibello.demo.model.VersionInfo;
import hu.ibello.demo.steps.ChangesSteps;
import hu.ibello.demo.steps.LanguageSteps;
import hu.ibello.demo.steps.NavigationSteps;
import hu.ibello.steps.StepLibrary;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Name("Product development")
public class ProductDevelopmentWorkflow extends StepLibrary {

    private NavigationSteps navigationSteps;
    private LanguageSteps languageSteps;
    private ChangesSteps changesSteps;

    private Map<String, List<VersionInfo>> languagesWithVersionInfo = new LinkedHashMap<>();

    public void I_am_on_product_development_page() {
        navigationSteps.I_open_the_homepage();
        navigationSteps.i_navigate_from_homepage_to_changes_page();
    }

    public void I_collect_the_version_info() {
        if(languagesWithVersionInfo.isEmpty()) {
            for(Languages language: Languages.values()) {
                languageSteps.I_select_$_language(language);
                List<VersionInfo> versionInfo = changesSteps.I_collect_the_version_infos_on_$_language(language.toString());
                languagesWithVersionInfo.put(language.toString(), versionInfo);
            }
        }
    }

    public void The_version_numbers_are_the_same() {
        changesSteps.The_version_numbers_are_the_same(languagesWithVersionInfo);
    }

    public void The_version_dates_are_the_same() {
        changesSteps.The_version_dates_are_the_same(languagesWithVersionInfo);
    }

    public void The_version_descriptions_are_filled() {
        changesSteps.The_version_descriptions_are_filled(languagesWithVersionInfo);
    }

    public void The_ordering_of_version_changes_is_the_same() {
        changesSteps.The_ordering_of_version_changes_is_the_same(languagesWithVersionInfo);
    }
}
