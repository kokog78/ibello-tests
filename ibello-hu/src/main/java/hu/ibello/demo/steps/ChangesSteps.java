package hu.ibello.demo.steps;

import hu.ibello.core.Name;
import hu.ibello.demo.model.LanguageDetail;
import hu.ibello.demo.model.Languages;
import hu.ibello.demo.model.VersionInfo;
import hu.ibello.demo.pages.ChangesPage;
import hu.ibello.steps.StepLibrary;

import java.util.*;
import java.util.stream.Collectors;

@Name("Changes")
public class ChangesSteps extends StepLibrary {

    private ChangesPage changesPage;
    private LanguageSteps languageSteps;

    public void I_collect_the_version_numbers() {
        I_collect_the_version_infos_on_all_language("version");
    }
    public void I_collect_the_version_dates() {
        I_collect_the_version_infos_on_all_language("dates");
    }
    public void I_collect_the_version_descriptions() {
        I_collect_the_version_infos_on_all_language(null);
    }
    public void I_collect_the_version_icons() {
        I_collect_the_version_infos_on_all_language(null);
    }

    public void The_version_numbers_are_the_same() {
        Map<String, List<VersionInfo>> results = changesPage.getLanguagesWithVersionInfos();
        Set<String> errorMessages = new HashSet<>();
        for(Map.Entry<String, List<VersionInfo>> entry: results.entrySet()) {
            List<String> versions = entry.getValue()
                    .stream()
                    .map(VersionInfo::getVersionNumber)
                    .collect(Collectors.toList());
            for(Map.Entry<String, List<VersionInfo>> nextEntry: results.entrySet()) {
                if (!entry.getKey().equals(nextEntry.getKey())) {
                    List<String> anotherVersions = nextEntry.getValue()
                            .stream()
                            .map(VersionInfo::getVersionNumber)
                            .collect(Collectors.toList());
                    if(!versions.equals(anotherVersions)) {
                        List<String> diff1 = new ArrayList<>(versions);
                        List<String> diff2 = new ArrayList<>(anotherVersions);
                        diff1.removeAll(anotherVersions);
                        diff2.removeAll(versions);
                        if(!diff1.isEmpty()) {
                            errorMessages.add(String.format("%s version(s) missing on %s language.\n", diff1, nextEntry.getKey()));
                        }
                        if(!diff2.isEmpty()) {
                            errorMessages.add(String.format("%s version(s) missing on %s language.\n", diff2, entry.getKey()));
                        }
                    }
                }
            }
        }
        if(errorMessages.size() > 0) {
            throw new AssertionError(String.join("\n", errorMessages));
        }
    }

    public void The_version_dates_are_the_same() {

        Map<String, List<VersionInfo>> results = changesPage.getLanguagesWithVersionInfos();
        Set<String> errorMessages = new HashSet<>();

        for(Map.Entry<String, List<VersionInfo>> entry: results.entrySet()) {
            List<String> dates = entry
                    .getValue()
                    .stream()
                    .map(VersionInfo::getVersionDate)
                    .collect(Collectors.toList());
            for(Map.Entry<String, List<VersionInfo>> nextEntry: results.entrySet()) {
                if (!entry.equals(nextEntry)) {
                    List<String> anotherDates = nextEntry
                            .getValue()
                            .stream()
                            .map(VersionInfo::getVersionDate)
                            .collect(Collectors.toList());
                    if(!dates.equals(anotherDates)) {
                        List<String> diff1 = new ArrayList<>(dates);
                        List<String> diff2 = new ArrayList<>(anotherDates);
                        diff1.removeAll(anotherDates);
                        diff2.removeAll(dates);
                        if(diff1.size() > 0) {
                            errorMessages.add(String.format("%s dates(s) missing on %s language.", diff1, nextEntry.getKey()));
                        }
                        if(diff2.size() > 0) {
                            errorMessages.add(String.format("%s dates(s) missing on %s language.", diff2, entry.getKey()));
                        }
                    }
                }
            }
        }
        throw new AssertionError(String.join("\n", errorMessages));
    }

    public void The_version_descriptions_are_filled() {
        Map<String, List<VersionInfo>> results = changesPage.getLanguagesWithVersionInfos();
        Set<String> errorMessages = new HashSet<>();
        for(Map.Entry<String, List<VersionInfo>> entry: results.entrySet()) {
            entry.getValue().forEach(versionInfo -> {
                if(versionInfo.getDescriptions().contains("")) {
                    errorMessages.add(String.format("Description is missing on %s language at %s version.", entry.getKey(), versionInfo.getVersionNumber()));
                }
            });
        }
        if(errorMessages.size() > 0) {
            throw new AssertionError(String.join("\n", errorMessages));
        }
    }
    
    public void The_version_icons_order_are_the_same() {
        Set<String> errorMessages = new HashSet<>();
        Map<String, List<VersionInfo>> results = changesPage.getLanguagesWithVersionInfos();
        for(Map.Entry<String, List<VersionInfo>> language: results.entrySet()) {
            Map<String, List<String>> versionsWithIcons = language
                        .getValue()
                        .stream()
                        .collect(Collectors.toMap(VersionInfo::getVersionNumber, VersionInfo::getIconNames));
            for(Map.Entry<String, List<VersionInfo>> anotherLanguage: results.entrySet()) {
                if(!language.getKey().equals(anotherLanguage.getKey())) {
                    Map<String, List<String>> anotherVersionsWithIcons = anotherLanguage
                            .getValue()
                            .stream()
                            .collect(Collectors.toMap(VersionInfo::getVersionNumber, VersionInfo::getIconNames));
                    for(Map.Entry<String, List<String>> vie: versionsWithIcons.entrySet()) {
                        if(!vie.getValue().equals((anotherVersionsWithIcons.get(vie.getKey())))) {
                            errorMessages.add(String.format("Ordering on %s [%s] and %s [%s] language at version %s is not the same.",language.getKey(),vie.getValue(),anotherLanguage.getKey(),anotherVersionsWithIcons.get(vie.getKey()), vie.getKey()));
                        }
                    }
                }
            }
        }
        if(errorMessages.size() > 0) {
            throw new AssertionError(String.join("\n", errorMessages));
        }
    }

    public void I_collect_the_version_infos_on_all_language(String whatToOutput) {
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
    }
}
