package hu.ibello.demo.panel;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.pages.PageObject;
import hu.ibello.search.By;
import hu.ibello.search.Find;
import hu.ibello.search.Relation;
import hu.ibello.search.RelationType;

@Name("Navigation bar panel")
public class NavigationBarPanel extends PageObject {

    @Find(by = By.ID, using = "menu") //CSS -> ID
    private WebElement menuComponent;

    @Find(by = By.CSS_SELECTOR, using = "a[href='#home-ibello']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CSS_SELECTOR, using = "menu-component")
    private WebElement productLink;

    @Find(by = By.CSS_SELECTOR, using = "a[href='#home-services']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CSS_SELECTOR, using = "menu-component")
    private WebElement servicesLink;

    @Find(by = By.CSS_SELECTOR, using = "a[href='#home-about']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CSS_SELECTOR, using = "menu-component")
    private WebElement aboutUsLink;

    @Find(by = By.CSS_SELECTOR, using = "a[href='#home-support']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CSS_SELECTOR, using = "menu-component")
    private WebElement supportLink;

    @Find(by = By.BUTTON_TEXT, using = "▼")
    private WebElement languageLink;

    @Find(by = By.CSS_SELECTOR, using = "a[title='magyar']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.ID, using = "language-selector")
    private WebElement hungarianLink;

    @Find(by = By.CSS_SELECTOR, using = "a[title='english']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.ID, using = "language-selector")
    private WebElement englishLink;

    @Find(by = By.CSS_SELECTOR, using = "a[href='/']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CSS_SELECTOR, using = "menu-component")
    private WebElement homeLink;

    @Find(by = By.CSS_SELECTOR, using = "a[href='product']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.ID, using = "menu")
    private WebElement productDirectLink;

    @Find(by = By.CSS_SELECTOR, using = "a[href='services']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.ID, using = "menu")
    private WebElement servicesDirectLink;

    @Find(by = By.CSS_SELECTOR, using = "a[href='about']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.ID, using = "menu")
    private WebElement aboutDirectLink;

    @Find(by = By.CSS_SELECTOR, using = "a[href='support']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.ID, using = "menu")
    private WebElement supportDirectLink;

    @Find(by = By.CSS_SELECTOR, using = "a[href='blog']")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.ID, using = "menu")
    private WebElement blogDirectLink;

    public void expect_menu_component_is_displayed() {
        expectations().expect(menuComponent).toBe().displayed();
    }

    public void click_product_link() {
        doWith(productLink).click();
    }

    public void click_services_link() {
        doWith(servicesLink).click();
    }

    public void click_about_us_link() {
        doWith(aboutUsLink).click();
    }

    public void click_support_link() {
        doWith(supportLink).click();
    }

    public void click_language_link() {
        doWith(languageLink).click();
    }

    public void click_hungarian_link() {
        doWith(hungarianLink).withPageRefreshWait().click();
    }

    public void click_english_link() {
        doWith(englishLink).withPageRefreshWait().click();
    }

    public void click_home_link() {
        doWith(homeLink).click();
    }

    public void click_product_direct_link() {
        doWith(productDirectLink).click();
    }

    public void click_services_direct_link() {
        doWith(servicesDirectLink).click();
    }

    public void click_about_direct_link() {
        doWith(aboutDirectLink).click();
    }

    public void click_support_direct_link() {
        doWith(supportDirectLink).click();
    }

    public void click_blog_direct_link() { doWith(blogDirectLink).click(); }

}
