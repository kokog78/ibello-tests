package hu.ibello.demo.steps;

import hu.ibello.core.Internal;
import hu.ibello.core.Name;
import hu.ibello.demo.model.LanguageSelection;
import hu.ibello.demo.pages.HomePage;
import hu.ibello.demo.panel.NavigationBarPanel;
import hu.ibello.steps.StepLibrary;

import java.util.List;

@Name("Language steps")
public class LanguageSteps extends StepLibrary {

    private HomePage homePage;
    private NavigationBarPanel navigationBar;

    public void based_on_$_test_data_i_check_if_the_language_is_default(LanguageSelection data) {
        check_texts_based_on_$_test_data_with_$_boolean(data, true);
    }

    public void based_on_$_test_data_i_check_if_the_language_is_changed(LanguageSelection data) {
        check_texts_based_on_$_test_data_with_$_boolean(data, false);
    }

    public void based_on_$_test_data_i_select_other_language(LanguageSelection data) {
        i_select_language_based_on_$_test_data_with_$_boolean(data, false);
    }

    public void based_on_$_test_data_i_select_the_default_language(LanguageSelection data) {
        i_select_language_based_on_$_test_data_with_$_boolean(data, true);
    }

    @Internal
    public void i_select_language_based_on_$_test_data_with_$_boolean(LanguageSelection data, boolean isDefault) {
        if (data != null && data.getLanguage() != null) {
            navigationBar.click_language_link();
            switch (data.getLanguage()) {
                case HUNGARIAN:
                    if (isDefault) {
                        navigationBar.click_english_link();
                    } else {
                        navigationBar.click_hungarian_link();
                    }
                    break;
                case ENGLISH:
                    if (isDefault) {
                        navigationBar.click_hungarian_link();
                    } else {
                        navigationBar.click_english_link();
                    }
                    break;
                default:
                    break;
            }
        } else {
            throw new AssertionError("Testdata is null!");
        }
    }

    @Internal
    public void check_texts_based_on_$_test_data_with_$_boolean(LanguageSelection data, boolean isDefault) {
        if (data != null && data.getLanguage() != null && data.getHungarianTexts() != null
                && data.getEnglishTexts() != null) {
            switch (data.getLanguage()) {
                case HUNGARIAN:
                    if (isDefault) {
                        list_is_displayed(data.getEnglishTexts());
                        list_is_not_displayed(data.getHungarianTexts());
                    } else {
                        list_is_displayed(data.getHungarianTexts());
                        list_is_not_displayed(data.getEnglishTexts());
                    }
                case ENGLISH:
                    if (isDefault) {
                        list_is_displayed(data.getHungarianTexts());
                        list_is_not_displayed(data.getEnglishTexts());
                    } else {
                        list_is_displayed(data.getEnglishTexts());
                        list_is_not_displayed(data.getHungarianTexts());
                    }
                    break;
                default:
                    break;
            }
        } else {
            throw new AssertionError("One or more testdata are null!");
        }
    }

    private void list_is_displayed(List<String>displayedList) {
        for (String text : displayedList) {
            homePage.assume_$_text_is_displayed(text);
        }
    }

    private void list_is_not_displayed(List<String>notDisplayedList) {
        for (String text : notDisplayedList) {
            homePage.assume_$_text_is_not_displayed(text);
        }
    }

}
