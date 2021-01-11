package hu.ibello.demo.pages;

import hu.ibello.pages.PageObject;

import java.util.regex.Pattern;

public abstract class AbstractPage extends PageObject {

    public void expect_url_is_$(String url) {
        Pattern pattern = Pattern.compile(url + ".*");
        expectations().assume(browser()).toHave().url(pattern);
    }

    protected void expect_url_is_not_$(String url) {
        Pattern pattern = Pattern.compile(url + ".*");
        expectations().assume(browser()).toNotHave().url(pattern);
    }


}
