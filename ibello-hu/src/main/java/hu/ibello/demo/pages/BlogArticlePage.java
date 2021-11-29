package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.elements.WebElements;
import hu.ibello.search.By;
import hu.ibello.search.Find;

@Name("Blog article name")
public class BlogArticlePage extends AbstractPage {
  private String currentURL;

  @Find(by = By.CSS_SELECTOR, using = "h1")
  private WebElement blogTitle;

  @Find(by = By.CSS_SELECTOR, using = "article h1 + p")
  private WebElement firstParagraph;

  @Find(by = By.CSS_SELECTOR, using = ".author")
  private WebElement author;

  @Find(by = By.CSS_SELECTOR, using = "header time + div")
  private WebElement  readingTime;

  @Find(by = By.CSS_SELECTOR, using = "blog-link-lane a[href^=blog-]")
  private WebElements recommendations;

  public void setCurrentUrl() {
    this.currentURL = browser().getURL();
  }

  @Override
  public void I_am_on_the_page() {
    expect_url_is_$(currentURL);
  }

  public void assert_first_paragraph(String textToCheck){
    expectations().assume(firstParagraph).toHave().text(textToCheck);
  }

  public void assert_author_is_correct_$(String textToCheck){
    expectations().assume(author).toHave().text(textToCheck);
  }

  public void assert_reading_time_is_correct_$(String textToCheck){
    expectations().assume(readingTime).toHave().text(textToCheck);
  }
  public void assert_number_of_recommendations_is_at_least_$(int numberOfRecommendedBlogpost){
    expectations().assume(recommendations).toHave().sizeGreaterThan(numberOfRecommendedBlogpost-1);
  }
}
