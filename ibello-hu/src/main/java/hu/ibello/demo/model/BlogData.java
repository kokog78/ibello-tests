package hu.ibello.demo.model;

import hu.ibello.core.Description;
import hu.ibello.core.Name;
import hu.ibello.data.Model;

@Model
@Name("Blog data")
public class BlogData {
  @Description("id generated from test data, is valid or not and is Hu or Eng")
  private String id;
  private String title;
  private String author;
  private String date;
  private String firstParagraph;
  private String expectedURL;
  private String howLongToRead;

  public String getId() {
    return id;
  }

  public String getHowLongToRead() {
    return howLongToRead;
  }

  public String getExpectedURL() {
    return expectedURL;
  }
  public String getFirstParagraph() {
    return firstParagraph;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public String getDate() {
    return date;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public String toString() {
    if (id != null) {
      return id;
    }
    return "No given id";
  }
}
