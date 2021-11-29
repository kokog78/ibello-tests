package hu.ibello.demo.steps;

import hu.ibello.core.Internal;
import hu.ibello.core.Name;
import hu.ibello.core.TestException;
import hu.ibello.demo.model.LanguageSelection;
import hu.ibello.demo.model.Languages;
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
        checkTestData(data);
        I_select_$_language(data.getLanguage());
    }

    public void based_on_$_test_data_i_select_the_default_language(LanguageSelection data) {
        checkTestData(data);
        I_select_$_language(data.getOtherLanguage());
    }

    private void checkTestData(LanguageSelection data){
        if(data==null){
            throw new TestException("Test data is null");
        }
    }

    @Internal
    public void I_select_$_language(Languages language) {
        if (language != null) {
            navigationBar.click_language_link();
            switch (language) {
                case HUNGARIAN:
                    navigationBar.click_hungarian_link();
                    break;
                case ENGLISH:
                    navigationBar.click_english_link();
                    break;
                default:
                    break;
            }
        } else {
            throw new TestException("Language is not specified!");
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
            throw new TestException("Language is not specified!");
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
