package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;
import hu.ibello.search.Relation;
import hu.ibello.search.RelationType;

@Name ("Blog page")

public class BlogPage extends AbstractPage {

  private static final String url = "/blog";

  @Find(by = By.CSS_SELECTOR, using = "h1")
  private WebElement blogTitle;

  @Find(by = By.TEXT, using = "${0}")
  @Relation(type = RelationType.DESCENDANT_OF, by = By.CSS_SELECTOR, using = ".blog-items")
  private WebElement blogPost;

  @Override
  public void I_am_on_the_page() {
    expect_url_is_$(url);
    expectations().expect(blogTitle).toBe().displayed();
  }

  public void I_click_on_$_title_article(String title) {
    doWith(blogPost.applyParameters(title)).click();
  }

}
