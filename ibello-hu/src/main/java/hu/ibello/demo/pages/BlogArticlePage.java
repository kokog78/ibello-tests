package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
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

  public void setCurrentURL() {
    this.currentURL = browser().getURL();
  }

  @Override
  public void i_am_on_the_page() {
    expect_url_is_$(currentURL);
  }

  public void assert_first_paragraph_of_$_article(String textToCheck){
    expectations().assume(firstParagraph).toHave().text(textToCheck);
  }

  public void assert_author(String textToCheck){
    expectations().assume(author).toHave().text(textToCheck);
  }

  public void assert_reading_time_of_$_article(String textToCheck){
    expectations().assume(readingTime).toHave().text(textToCheck);
  }
}
