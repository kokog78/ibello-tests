package hu.ibello.demo.workflow;

import hu.ibello.core.Name;
import hu.ibello.demo.model.LanguageDetail;
import hu.ibello.demo.model.Languages;
import hu.ibello.demo.model.VersionInfo;
import hu.ibello.demo.pages.ChangesPage;
import hu.ibello.demo.steps.LanguageSteps;
import hu.ibello.demo.steps.NavigationSteps;
import hu.ibello.steps.StepLibrary;

import java.util.*;
import java.util.stream.Collectors;

@Name("Product development")
public class ProductDevelopmentWorkflow extends StepLibrary {

    private NavigationSteps navigationSteps;
    private LanguageSteps languageSteps;

    private ChangesPage changesPage;

    private Map<String, List<VersionInfo>> languagesWithVersionInfos = null;

    public void I_am_on_product_development_page() {
        navigationSteps.I_open_the_homepage();
        navigationSteps.i_navigate_from_homepage_to_changes_page();
    }

    // Lehetne egy közös lépés, I_collect_the_version_info (van többesszáma angolul az infonak?)
    public void I_collect_the_version_numbers() {
        if (languagesWithVersionInfos == null) {
            // List<String> languages = betölteni a nyelveket egy listába getLanguages();
//            for (String l : languages) {
//                languageSteps.I_select_$_language(l);
//                az érintett steps osztályban összeállítani és visszaadni languagesWithVersionInfos mapet, itt lehet logolni a szükséges dolgokat
//            }
        }
        collectVersionInfo("version");
    }

//    @Name("I check if blablaba with ${1} number")
//    public void I_check_if_the_version_numbers_are_the_same(Map<String, List<VersionInfo>> map, int num) {
//
//    }

    public void The_version_numbers_are_the_same() {
        // Ez az ellenőrzés a steps osztályban legyen, add át neki a map-et
        Set<String> errorMessages = new HashSet<>();
        List<String> savedVersions = null;
        String savedLanguage = null;

        for(Map.Entry<String, List<VersionInfo>> entry: languagesWithVersionInfos.entrySet()) {
            List<String> actualVersions = entry.getValue().stream().map(VersionInfo::getVersionNumber).collect(Collectors.toList());
            if(savedVersions == null) {
                savedVersions = actualVersions;
                savedLanguage = entry.getKey();
            } else {
                if (!actualVersions.equals(savedVersions)) {
                    List<String> diff1 = new ArrayList<>(actualVersions);
                    List<String> diff2 = new ArrayList<>(savedVersions);
                    diff1.removeAll(savedVersions);
                    diff2.removeAll(actualVersions);
                    if (diff1.size() > 0) {
                        errorMessages.add(String.format("%s version(s) missing on %s language.", diff1, savedLanguage));
                    }
                    if (diff2.size() > 0) {
                        errorMessages.add(String.format("%s version(s) missing on %s language.", diff2, entry.getKey()));
                        savedVersions.addAll(diff2);
                        savedLanguage = entry.getKey();
                    }
                }
            }
        }
        /*results.forEach((key, value) ->  {
            List<String> versions = value.stream().map(VersionInfo::getVersionNumber).collect(Collectors.toList());
            results.forEach((key1, value1) ->  {
                if (!key.equals(key1)) {
                    List<String> anotherVersions = value1.stream().map(VersionInfo::getVersionNumber).collect(Collectors.toList());
                    if(!versions.equals(anotherVersions)) {
                        List<String> diff1 = new ArrayList<>(versions);
                        List<String> diff2 = new ArrayList<>(anotherVersions);
                        diff1.removeAll(anotherVersions);
                        diff2.removeAll(versions);
                        if(!diff1.isEmpty()) {
                            errorMessages.add(String.format("%s version(s) missing on %s language.", diff1, key1));
                        }
                        if(!diff2.isEmpty()) {
                            errorMessages.add(String.format("%s version(s) missing on %s language.", diff2, key));
                        }
                    }
                }
            });
        });
         */
        if(errorMessages.size() > 0) {
            throw new AssertionError(String.join("\r\n", errorMessages));
        }
    }

    public void I_collect_the_version_dates() {
        collectVersionInfo("date");
    }

    public void The_version_dates_are_the_same() {
        Set<String> errorMessages = new HashSet<>();
        List<String> savedDates = null;
        String savedLanguage = null;

        for(Map.Entry<String, List<VersionInfo>> entry: languagesWithVersionInfos.entrySet()) {
            List<String> actualDates = entry.getValue().stream().map(VersionInfo::getVersionDate).collect(Collectors.toList());
            if(savedDates == null) {
                savedDates = actualDates;
                savedLanguage = entry.getKey();
            } else {
                if (!actualDates.equals(savedDates)) {
                    List<String> diff1 = new ArrayList<>(actualDates);
                    List<String> diff2 = new ArrayList<>(savedDates);
                    diff1.removeAll(savedDates);
                    diff2.removeAll(actualDates);
                    if (diff1.size() > 0) {
                        errorMessages.add(String.format("%s date(s) missing on %s language.", diff1, savedLanguage));
                    }
                    if (diff2.size() > 0) {
                        errorMessages.add(String.format("%s date(s) missing on %s language.", diff2, entry.getKey()));
                        savedDates.addAll(diff2);
                        savedLanguage = entry.getKey();
                    }
                }
            }
        }

        /*
        results.forEach((key, value) ->  {
            List<String> dates = value.stream().map(VersionInfo::getVersionDate).collect(Collectors.toList());
            results.forEach((key1, value1) -> {
                if (!key.equals(key1)) {
                    List<String> anotherDates = value1.stream().map(VersionInfo::getVersionDate).collect(Collectors.toList());
                    if(!dates.equals(anotherDates)) {
                        List<String> diff1 = new ArrayList<>(dates);
                        List<String> diff2 = new ArrayList<>(anotherDates);
                        diff1.removeAll(anotherDates);
                        diff2.removeAll(dates);
                        if(diff1.size() > 0) {
                            errorMessages.add(String.format("%s date(s) missing on %s language.", diff1, key1));
                        }
                        if(diff2.size() > 0) {
                            errorMessages.add(String.format("%s date(s) missing on %s language.", diff2, key));
                        }
                    }
                }
            });
        });
        */
        if(errorMessages.size() > 0) {
            throw new AssertionError(String.join("\r\n", errorMessages));
        }
    }

    public void I_collect_the_version_descriptions() {
        collectVersionInfo(null);
    }

    public void The_version_descriptions_are_filled() {
        Set<String> errorMessages = new HashSet<>();
        languagesWithVersionInfos.forEach((key, value) -> value.forEach(versionInfo -> {
            if (versionInfo.getDescriptions().contains("")) {
                errorMessages.add(String.format("Description is missing on %s language at %s version.", key, versionInfo.getVersionNumber()));
            }
        }));
        if(errorMessages.size() > 0) {
            throw new AssertionError(String.join("\r\n", errorMessages));
        }
    }

    public void I_collect_the_version_changes() {
        collectVersionInfo(null);
    }

    public void The_ordering_of_version_changes_is_the_same() {
        Set<String> errorMessages = new HashSet<>(Collections.singletonList("Ordering differences: "));

        languagesWithVersionInfos.forEach((key, value) -> {
            Map<String, List<String>> versionsWithIcons = value.stream().collect(Collectors.toMap(VersionInfo::getVersionNumber, VersionInfo::getIconNames));
            languagesWithVersionInfos.forEach((key1, value1) -> {
                if (!key.equals(key1)) {
                    Map<String, List<String>> anotherVersionsWithIcons = value1.stream().collect(Collectors.toMap(VersionInfo::getVersionNumber, VersionInfo::getIconNames));
                    versionsWithIcons.forEach((key2, value2) -> {
                        if (!value2.equals((anotherVersionsWithIcons.get(key2)))) {
                            errorMessages.add(String.format("%s [%s] - %s [%s] at version: %s.", key, value2, key1, anotherVersionsWithIcons.get(key2), key2));
                        }
                    });
                }
            });
        });
        if(errorMessages.size() > 1) {
            throw new AssertionError(String.join("\r\n", errorMessages));
        }
    }

    private void collectVersionInfo(String whatToOutput) {
        if(languagesWithVersionInfos == null) {
            testData().fromJson(LanguageDetail.class).load().languageDetails.forEach(detail -> {
                languageSteps.I_select_$_language(Languages.valueOf(detail.getLanguage()));
                changesPage.I_collect_the_version_infos_on_$_language(detail.getLanguage(), detail.getVersionPrefix());
                if(whatToOutput != null) {
                    List<String> output = changesPage
                            .getLanguagesWithVersionInfos()
                            .get(detail.getLanguage())
                            .stream()
                            .map(versionInfo -> versionInfo.getInfo(whatToOutput))
                            .collect(Collectors.toList());
                    output().recordCustomAction(output.toString());
                }
            });
            languagesWithVersionInfos = changesPage.getLanguagesWithVersionInfos();
        }
    }
}
