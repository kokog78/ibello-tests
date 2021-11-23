package hu.ibello.demo.workflow;

import hu.ibello.core.Name;
import hu.ibello.demo.model.BlogData;
import hu.ibello.demo.model.LanguageSelection;
import hu.ibello.demo.steps.BlogSteps;
import hu.ibello.demo.steps.LanguageSteps;
import hu.ibello.demo.steps.NavigationSteps;
import hu.ibello.steps.StepLibrary;

@Name("Blog")
public class BlogWorkflow extends StepLibrary {
  private NavigationSteps navigationSteps;
  private BlogSteps blogSteps;
  private LanguageSteps languageSteps;
  private BlogData blogData;
  private LanguageSelection languageSelectionData;
  private String language;

  public void I_am_on_homepage() {
    navigationSteps.i_open_the_homepage();
  }

  public void The_current_language_is_hungarian() {
    language = "hungarian";
    setLanguageToHun();

  }

  public void I_change_the_language_to_english() {
    language = "english";
    setLanguageToEng();
  }

  public void I_go_to_the_blogpage() {
    navigationSteps.i_navigate_from_homepage_to_the_blog_page();
  }

  public void I_select_a_blogpost() {
    if (language.contains("english")) {
      blogData = loadBlogData("englishValid");
    }
    if (language.contains("hungarian")) {
      blogData = loadBlogData("hungarianValid");
    } else {
      throw new AssertionError("Please check the language selector");
    }
    blogSteps.based_on_$_test_data_i_select_a_blog_post(blogData);
  }

  public void The_selected_post_looks_well() {
    blogSteps.the_$_blog_post_looks_well(blogData);
  }

  public void The_recommendation_is_there() {
    // TO DEVELOP
  }

  private BlogData loadBlogData(String id) {
    BlogData blogData = testData().fromJson(BlogData.class).withId(id).load();
    blogData.setId(id);
    return blogData;
  }

  private LanguageSelection languageSelection(String id) {
    languageSelectionData = testData().fromJson(LanguageSelection.class).withId(id).load();
    return languageSelectionData;
  }

  private void setLanguageToHun() {
    languageSelectionData = languageSelection("0");
    languageSteps.based_on_$_test_data_i_select_the_default_language(languageSelectionData);
    languageSelectionData = languageSelection("2");
    languageSteps.based_on_$_test_data_i_check_if_the_language_is_default(languageSelectionData);
  }

  private void setLanguageToEng() {
    languageSelectionData = languageSelection("1");
    languageSteps.based_on_$_test_data_i_select_the_default_language(languageSelectionData);
    languageSelectionData = languageSelection("2");
    languageSteps.based_on_$_test_data_i_check_if_the_language_is_changed(languageSelectionData);
  }
}

