# Nyelv választás teszt

Ebben a dokumentumban végigvesszük az https://ibello.hu/ oldalon elérhető nyelv választó működését ellenőrző teszt első két lépésének elkészítését. A kész teszt a demó projekt repositoryban elérhető.

### Teszt lépései

- megnyitjuk a weblapot
- leellenőrizzük, hogy a megjelenő oldal a rendszerünknek megfelelő nyelven jelenik meg
- a navigációs sávban kiválasztjuk a másik nyelvet
  ![](/home/zolkasza/Képek/demo_projekt/nyelvvalasztas.png)
- leellenőrizzük, hogy a nyelv megváltozott
- visszaállítjuk az eredeti nyelvet
- leellenőrizzük, hogy az oldal ismét a rendszerünknek megfelelő nyelven jelenik meg

### Jellemző létrehozása

Jellemzőknek nevezzük azokat a `.feature` kiterjesztésű fájlokat, amik a teszt forgatókönyveket tartalmazzák. 

Új jellemző létrehozásához kattintsunk a 'Teszt tervezés' menün belül a 'Forgatókönyvek' opcióra. Az 'Új fájl' gombra kattintva adjuk meg a létrehozni kívánt fájl, illetve a jellemző nevét. Az 'Ok' gomb megnyomásával a jellemző létrejön. A demó projektben használt jellemző a 'changing-language' nevet viseli. Az újonnan létrehozott jellemzőbe vegyünk fel egy új forgatókönyvet. Ehhez kattintsunk az 'Új forgatókönyv létrehozása' gombra. A forgatókönyvek elkészítésekor a Gherkin nyelv szabályai alapján a 'Given', 'When', 'Then' és 'And' kulcsszavak használhatóak. A nyelv választó teszteléséhez a forgatókönyvet a 'teszt lépései' szekcióban lévő pontok alapján írjuk meg. Mivel a tesztlépések még nincsenek implementálva ezért a grafikus felületen pirossal aláhúzva jelennek meg.

![](/home/zolkasza/Képek/demo_projekt/forgatókönyv.png)

A tesztlépésekben látható 'Language' a használt névteret jelöli. Ahhoz, hogy később az egyes jellemzőket külön is tudjuk futtatni érdemes cimkéket használni. A demó projektben a @full-test címke az összes jellemzőben, a @language csak ebben a jellemzőben van használva. 

Ezzel a jellemző a forgatókönyvvel elkészült és a projekt/fetatures/ mappában megtalálható.  

![](/home/zolkasza/Képek/demo_projekt/featureide.png)

### Workflow létrehozása

A 'workflow' egy olyan osztály ami a jellemzőben leírt forgatókönyvek lépéseit fejti ki java metódusok segítségével. 

Ennek létrehozásához navigáljunk a 'Tesztlépések' menün belül a 'Nem létező tesztlépések' opcióra. Itt láthatóak az előzőleg létrehozott tesztlépések, a hozzájuk tartozó névtérrel együtt. Jelöljük ki az összes tesztlépést és kattintsunk a 'Kód generálása' gombra. 

![](/home/zolkasza/Képek/demo_projekt/generalt_lépések.png)

Ez a kód nem kerül be automatikus a forráskódba. Ehhez először hozzunk létre egy java osztályt a workflow-nak, majd a generált kódot másoljuk be abba. A demó projektben az ehhez a teszthez tartozó workflow-t 'LanguageWorkflow' néven található meg.

### `i_am_on_homepage()` metódus kifejtése

A teszt első lépéseként implementáljuk az `i_am_on_homepage()` metódust, amivel a kezdő oldalt nyitjuk meg. Mivel ez egy egyszerű lépés ezért ennek a metódusnak a törzsében egyetlen metódus hívás lesz. Ennek ellenére a különböző szinteket (workflow, steps, page object) meg kell tartanunk a későbbi újrafelhasználhatóság érdekében. A kezdőoldal megnyitásának logikáját szervezzük ki a 'NavigationSteps' osztályba, hogy a későbbi forgatókönyvekhez is fel tudjuk használni. 

```
private NavigationSteps navigationSteps;

public void i_am_on_homepage() {
    navigationSteps.i_open_the_homepage();
}
```

#### NavigationSteps létrehozása

Hozzunk létre az IDE-ben egy új, 'NavigationSteps' osztályt. Fontos, hogy minden 'steps' osztály a 'StepLibrary' osztályból származzon le.

```
@Name("Navigation steps")
public class NavigationSteps extends StepLibrary {

	private HomePage homePage;

	public void i_open_the_homepage() {
    	homePage.i_open_homepage();
    	i_am_on_homepage();
	}

}
```

Ebben a metódusban két másik metódust is meghívunk. Az első, `homePage.i_open_homepage()` a kezdőoldalhoz tartozó, oldal-leíró osztályban lévő metódus, ami ténylegesen megnyitja az ibello kezdőoldalát. Először az oldal-leíró osztályt injektálnunk kell ahhoz, hogy a metódusait használni tudjuk (private HomePage homePage). A második,  `i_am_on_homepage()` metódus azt ellenőrzi, hogy valóban a kezdőoldalon vagyunk.

Implementáljuk a kezdőoldal oldal-leíró osztályában az `i_open_homepage()` metódust!

#### `i_open_homepage()` metódus kifejtése

Első lépésként hozzuk létre a 'HomePage' oldal-leíró fájlt az ibello grafikus felületén. Ehhez navigáljunk az 'Oldal-leírók' menübe majd kattintsunk az 'Új fájl' gombra. Adjunk a fájlnak valami beszédes nevet. A demo projektben a 'HomePage' nevet használtuk. Mivel ehhez a metódushoz nincs szükségünk semmilyen `WebElement` felvételére ezért térjünk vissza az általunk használt IDE-be és hozzunk létre egy 'HomePage' osztályt ami a 'PageObject' ősosztályból származik. Ezután már tudjuk használni a `browser()` metódust, aminek segítségével meg tudjuk nyitni a kezdőoldalt a kivánt méretben. Mivel a konfigurációban már megadtuk a tesztelendő alkalmazásunk URL előtagját (https://ibello.hu/ibello/public/) ezért az `openURL(String url)` metódusban már csak a kiegészítést kell megadnunk.
```
public class HomePage extends PageObject { 

    public void i_open_homepage() {
        browser().resize(2000, 1000);
        browser().maximize();
        browser().openURL("/#home");
    }
    
}
```

Következő lépésként fejtsük ki az `i_am_on_homepage()` metódust a 'NavigationSteps' osztályunkban!

#### `i_am_on_homepage()` metódus kifejtése

Ezzel a metódussal ellenőrizzük, hogy valóban a kezdőoldalon vagyunk. Ehhez három további metódust használunk:

1. `homePage.expect_url_is_$(url)`: egy átadott paraméter segítségével ellenőrizzük a megjelenő URL-t
2. `homePage.i_expect_main_lane_is_displayed()`: ellenőrizzük, hogy egy általunk választott elem megjelent
3. `navigationBar.expect_menu_component_is_displayed()`: ellenőrizzük, hogy az oldal tetején lévő navigációs panel megjelent

```
@Name("Navigation steps")
public class NavigationSteps extends StepLibrary {

	private HomePage homePage;
	private NavigationBarPanel navigationBar;

	public void i_am_on_homepage() {
    	String url = "/#home";
    	homePage.expect_url_is_$(url);
   		homePage.i_expect_main_lane_is_displayed();
    	navigationBar.expect_menu_component_is_displayed();
	}
	
}
```

Az első két metódust a már létrehozott 'HomePage' oldal-leíró osztályunkban kell implementálni. A harmadik metódus viszont egy új 'NavigationBar' oldal-leíró osztályba kerül kifejtésre. Ennek oka csupán a struktúráltság növelése. Ezek az ellenőrzések elhagyhatóak lehetnek, de előfordulhat olyan eset, hogy egy oldal lassan töltődik be és ellenőrzés nélkül a tesztünk eltörne. 

Egészítsük ki a már létrehozott 'HomePage' osztályunkat a fent említett két metódussal!

#### `homePage.expect_url_is_$(url)` és `homePage.i_expect_main_lane_is_displayed()`kifejtése

Az URL vizsgálatához ismét a `browser()` metódust alkalmazzuk. Az elvárt URL-t paraméterként adjuk át a metódusnak és lágy ellenőrzést használunk, hogy egy esetleges hiba esetén a teszt tovább fusson.

```
public void expect_url_is_$(String url) {
    expectations().assume(browser()).toHave().url(url);
}
```

A demó projektben ezt a metódust egy abstract oldal-leíró osztályba szerveztük ki, mivel a további tesztek folyamán más oldal-leíró osztályok is használják.

A második metódus segítségével leellenőrizzük, hogy az oldal egy része megjelent-e.

![](/home/zolkasza/Képek/demo_projekt/main_lane.png)

    @Find(by = By.CSS_SELECTOR, using = "welcome-main-lane")
    private WebElement mainLane;
    
    public void i_expect_main_lane_is_displayed() {
        expectations().expect(mainLane).toBe().displayed();
    }
#### `navigationBar.expect_menu_component_is_displayed()` kifejtése

A harmadik, `navigationBar.expect_menu_component_is_displayed()` metódus segítségével az oldal tetején látható navigációs mező megjelenését ellenőrizzük. Ezt a fent említett módon, egy külön oldal-leíró osztályban implementáljuk.

Hozzunk létre egy 'NavigationBarPanel' osztályt ami szintén a 'PageObject' ősosztályból származik.

Vegyük fel a képen pirossal bekeretezett navigációs mező elemet, és ellenőrizzük a láthatóságát. 

![](/home/zolkasza/Képek/demo_projekt/navbar.png)

```
public class NavigationBarPanel extends PageObject {

    @Find(by = By.CSS_SELECTOR, using = "menu-component")
    private WebElement menuComponent;

    public void expect_menu_component_is_displayed() {
        expectations().expect(menuComponent).toBe().displayed();
    }
}
```

#### Teszt első futtatása

Ezzel a forgatókönyvünk első lépése elkészült. Az ibello grafikus felületén a 'Teszt tervezés/Forgatókönyvek' menüben a forgatókönyv mellett lévő 'Lejátszás' gomb segítségével futtassuk le a tesztet. Ehhez azonban először a 'Lejátszás' menüpontban indítsuk el a lejátszó ablakot, a "https://ibello.hu/ibello/public/" URL megadása után.**Fontos, hogy az IDE-ben történt változtatások csak akkor jelennek meg az ibelloban ha már lefordítottuk a forráskódot.**

![](/home/zolkasza/Képek/demo_projekt/lejatszo_ablak.png)



![](/home/zolkasza/Képek/demo_projekt/lejatszas.png)

Amennyiben mindent jól csináltunk, a teszt egy új böngésző ablakban lefut. Egyelőre csak elnavigál a kezdőoldalra és leellenőrzi annak megjelenését. A teszt futásának végeztével egy új ablak ugrik fel a teszt eredményével.

![](/home/zolkasza/Képek/demo_projekt/elso_Teszt_siker.png)

### `the_current_language_is_the_default()` metódus kifejtése

A forgatókönyvünk második metódusának segítségével leellenőrizzük a megnyíló kezdőoldal nyelvét.

```
public void the_current_language_is_the_default() {
    LanguageSelection data = testData().fromJson(LanguageSelection.class).load();
    languageSteps.based_on_$_test_data_i_check_if_the_language_is_default(data);
}
```

Mivel az oldalon magyar és angol nyelv is választható, ezért célszerű a tesztünket tesztadat vezérelten megcsinálni. A tesztadatok betöltését a `testData().fromJson(LanguageSelection.class).load()` függvény segítségével végezzük. Ehhez azonban először létre kell hoznunk a tesztadatot!

#### Tesztadat modell létrehozása

Hozzunk létre egy teszt adat modellt az alábbiak szerint:

```
@Model
@Description("Test data for language selection")
public class LanguageSelection {

    @Description("Selected language will be selected during the test.")
    private Languages language;

    @Description("These texts will be checked to be displayed after changing the language.")
    @Description("If english is not the selected language then the test will check if these languages are not displayed.")
    private List<String> englishTexts;

    @Description("These texts will be checked to be displayed after changing the language.")
    @Description("If hungarian is not the selected language then the test will check if these languages are not displayed.")
    private List<String> hungarianTexts;

    @Description("It is used to identify testdata.")
    private String id;

    public List<String> getEnglishTexts() {
        return englishTexts;
    }

    public List<String> getHungarianTexts() {
        return hungarianTexts;
    }

    public Languages getLanguage() {
        return language;
    }

    @Override
    public String toString() {
        if (id != null) {
            return id;
        }
        return "No given id";
    }

}
```

Ebben a tesztadatban tároljuk:

- a kiválasztott nyelvet (`Languages` enum)
- az angol szöveget aminek megjelenését ellenőrizzük (`List<String>`)
- a magyar szöveget aminek megjelenését ellenőrizzük (`List<String>`)
- a tesztadat azonosítóját ami a riportban fog megjelenni a `toString()` metódus felülírása miatt (`String`)

A `@Model` annotáció segítségével az ibello tudja, hogy ez egy tesztadat modell és így, a grafikus felületen keresztül létre tudunk hozni különböző tesztadatokat.

#### `Languages` enum létrehozása

Hozzunk létre egy enum osztályt amiben a kiválasztható nyelveket kezeljük.
```
public enum Languages {
    ENGLISH,
    HUNGARIAN;
}
```

#### Tesztadatok létrehozása
Annak érdekében, hogy a tesztadat vezérelt működés megvalósuljon, a magyar és az angol nyelvre is létre kell hoznunk egy-egy tesztadatot. Mivel azonban mind a két esetben ellenőrizni kell a megjelenített szövegeket ezért egy harmadik, 'alap' teszt adatra is szükségünk lesz.

Az ibello grafikus felületén navigáljunk el a 'Tesztadatok/Fájlok' menübe és válasszuk ki az általunk létrehozott tesztadat modellt. A demó projektben ez 'Language Selection' néven szerepel. Amennyiben nem látjuk a modellt, bizonyosodjunk meg róla, hogy a `@Model` annotáció szerepel az osztályban illetve, hogy lefordítottuk a forráskódot. 

Hozzuk létre az alap tesztadatot:

A 'Fájlok' menüpontban kattintsunk az 'Új fájl létrehozása' gombra, majd nevezzük el a fájlunkat. A demó projektben ez 'languageselection.json' néven szerepel. A 'Szerkesztés' gombot megnyomva, hozzuk létre az alábbi tesztadatot:

```
{
  "id": "Texts",
  "englishTexts": [
    "ibello Test Framework",
    "The experience of testing supported by artificial intelligence",
    "If you need some good tests"
  ],
  "hungarianTexts": [
    "ibello teszt keretrendszer",
    "A mesterséges intelligencia által támogatott tesztelés élménye",
    "Ha kell néhány jó teszt"
  ]
}
```

Amint létrehoztuk a fájlt, az megjelenik elérhető az általunk használt IDE-ben is a 'data' könyvtárban. 

Látható, hogy a 'language' mezőt ebben a fájlban nem használjuk. Ez azért van, mert az ibello működéséből adódóan tesztadatok betöltésekor először a címke nélküli, majd a címkével ellátott adatok töltődnek be. Mi a 'language' mező értékét egy másik tesztadatból szeretnénk feltölteni.

Hozzunk létre a fentiek szerint két másik tesztadatot az angol és magyar nyelvhez! Fontos, hogy ezúttal lássuk el a tesztadatunkat különböző címkékkel, amik segítségével a tesztünket futtatni fogjuk. 

Az első tesztfájlunkhoz használjunk 'hu' cimkét. Ennek segítségével fogjuk a tesztben először ellenőrizni, hogy az alapértelmezett nyelv magyar. Utána az ebben szereplő 'language' érték alapján állítjuk majd át a nyelvet angolra.

```
{
  "id": "HunToEng",
  "language": "ENGLISH"
}
```

A második tesztfájlunkhoz használjunk 'eng' cimkét. Ennek segítségével fogjuk a tesztben először ellenőrizni, hogy az alapértelmezett nyelv angol. Utána az ebben szereplő 'language' érték alapján állítjuk majd át a nyelvet magyarra.

```
{
  "id": "EngToHun",
  "language": "HUNGARIAN"
}
```

#### `languageSteps.based_on_$_test_data_i_check_if_the_language_is_default(data)` metódus implementálása

A tesztadat elkészítése után térjünk vissza a nyelv választást ellenőrző workflow-hoz. 

```
public void the_current_language_is_the_default() {
    LanguageSelection data = testData().fromJson(LanguageSelection.class).load();
    languageSteps.based_on_$_test_data_i_check_if_the_language_is_default(data);
}
```

Ahogy azt korábban tárgyaltuk, a `testData().fromJson(LanguageSelection.class).load()` fogja betölteni a megadott cimke szerinti tesztadatot. A következő lépés a `languageSteps.based_on_$_test_data_i_check_if_the_language_is_default(LanguageSelection data)` metódus implementálása. Ehhez a korábban bemutatott módon készítsünk egy 'LanguageSteps' osztályt. 

```
@Name("Language steps")
public class LanguageSteps extends StepLibrary {

	public void based_on_$_test_data_i_check_if_the_language_is_default(LanguageSelection data) { 
	}
	
}
```

Ezután az alábbi módon egészítsük ki a létrehozott osztályunkat:

```
@Name("Language steps")
public class LanguageSteps extends StepLibrary {

    private HomePage homePage;
    private NavigationBarPanel navigationBar;

    public void based_on_$_test_data_i_check_if_the_language_is_default(LanguageSelection data) {
        check_texts_based_on_$_test_data_with_$_boolean(data, true);
    }
```

Hozzuk létre a `check_texts_based_on_$_test_data_with_$_boolean(LanguageSelection data, boolean isDefault)` metódust az osztályon belül. Ennek lesz a feladata az átadott tesztadat alapján ellenőrizni a kezdőoldalon megjelenő szövegeket. Az `isDefault` logikai paraméterre azért lesz szükségünk mert így, ezt az egy metódust használva le tudjuk ellenőrizni, hogy változtatás előtt az alapértelmezett nyelv megfelel-e az elvárt nyelvvel. Ezen kívűl ismételt ellenőrzésre is alkalmas, miután a teszt későbbi szakaszában megváltoztatjuk a nyelvet. Utobbihoz csupán `false` értéket kell átadnunk `isDefault` paraméterként. 
```
@Internal
public void i_select_language_based_on_$_test_data_with_$_boolean(LanguageSelection data, boolean isDefault) {
    if (data != null && data.getLanguage() != null) {
        navigationBar.click_language_link();
        switch (data.getLanguage()) {
            case HUNGARIAN:
                if (isDefault) {
                    navigationBar.click_english_link();
                } else {
                    navigationBar.click_hungarian_link();
                }
                break;
            case ENGLISH:
                if (isDefault) {
                    navigationBar.click_hungarian_link();
                } else {
                    navigationBar.click_english_link();
                }
                break;
            default:
                break;
        }
    } else {
        throw new AssertionError("Testdata is null!");
    }
}
```

A fenti kód működéséhez a korábban létrehozott 'NavigationBarPanel' oldal-leíró osztályban implementáljuk az alábbi metódusokat:

`navigationBar.click_language_link()`: rákattintás a nyelvválasztó gombra

`navigationBar.click_english_link()`: a megjelenő nyelvek közül válassza ki az angolt

`navigationBar.click_hungarian_link()`: a megjelenő nyelvek közül válassza ki az magyart

#### `navigationBar.click_language_link()` metódus implementálása

Mivel a nyelvválaszó gomb egy interaktív elem ezért használhatjuk az ibello automatikus elem felvevőjét. Ehhez navigáljunk el az 'Oldal-leírók' menübe és válasszuk ki, az előzőleg létrehozott 'HomePage' oldal-leíró fájlt. Ezután kattintsunk az 'Új elem hozzáadása' gombra és a felugró ablakban válasszuk ki az 'Elem felvétele kattintással' opciót. Ennek működésének előfeltéte, hogy a felvevőablak meg legyen nyitva. Ezt a 'Felvevőablak' menüben  a 
'https://ibello.hu/ibello/public/' URL megadásával tehetjük meg. Miután rákattintottunk az 'Elem felvétele' gombra, az egerünk mutatója egy piros koronggá változik. Ezt húzzuk rá a felvenni kívánt elemre, jelen esetben a nyelv választó gombra, majd kattintsunk. Ennek eredménye az alábbi képen látható:

![](/home/zolkasza/Képek/demo_projekt/elemfelvétel.png)



A felismerés sikerességét az 'Elem elhelyezkedésének tesztelése' gombra kattintva tudjuk ellenőrizni. Ezt megnyomva, a felvevőablakban megjelölésre kerül a felismert elem. Lehetőségünk van saját keresési szempontok alapján is rögzíteni egy elemet. Ebben az esetben különösen hasznos lehet a sikeresség visszaellenőrzése.
![](/home/zolkasza/Képek/demo_projekt/elem_felvetel_ellenorzes.png)

Ezután az 'elemmel történő műveletek' opcióban válasszuk ki a 'Kattintás' lehetőséget és a 'Műveletek automatikus elnevezése' gombbal töltsük ki a megnevezés mezőt.

![](/home/zolkasza/Képek/demo_projekt/webelement_muvelet.png)

 A 'Bezárás' gombra kattintás után a felvett elemünk készen van a használatra. Ahhoz, hogy ezt a forráskódba be tudjuk illeszteni először java kódot kell generálni belőle. Jelöljük ki a felvett elemünk melletti jelölőnégyzetet és kattintsunk a 'Generált kód' opcióra. Innen, a generált kódot másoljuk be az oldal-leíró osztályunkba.

```
@Find(by = By.BUTTON_TEXT, using = "▼")

public void click_language_link() {
    doWith(languageLink).click();
}

```
A bemutatott módon vegyük fel az angol és magyar nyelvi választó gombjához tartozó `WebElement` objektumokat is.  Ezzel a tesztünk második lépésével is készen vagyunk. Ahhoz azonban, hogy tesztelni tudjuk a konzolból, a cucumber segítségével kell elindítanunk a tesztet. Erre a tesztadatokban használt címkék miatt van szükség. A grafikus felületről indított futtatás esetén nincs lehetőség címkék megadására. A konzolban navigáljunk el a projektünket tartalmazó könyvtárba majd adjuk ki az `ibello cucumber -thu -tlanguage` parancsot. A `-thu` megadja, hogy a 'hu' címkével rendelkező tesztadatot töltse be. A '-tlanguage' nyelvválasztó ellenőrzésére megírt forgatókönyvhöz tartozó cimkét jelöli. Mivel a tesztelés ezen fázisában még csak ez az egy jellemzőnk van, ezért ez elhagyható.

A teszt további lépéseit nem részletezzük, de a demó projektben a teljes teszt implementálásra került.