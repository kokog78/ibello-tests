package hu.ibello.demo.steps;

import hu.ibello.core.Name;
import hu.ibello.demo.model.Languages;
import hu.ibello.demo.pages.ChangesPage;
import hu.ibello.steps.StepLibrary;

import java.util.ArrayList;
import java.util.List;

@Name("Changes steps")
public class ChangesSteps extends StepLibrary {

    private ChangesPage changesPage;
    private LanguageSteps languageSteps;

    public void I_see_the_changes_are_described() {
        List<String> descriptions = new ArrayList<>();
        languageSteps.I_select_$_language(Languages.HUNGARIAN);
        descriptions.addAll(changesPage.getProductVersionChangesDescription());
        languageSteps.I_select_$_language(Languages.ENGLISH);
        descriptions.addAll(changesPage.getProductVersionChangesDescription());
        I_see_all_the_changes_are_described(descriptions);
    }

    public void I_see_all_the_changes_are_described(List<String> descriptions) {
        if(descriptions.contains("") || descriptions.contains(null)) {
            throw new AssertionError("Not all changes are described!");
        }
    }

    public void I_compare_the_version_dates() {
        List<String> hungarianVersionDates;
        List<String> englishVersionDates;
        languageSteps.I_select_$_language(Languages.HUNGARIAN);
        hungarianVersionDates = changesPage.getProductVersionDates();
        languageSteps.I_select_$_language(Languages.ENGLISH);
        englishVersionDates = changesPage.getProductVersionDates();
        I_compare_the_dates(hungarianVersionDates, englishVersionDates);
    }

    public void I_compare_the_dates(List<String> hungarianVersionDates, List<String> englishVersionDates) {
        if(hungarianVersionDates.size() != englishVersionDates.size() || !hungarianVersionDates.equals(englishVersionDates)) {
            throw new AssertionError("Version dates are not the same.");
        }
    }

    public void I_compare_the_version_numbers() {
        List<String> hungarianVersions;
        List<String> englishVersions;
        languageSteps.I_select_$_language(Languages.HUNGARIAN);
        hungarianVersions = changesPage.getProductVersions(getConfigurationValue("ChangesPage.hu.versionNumberPrefix").toString());
        languageSteps.I_select_$_language(Languages.ENGLISH);
        englishVersions = changesPage.getProductVersions(getConfigurationValue("ChangesPage.en.versionNumberPrefix").toString());
        I_compare_the_versions(hungarianVersions, englishVersions);
    }

    public void I_compare_the_versions(List<String> hungarianVersions, List<String> englishVersions) {
        if(hungarianVersions.size() != englishVersions.size() || !hungarianVersions.equals(englishVersions)) {
            throw new AssertionError("Versions are not the same.");
        }
    }

    public void I_compare_the_icons_order() {
        List<String> hungarianIcons;
        List<String> englishIcons;
        languageSteps.I_select_$_language(Languages.HUNGARIAN);
        hungarianIcons = changesPage.getProductVersionIcons();
        languageSteps.I_select_$_language(Languages.ENGLISH);
        englishIcons = changesPage.getProductVersionIcons();
        I_compare_the_order(hungarianIcons, englishIcons);
    }

    public void I_compare_the_order(List<String> hungarianIcons, List<String> englishIcons) {
        if(hungarianIcons.size() != englishIcons.size() || !hungarianIcons.equals(englishIcons)) {
            throw new AssertionError("Version changes order are not the same.");
        }
    }
}
