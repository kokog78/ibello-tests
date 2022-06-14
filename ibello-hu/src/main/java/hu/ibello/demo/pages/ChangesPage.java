package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.demo.model.VersionInfo;
import hu.ibello.elements.WebElement;
import hu.ibello.elements.WebElements;
import hu.ibello.search.By;
import hu.ibello.search.Find;

import java.util.ArrayList;
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

    public List<VersionInfo> collectVersionInfo() {
        List<VersionInfo> versionInfo = new ArrayList<>();
        for(WebElement section: getChangesSections()) {
            versionInfo.add(getVersionInfo(section));
        }
        return versionInfo;
    }

    private VersionInfo getVersionInfo(WebElement section) {
        VersionInfo versionInfo = new VersionInfo();
        versionInfo.setVersionNumber(getVersionNumber(section));
        versionInfo.setVersionDate(getVersionDate(section));
        versionInfo.setDescriptions(getVersionDescriptions(section));
        versionInfo.setIconNames(getVersionIcons(section));
        return versionInfo;
    }

    public WebElements getChangesSections() {
        return find()
                .using(By.CSS_SELECTOR, ".change-section")
                .all();
    }

    public String getVersionNumber(WebElement section) {
        WebElement versionElement = section
                .find()
                .using(By.CSS_SELECTOR, ".change-version > span:first-child")
                .first();
        return get(versionElement).text().split(": ")[1];
    }

    public String getVersionDate(WebElement section) {
        WebElement versionElement = section
                .find()
                .using(By.CSS_SELECTOR, ".change-date")
                .first();
        return get(versionElement).text();
    }

    public List<String> getVersionDescriptions(WebElement section) {
        return section
                .find()
                .using(By.CSS_SELECTOR, ".change-item > .change-item-texts")
                .all()
                .stream()
                .map(desc -> get(desc).text())
                .collect(Collectors.toList());
    }

    public List<String> getVersionIcons(WebElement section) {
        return section
                .find()
                .using(By.CSS_SELECTOR, ".change-item > i")
                .all()
                .stream()
                .map(icon -> get(icon).text())
                .collect(Collectors.toList());
    }
}
