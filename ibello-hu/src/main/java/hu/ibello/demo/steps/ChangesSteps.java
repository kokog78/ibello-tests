package hu.ibello.demo.steps;

import hu.ibello.core.Name;
import hu.ibello.core.TestException;
import hu.ibello.demo.model.Languages;
import hu.ibello.demo.pages.ChangesPage;
import hu.ibello.steps.StepLibrary;

import java.util.ArrayList;
import java.util.List;

// TODO a "steps" szükségtelen
@Name("Changes steps")
public class ChangesSteps extends StepLibrary {

    private ChangesPage changesPage;
    private LanguageSteps languageSteps;

    List<String> hungarianVersions;
    List<String> englishVersions;
    List<String> hungarianVersionDates;
    List<String> englishVersionDates;
    List<String> hungarianIcons;
    List<String> englishIcons;
    List<String> descriptions = new ArrayList<>();

    // TODO rossz a metódus neve, nem azt csinálja, amit a névben leírsz
    // TODO ezt esetleg ketté lehetne szedni
    public void I_compare_the_version_numbers() {
        languageSteps.I_select_$_language(Languages.HUNGARIAN);
        // TODO a beállítás inkább a page object magánügye
        hungarianVersions = changesPage.getProductVersions(getConfigurationValue("ChangesPage.hu.versionNumberPrefix").toString());
        // TODO itt érdemes lenne kiírni, milyen adatot szedtél össze
        languageSteps.I_select_$_language(Languages.ENGLISH);
        // TODO a beállítás inkább a page object magánügye
        englishVersions = changesPage.getProductVersions(getConfigurationValue("ChangesPage.en.versionNumberPrefix").toString());
        // TODO itt érdemes lenne kiírni, milyen adatot szedtél össze
    }
    
    public void The_version_numbers_are_same() {
    	// TODO érdemes lenne kiírni, melyik nyelvvel van gond
        if (hungarianVersions.isEmpty() || englishVersions.isEmpty()) {
        	// TODO helyesírási hiba az üzenetben
            throw new TestException("One language versions not loaded.");
        }
        // TODO biztos kell ide a size() összehasonlítás is?
        if (hungarianVersions.size() != englishVersions.size() || !hungarianVersions.equals(englishVersions)) {
        	// TODO érdemes lenne kiírni, mely verziószámok hiányoznak honnan
            throw new AssertionError("Versions are not the same.");
        }
    }

    // TODO rossz a metódus neve, nem azt csinálja, amit a névben leírsz
    // TODO ezt esetleg ketté lehetne szedni
    public void I_compare_the_release_dates() {
        languageSteps.I_select_$_language(Languages.HUNGARIAN);
        hungarianVersionDates = changesPage.getProductVersionDates();
        // TODO itt érdemes lenne kiírni, milyen adatot szedtél össze
        languageSteps.I_select_$_language(Languages.ENGLISH);
        englishVersionDates = changesPage.getProductVersionDates();
        // TODO itt érdemes lenne kiírni, milyen adatot szedtél össze
    }
    
    public void The_release_dates_are_the_same() {
    	// TODO érdemes lenne kiírni, melyik nyelvvel van gond
        if (hungarianVersionDates.isEmpty() || englishVersionDates.isEmpty()) {
            throw new TestException("One language versions not loaded.");
        }
        // TODO biztos kell ide a size() összehasonlítás is?
        if (hungarianVersionDates.size() != englishVersionDates.size() || !hungarianVersionDates.equals(englishVersionDates)) {
        	// TODO a hibaüzenet rossz, nem "version dates", hanem "release dates"
        	// TODO érdemes lenne kiírni, mely dátumok hiányoznak honnan
            throw new AssertionError("Version dates are not the same.");
        }
    }

    // TODO rossz a metódus neve
    // TODO ezt esetleg ketté lehetne szedni
    public void I_see_the_descriptions() {
        languageSteps.I_select_$_language(Languages.HUNGARIAN);
        // TODO itt bővítgeted a descriptions listát, de ez egy újrafelhasználható tesztlépés! ha ezt csinálod, az hibához vezethet
        descriptions.addAll(changesPage.getProductVersionChangesDescription());
        languageSteps.I_select_$_language(Languages.ENGLISH);
        // TODO itt bővítgeted a descriptions listát, de ez egy újrafelhasználható tesztlépés! ha ezt csinálod, az hibához vezethet
        descriptions.addAll(changesPage.getProductVersionChangesDescription());
    }
    
    public void The_version_changes_are_described() {
        if (descriptions.isEmpty()) {
            throw new TestException("Details are not loaded!");
        }
        if (descriptions.contains("") || descriptions.contains(null)) {
        	// TODO itt ki kellene írni, pontosan melyik leírással van gond
            throw new AssertionError("Not all changes are described!");
        }
    }

    // TODO rossz a metódus neve, nem azt csinálja, amit a névben leírsz
    // TODO ezt esetleg ketté lehetne szedni
    public void I_compare_the_icons_order() {
        languageSteps.I_select_$_language(Languages.HUNGARIAN);
        hungarianIcons = changesPage.getProductVersionIcons();
        // TODO itt érdemes lenne kiírni, milyen adatot szedtél össze
        languageSteps.I_select_$_language(Languages.ENGLISH);
        englishIcons = changesPage.getProductVersionIcons();
        // TODO itt érdemes lenne kiírni, milyen adatot szedtél össze
    }
    
    public void The_icons_order_are_same() {
    	// TODO érdemes lenne kiírni, melyik nyelvvel van gond
        if (hungarianIcons.isEmpty() || englishIcons.isEmpty()) {
            throw new TestException("One language versions not loaded.");
        }
        if (hungarianIcons.size() != englishIcons.size() || !hungarianIcons.equals(englishIcons)) {
        	// TODO érdemes lenne kiírni, mely ikonok hiányoznak honnan
            throw new AssertionError("Version changes order are not the same.");
        }
    }
}
