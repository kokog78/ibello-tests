package hu.ibello.demo.steps;

import hu.ibello.core.Name;
import hu.ibello.demo.model.VersionInfo;
import hu.ibello.demo.pages.ChangesPage;
import hu.ibello.steps.StepLibrary;

import java.util.*;
import java.util.stream.Collectors;

public class ChangesSteps extends StepLibrary {

    private ChangesPage changesPage;

    public List<VersionInfo> I_collect_the_version_infos_on_$_language(String language) {
         return changesPage.collectVersionInfo();
    }

    @Name("The version numbers are the same")
    public void The_version_numbers_are_the_same(Map<String, List<VersionInfo>> languagesWithVersionInfo) {
        Set<String> errorMessages = new HashSet<>();
        List<String> savedVersions = null;
        String savedLanguage = null;
        for(Map.Entry<String, List<VersionInfo>> entry: languagesWithVersionInfo.entrySet()) {
            List<String> actualVersions = entry.getValue().stream().map(VersionInfo::getVersionNumber).collect(Collectors.toList());
            if(savedVersions == null) {
                savedVersions = actualVersions;
                savedLanguage = entry.getKey();
                continue;
            }
            if (!actualVersions.equals(savedVersions)) {
                List<String> diff1 = getDifference(actualVersions, savedVersions);
                List<String> diff2 = getDifference(savedVersions, actualVersions);
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
        if(errorMessages.size() > 0) {
            throw new AssertionError(String.join("\r\n", errorMessages));
        }
    }

    @Name("The version dates are the same")
    public void The_version_dates_are_the_same(Map<String, List<VersionInfo>> languagesWithVersionInfo) {
        Set<String> errorMessages = new HashSet<>();
        List<String> savedDates = null;
        String savedLanguage = null;

        for(Map.Entry<String, List<VersionInfo>> entry: languagesWithVersionInfo.entrySet()) {
            List<String> actualDates = entry.getValue().stream().map(VersionInfo::getVersionDate).collect(Collectors.toList());
            if(savedDates == null) {
                savedDates = actualDates;
                savedLanguage = entry.getKey();
                continue;
            }
            if (!actualDates.equals(savedDates)) {
                List<String> diff1 = getDifference(actualDates, savedDates);
                List<String> diff2 = getDifference(savedDates, actualDates);
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
        if(errorMessages.size() > 0) {
            throw new AssertionError(String.join("\r\n", errorMessages));
        }
    }

    private List<String> getDifference(List<String> info1, List<String> info2) {
        List<String> difference = new ArrayList<>(info1);
        difference.removeAll(info2);
        return difference;
    }

    @Name("The version descriptions are filled")
    public void The_version_descriptions_are_filled(Map<String, List<VersionInfo>> languagesWithVersionInfo) {
        Set<String> errorMessages = new HashSet<>();
        languagesWithVersionInfo.forEach((key, value) -> value.forEach(versionInfo -> {
            if (versionInfo.getDescriptions().contains("")) {
                errorMessages.add(String.format("Description is missing on %s language at %s version.", key, versionInfo.getVersionNumber()));
            }
        }));
        if(errorMessages.size() > 0) {
            throw new AssertionError(String.join("\r\n", errorMessages));
        }
    }

    @Name("The ordering of version changes is the same")
    public void The_ordering_of_version_changes_is_the_same(Map<String, List<VersionInfo>> languagesWithVersionInfo) {
        Set<String> errorMessages = new HashSet<>(Collections.singletonList("Ordering differences: "));
        Map<String, List<String>> savedVersionWithIcons = null;
        String savedLanguage = null;
        for(Map.Entry<String, List<VersionInfo>> entry: languagesWithVersionInfo.entrySet()) {
            Map<String, List<String>> actualVersionWithIcons = entry.getValue().stream().collect(Collectors.toMap(VersionInfo::getVersionNumber, VersionInfo::getIconNames));
            String actualLanguage = entry.getKey();
            if(savedVersionWithIcons == null) {
                savedVersionWithIcons = new LinkedHashMap<>(actualVersionWithIcons);
                savedLanguage = actualLanguage;
                continue;
            }
            errorMessages.addAll(getIconsOrderingDifferences(savedVersionWithIcons, actualVersionWithIcons, savedLanguage, actualLanguage));
            savedVersionWithIcons = new LinkedHashMap<>(actualVersionWithIcons);
            savedLanguage = actualLanguage;
        }
        if(errorMessages.size() > 1) {
            throw new AssertionError(String.join("\r\n", errorMessages));
        }
    }

    private Set<String> getIconsOrderingDifferences(Map<String, List<String>> savedVersionWithIcons, Map<String, List<String>> actualVersionWithIcons, String savedLanguage, String actualLanguage) {
        Set<String> errorMessages = new HashSet<>();
        Map<String, List<String>> selectedMap = savedVersionWithIcons.size() > actualVersionWithIcons.size() ? savedVersionWithIcons : actualVersionWithIcons;
        for (Map.Entry<String, List<String>> versionEntry: selectedMap.entrySet()) {
            List<String> icons1 = versionEntry.getValue();
            List<String> icons2 = (savedVersionWithIcons.size() > actualVersionWithIcons.size() ? actualVersionWithIcons : savedVersionWithIcons).get(versionEntry.getKey());
            if (!icons1.equals(icons2)) {
                String language1 = savedVersionWithIcons.size() > actualVersionWithIcons.size() ? savedLanguage : actualLanguage;
                String language2 = savedVersionWithIcons.size() > actualVersionWithIcons.size() ? actualLanguage : savedLanguage;
                errorMessages.add(String.format("%s [%s] - %s [%s] at version: %s.", language1, icons1, language2, icons2, versionEntry.getKey()));
            }
        }
        return errorMessages;
    }
}
