package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;

import java.util.List;
import java.util.stream.Collectors;

@Name("Changes Page")
public class ChangesPage extends AbstractPage {

    private final String url = "/changes";

    @Find(by = By.CSS_SELECTOR, using = "title-lane[key='titles.changes']")
    private WebElement changesTitle;

    @Override
    public void I_am_on_the_page() {
        expect_url_is_$(url);
        expectations().expect(changesTitle).toBe().displayed();
    }

    public List<String> getProductVersions(String prefix) {
        return find()
                .using(By.CSS_SELECTOR, ".change-version > span:first-child")
                .all()
                .stream()
                .map(version -> get(version).text().replace(prefix, ""))
                .collect(Collectors.toList());
    }

    public List<String> getProductVersionDates() {
        return find()
                .using(By.CSS_SELECTOR, ".change-date")
                .all()
                .stream()
                .map(versionDate -> get(versionDate).text())
                .collect(Collectors.toList());
    }

    public List<String> getProductVersionChangesDescription() {
        return find()
                .using(By.CSS_SELECTOR, ".change-item-texts")
                .all()
                .stream()
                .map(desc -> get(desc).text())
                .collect(Collectors.toList());
    }

    public List<String> getProductVersionIcons() {
        return find()
                .using(By.CSS_SELECTOR, ".change-item > i")
                .all()
                .stream()
                .map(icon -> get(icon).text())
                .collect(Collectors.toList());
    }
}
