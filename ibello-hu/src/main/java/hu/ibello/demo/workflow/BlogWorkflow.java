package hu.ibello.demo.workflow;

import hu.ibello.core.Name;
import hu.ibello.core.TestException;
import hu.ibello.demo.model.BlogData;
import hu.ibello.demo.model.Languages;
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
  private Languages language;

  public void I_am_on_homepage() {
    navigationSteps.i_open_the_homepage();
  }

  public void The_current_language_is_hungarian() {
    language = Languages.HUNGARIAN;
    setLanguageToHun();
  }

  public void I_change_the_language_to_english() {
    language = Languages.ENGLISH;
    setLanguageToEng();
  }

  public void I_go_to_the_blogpage() {
    navigationSteps.i_navigate_from_homepage_to_the_blog_page();
  }

  public void I_select_a_blogpost() {
    if (language == null) {
      throw new TestException("Language is null");
    }
    blogData = loadBlogData(language.toString()+"Valid");
    blogSteps.based_on_$_test_data_i_select_a_blog_post(blogData);
  }

  public void The_selected_post_looks_well() {
    blogSteps.the_$_blog_post_looks_well(blogData);
  }

  public void The_recommendation_is_there() {
    blogSteps.assert_number_of_recommendations_is_more_than_1();
  }

  private BlogData loadBlogData(String id) {
    BlogData blogData = testData().fromJson(BlogData.class).withId(id).load();
    blogData.setId(id);
    return blogData;
  }

  private void setLanguageToHun() {
    languageSteps.i_select_$_language(Languages.HUNGARIAN);
  }

  private void setLanguageToEng() {
    languageSteps.i_select_$_language(Languages.ENGLISH);
  }
}

