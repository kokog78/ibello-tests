package hu.ibello.demo.steps;

import hu.ibello.core.Name;
import hu.ibello.demo.model.BlogData;
import hu.ibello.demo.pages.BlogArticlePage;
import hu.ibello.demo.pages.BlogPage;
import hu.ibello.steps.StepLibrary;

@Name("Blog steps")
public class BlogSteps extends StepLibrary {
  private BlogPage blogPage;
  private BlogArticlePage blogArticlePage;

  public void based_on_$_test_data_I_select_a_blog_post(BlogData data){
    blogPage.I_click_on_$_title_article(data.getTitle());
  }

  private BlogData loadBlogData(String id) {
    BlogData data = testData().fromJson(BlogData.class).withId(id).load();
    data.setId(id);
    return data;
  }

  public void based_on_$_test_data_I_check_if_blog_post_looks_well(BlogData data){
    blogArticlePage.set_current_url();
    blogArticlePage.expect_url_is_$(data.getExpectedURL());
    blogArticlePage.assert_that_first_paragraph_is_$(data.getFirstParagraph());
    blogArticlePage.assert_that_author_is_$(data.getAuthor());
    blogArticlePage.assert_that_reading_time_is_$(data.getHowLongToRead());
  }
  public void assert_number_of_recommendations(){
    blogArticlePage.assert_number_of_recommendations_is_at_least_$(1);
  }
}
