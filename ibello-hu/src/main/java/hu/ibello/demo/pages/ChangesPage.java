package hu.ibello.demo.pages;

import hu.ibello.core.Name;
import hu.ibello.demo.model.VersionInfo;
import hu.ibello.elements.WebElement;
import hu.ibello.elements.WebElements;
import hu.ibello.search.By;
import hu.ibello.search.Find;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Name("Changes Page")
public class ChangesPage extends AbstractPage {

    private final String url = "/changes";
    private Map<String, List<VersionInfo>> languagesWithVersionInfos = new LinkedHashMap<>();

    @Find(by = By.CSS_SELECTOR, using = "title-lane[key='titles.changes']")
    private WebElement changesTitle;

    @Override
    public void I_am_on_the_page() {
        expect_url_is_$(url);
        expectations().expect(changesTitle).toBe().displayed();
    }

    public Map<String, List<VersionInfo>> getLanguagesWithVersionInfos() {
        return languagesWithVersionInfos;
    }

    public void I_collect_the_version_infos_on_$_language(String language, String prefix) {

        List<VersionInfo> versionInfos = new ArrayList<>();

        getChangesSections().forEach(section -> {
            VersionInfo versionInfo = new VersionInfo();
            versionInfo.setVersionNumber(getVersionNumber(prefix, section));
            versionInfo.setVersionDate(getVersionDate(section));
            versionInfo.setDescriptions(getVersionDescriptions(section));
            versionInfo.setIconNames(getVersionIcons(section));
            versionInfos.add(versionInfo);
        });

        languagesWithVersionInfos.put(language, versionInfos);
    }

    public WebElements getChangesSections() {
        return find()
                .using(By.CSS_SELECTOR, ".change-section")
                .all();
    }

    public String getVersionNumber(String prefix, WebElement section) {
//        Pattern p = Pattern.compile("^.+:+\\s+(\\d+.\\d.+\\d+)$");
        WebElement versionElement = section
                .find()
                .using(By.CSS_SELECTOR, ".change-version > span:first-child")
                .first();
        return get(versionElement).text().replace(prefix, "");
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
