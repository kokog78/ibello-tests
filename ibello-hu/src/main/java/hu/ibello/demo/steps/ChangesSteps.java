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

    // TODO nem jó pattern egy steps osztályba más steps osztályokat bekebverni hacsak nem nagyon indokolt.
    //  Ebben az esetben megtehetnéd azt, hogy a workflow osztályodban iterálsz végig a tesztadaton és az alapján gyűjtögeted ki a különböző infokat.
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
        // TODO ez kicsit bonyolult lett, itt egy for ciklus használata könnyebb és gyorsabb lenne.
        // Pl. csinálsz egy listát a verziószámoknak, kezdetben null értékkel
        // Végigiterálsz egy ciklusban a map-en, ha a verziószámos lista null akkor feltöltöd az első nyelvhez tartozó verzió számokkal
        // a következő iterációban megnézed, hogy a megjegyzett lista egyezik-e az aktuális nyelvhez tartozóval
        results.forEach((key, value) ->  {
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
        if(errorMessages.size() > 0) {
            throw new AssertionError(String.join("\r\n", errorMessages));
        }
    }

    // TODO felesleges üres sorok
    public void The_version_dates_are_the_same() {

        Map<String, List<VersionInfo>> results = changesPage.getLanguagesWithVersionInfos();
        Set<String> errorMessages = new HashSet<>();

        // TODO for ciklus hazsnálata, lásd korábbi megjegyzés
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
        if(errorMessages.size() > 0) {
            throw new AssertionError(String.join("\r\n", errorMessages));
        }
    }

    public void The_version_descriptions_are_filled() {
        Map<String, List<VersionInfo>> results = changesPage.getLanguagesWithVersionInfos();
        Set<String> errorMessages = new HashSet<>();
        results.forEach((key, value) -> value.forEach(versionInfo -> {
            if (versionInfo.getDescriptions().contains("")) {
                errorMessages.add(String.format("Description is missing on %s language at %s version.", key, versionInfo.getVersionNumber()));
            }
        }));
        if(errorMessages.size() > 0) {
            throw new AssertionError(String.join("\r\n", errorMessages));
        }
    }
    
    public void The_version_icons_order_are_the_same() {
        Set<String> errorMessages = new HashSet<>(Collections.singletonList("Ordering differences: "));
        Map<String, List<VersionInfo>> results = changesPage.getLanguagesWithVersionInfos();

        results.forEach((key, value) -> {
            Map<String, List<String>> versionsWithIcons = value.stream().collect(Collectors.toMap(VersionInfo::getVersionNumber, VersionInfo::getIconNames));
            results.forEach((key1, value1) -> {
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

    public void I_collect_the_version_infos_on_all_language(String whatToOutput) {
        // TODO a nyelvválasztással kapcsolatos lépések lehetnének a workflowban, itt csak a version info kigyűjtése kellene
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
