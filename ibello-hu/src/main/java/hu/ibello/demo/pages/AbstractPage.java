package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.pages.PageObject;

@Name("Abstract Page")
public abstract class AbstractPage extends PageObject {

    public void expect_url_is_$(String url) {
        expectations().assume(browser()).toHave().url(url);
    }

}
