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

  public void based_on_$_test_data_i_select_a_blog_post(BlogData data){
    blogPage.I_click_on_$_title_article(data.getTitle());
  }

  private BlogData loadBlogData(String id) {
    BlogData data = testData().fromJson(BlogData.class).withId(id).load();
    data.setId(id);
    return data;
  }

  public void the_$_blog_post_looks_well(BlogData data){
    blogArticlePage.setCurrentUrl();
    blogArticlePage.expect_url_is_$(data.getExpectedURL());
    blogArticlePage.assert_first_paragraph(data.getFirstParagraph());
    blogArticlePage.assert_author_is_correct_$(data.getAuthor());
    blogArticlePage.assert_reading_time_is_correct_$(data.getHowLongToRead());
  }
  public void assert_number_of_recommendations(){
    blogArticlePage.assert_number_of_recommendations_is_at_least_$(1);
  }
}
