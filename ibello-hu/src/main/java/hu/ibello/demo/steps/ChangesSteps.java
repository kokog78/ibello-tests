package hu.ibello.demo.steps;

import hu.ibello.core.Name;
import hu.ibello.core.TestException;
import hu.ibello.demo.model.Languages;
import hu.ibello.demo.pages.ChangesPage;
import hu.ibello.steps.StepLibrary;

import java.util.ArrayList;
import java.util.List;

@Name("Changes steps")
public class ChangesSteps extends StepLibrary {

    private ChangesPage changesPage;
    private LanguageSteps languageSteps;

    List<String> hungarianVersions;
    List<String> englishVersions;
    List<String> hungarianVersionDates;
    List<String> englishVersionDates;
    List<String> hungarianIcons;
    List<String> englishIcons;
    List<String> descriptions = new ArrayList<>();

    public void I_compare_the_version_numbers() {
        languageSteps.I_select_$_language(Languages.HUNGARIAN);
        hungarianVersions = changesPage.getProductVersions(getConfigurationValue("ChangesPage.hu.versionNumberPrefix").toString());
        languageSteps.I_select_$_language(Languages.ENGLISH);
        englishVersions = changesPage.getProductVersions(getConfigurationValue("ChangesPage.en.versionNumberPrefix").toString());
    }
    public void The_version_numbers_are_same() {
        if(hungarianVersions.isEmpty() || englishVersions.isEmpty()) {
            throw new TestException("One language versions not loaded.");
        }
        if(hungarianVersions.size() != englishVersions.size() || !hungarianVersions.equals(englishVersions)) {
            throw new AssertionError("Versions are not the same.");
        }
    }

    public void I_compare_the_release_dates() {
        languageSteps.I_select_$_language(Languages.HUNGARIAN);
        hungarianVersionDates = changesPage.getProductVersionDates();
        languageSteps.I_select_$_language(Languages.ENGLISH);
        englishVersionDates = changesPage.getProductVersionDates();
    }
    public void The_version_dates_are_same() {
        if(hungarianVersionDates.isEmpty() || englishVersionDates.isEmpty()) {
            throw new TestException("One language versions not loaded.");
        }
        if(hungarianVersionDates.size() != englishVersionDates.size() || !hungarianVersionDates.equals(englishVersionDates)) {
            throw new AssertionError("Version dates are not the same.");
        }
    }

    public void I_see_the_descriptions() {
        languageSteps.I_select_$_language(Languages.HUNGARIAN);
        descriptions.addAll(changesPage.getProductVersionChangesDescription());
        languageSteps.I_select_$_language(Languages.ENGLISH);
        descriptions.addAll(changesPage.getProductVersionChangesDescription());
    }
    public void The_version_changes_are_described() {
        if(descriptions.isEmpty()) {
            throw new TestException("Details are not loaded!");
        }
        if(descriptions.contains("") || descriptions.contains(null)) {
            throw new AssertionError("Not all changes are described!");
        }
    }

    public void I_compare_the_icons_order() {
        languageSteps.I_select_$_language(Languages.HUNGARIAN);
        hungarianIcons = changesPage.getProductVersionIcons();
        languageSteps.I_select_$_language(Languages.ENGLISH);
        englishIcons = changesPage.getProductVersionIcons();
    }
    public void The_icons_order_are_same() {
        if(hungarianIcons.isEmpty() || englishIcons.isEmpty()) {
            throw new TestException("One language versions not loaded.");
        }
        if(hungarianIcons.size() != englishIcons.size() || !hungarianIcons.equals(englishIcons)) {
            throw new AssertionError("Version changes order are not the same.");
        }
    }
}
