package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.elements.WebElements;
import hu.ibello.search.By;
import hu.ibello.search.Find;
import hu.ibello.search.Relation;
import hu.ibello.search.RelationType;

@Name("Sitemap page")
public class SitemapPage extends AbstractPage {

    private final String url = "/sitemap";

    @Find(by = By.CSS_SELECTOR, using = "a[href='https://ibello.hu/szmd']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "links")
    private WebElement lovelyJobsAwardButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='https://ibello.hu/questions-manager']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "links")
    private WebElement questionsAndAnswersButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='https://ibello.hu/changes']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "links")
    private WebElement changesButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='https://ibello.hu/news-ibello-gradle-plugin']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "links")
    private WebElement gradlePluginButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='https://ibello.hu/home']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "links")
    private WebElement homepageButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='https://ibello.hu/all-docs']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "links")
    private WebElement documentationsButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='https://ibello.hu/download']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "links")
    private WebElement downloadButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='https://ibello.hu/pricing-details']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "links")
    private WebElement productDetailsButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='https://ibello.hu/service-details']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "links")
    private WebElement serviceDetailsButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='https://ibello.hu/order']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "links")
    private WebElement orderButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='https://ibello.hu/quotation']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "links")
    private WebElement quotationButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='https://ibello.hu/product']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "links")
    private WebElement productButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='https://ibello.hu/services']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "links")
    private WebElement servicesButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='https://ibello.hu/support']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "links")
    private WebElement supportButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='https://ibello.hu/about']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "links")
    private WebElement aboutButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='https://ibello.hu/landing-test-automation']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "links")
    private WebElement testAutomationButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='https://ibello.hu/unsubscribe']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "links")
    private WebElement unsubscribeButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='https://ibello.hu/clients/#login']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "links")
    private WebElement loginButton;

    @Find(by = By.CSS_SELECTOR, using = "a[href='https://ibello.hu/clients/#registration']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "links")
    private WebElement registrationButton;

    @Find(by = By.CSS_SELECTOR, using = "sitemap-links-lane")
    private WebElement sitemapLane;

    @Override
    public void I_am_on_the_page() {
        expect_url_is_$("/sitemap");
        expectations().expect(sitemapLane).toBe().displayed();
    }

    public void i_am_not_on_the_page(){
        expect_url_is_not_$(url);
        expectations().expect(sitemapLane).toNotBe().displayed();
    }

    public void i_open_sitemap_page() {
        browser().resize(2000, 1000);
        browser().openURL("/sitemap");
        browser().maximize();
    }

    public int get_link_count(){
        WebElements allLinks = find().using(".links a").all();
        expectations().expect(allLinks).toHave().sizeGreaterThan(0);
        return allLinks.size();
    }

    public void click_link_$(int index){
        WebElement link = find().using(".links a").nth(index);
        doWith(link).click();
    }

    public String get_link(int index){
        WebElement link = find().using(".links a").nth(index);
        return get(link).attribute("href");
    }
}
