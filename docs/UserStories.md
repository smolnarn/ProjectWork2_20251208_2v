## Digital Bank user stories ##

US01 – Sikertelen bejelentkezés
    Felhasználóként
        fontos számomra, hogy amikor valamit nem jól adok meg bejelentkezéskor, a rendszer felhívja rá a figyelmet,
        hogy azonnal módosíthassam.

     Elfogadási feltételek (Acceptance Criteria)
        - Üres vagy hibás mezők esetén a rendszer figyelmeztet.: 
                "Hiba Hibás belépési adatok vagy a hozzáférés nem engedélyezett a felhasználói fiók státusza, 
                vagy létező felhasználó munkamenet miatt."
        - Sikertelen belépéskor a bejelentkezési oldal aktív marad.


US02 – Sikeres belépés a rendszerbe
    Felhasználóként
        arra törekszem, hogy a felhasználónevemmel és jelszavammal megnyithassam a Digital Bank alkalmazást,
        mert így teljes rálátást kapok saját pénzügyeimre.

    Elfogadási feltételek (Acceptance Criteria)
        - A bejelentkezési oldalon minden szükséges mező és gomb megjelenik (felhasználónév, jelszó, emlékezzen rám, belépés).
        - Helyes adatok bevitele után a rendszer átirányít az "Áttekintés" oldalra.
        - A főoldalon személyre szabott üdvözlő üzenet fogad (Üdvözöljük, "name")
        - A bal oldali menü teljes funkcionalitással elérhetővé válik. 
                (Kezdőlap, Folyószámla, Megtakarítás, Külső, Befizetés, Kifizetés, Átutalás számlák kzött, VISA közvetlen átutalás)


US03 – Pénzügyi áttekintés megjelenítése grafikonokon ("Áttekintés" oldal)
        Felhasználóként
            szeretném, hogy az "Áttekintés" oldalon átlátható grafikonok mutassák meg a pénzmozgásaim lényegét,
            hogy egyetlen pillantással rálássak az aktuális pénzügyi állapotomra.

    Elfogadási feltételek (Acceptance Criteria)
        - A főoldalon megjelenik a számlaegyenleg összegző grafikon.
        - Külön grafikon mutatja a be- és kifizetések utolsó három hónapját.
        - A kategória szerinti bontások vizuálisan elkülönülnek.
        


US04 – A "Megtakarítás" menü kezelése
    Felhasználóként
        szeretném, hogy a bal oldali navigációs sávban található „Megtakarítás” menü áttekinthetően működjön,
        hogy könnyen elérjem meglévő megtakarításaim listáját, illetve új megtakarítási számlát hozhassak létre.

    Elfogadási kritériumok (Acceptance Criteria)
        - A "Megtakarítás" menü megnyitása.
        - A „Megtakarítás” főmenü elem kattintásra megnyílik és megjeleníti az alatta található opciókat 
                        (Megtakarítások megtekintése, Új megtakarítás).
        - A menü újra kattintva bezárható, így a felhasználó szabályozzni tudja a menü megjelenését.
        - „Megtakarítás megtekintése” almenü: 
                - A kiválasztás után a rendszer a "Megtakarítási számlák megtekintése" oldalra navigál.
                - Megjelennek a releváns adatok 
                        (Individual Savings, Individual Savings Egyenleg, Joint Savings, Joint Savings Egyenleg, Tranzakciók).
        - „Új megtakarítás” almenü: 
                - Megnyílik a "Megtakarítási számla létrehozása" oldal.
                - Az oldal minden mezőt és választható lehetőséget tartalmaz, amely a folyószámla indításához szükséges
                        (Válassza ki a Takarékszámla típusát, Válassza ki a Számla Tulajdonjogát, Számla Neve, Kezdeti Befizetés).

US05 - Új megtakarítás létrehozása
    Felhasználóként
        szeretném, hogy az „Új megtakarítási számla” felületen egyszerűen megadhassam a szükséges adatokat egy új megtakarítási számla megnyitásához,
        hogy könnyen elindíthassam a megtakarítási céljaimnak megfelelő számlát a banki rendszerben.

    Elfogadási kritériumok (Acceptance Criteria)
        - Megtakarítási számlatípusának kiválasztása (Megtakarítások, Pénzpiac).
        - Tulajdonosi jog kiválasztása (Egyéni, Közös).
        - "Számla Neve" megadása:
                - A felület biztosít egy szövegmezőt a számla elnevezésére.
                - Az elnevezés megadása kötelező, mivel a számla azonosításához szükséges. 
                        ("pl. Rövid leíró név a számla könnyű azonosításához")
                - Üres mező esetén a rendszer nem fogadja el a beküldést. 
        - Kezdeti befizetés összegének megadása:
                - A felhasználó beírhatja a számlanyitáshoz szükséges induló befizetés összegét.
                - A rendszer kizárólag numerikus összeget fogad el.
                - Az útmutató jelzi a minimálisan elvárt befizetési összeget ("pl. A minimális nyitó befizetés $25.00").
        - Űrlap alaphelyzetbe állítása
                - Az „Alaphelyzetbe állítás” gomb törli a bevitt adatokat és visszaállítja a mezőket az eredeti állapotba.
                    A funkció biztosítja, hogy a felhasználó gyorsan újrakezdhesse a kitöltést.
        - Beküldés működése:
                - Az „Elküldés” gombra kattintva a rendszer ellenőrzi az űrlap mezőinek helyes kitöltését.
                - Helyesen kitöltött űrlap esetén a rendszer létrehozza a megtakarítási számlát és sikerességéröül üzenetet jelenít meg 
                        ("Új Megtakarítások típusú számla sikeresen létrehozásra került a következő névvel: xxxxxxx")
                -   A felhasználó ezt követően átirányításra kerül a megtakarítási számla részletes nézetére ("Megtakarítási számlák megtekintése" oldal).


US06 - Létrehozott megtakarítási számla adatainak megjelenítése
    Felhasználóként
        szeretném, hogy egy új megtakarítási számla létrehozása után a rendszer azonnal megjelenítse a számlához tartozó részletes adatokat és a számlamozgások listáját,
        hogy ellenőrizhessem az induló egyenleget, a számla paramétereit, és a korábbi tranzakciókat.

    Elfogadási kritériumok
        - A megtakarítási számla adatainak megjelenítése:
                -A rendszer vizuális kártyákon jeleníti meg az összes aktív megtakarítási számlát, köztük a frissen létrehozott számlát.
                - A kártya tartalmazza:
                    - a számla nevét,
                    - a megtakarítási számla típusát (pl. Megtakarítások, Pénzpiac),
                    - a tulajdonosi formát (Egyéni vagy Közös),
                    - a számlaszámot,
                    - a kamatlábat,
                    - az aktuális egyenleget.
        - A tranzakciós lista megjelenítése
                - A számlák alatt táblázat formájában jelnnek meg a tranzakciók.
                - A lista tartalmaz minden releváns tranzakció adatot:
                    - dátum,
                    - kategória,
                    - leírás,
                    - összeg,
                    - egyenleg.
        - A táblázat lapozható, és az oldalak között navigációs gombok („Previous”, „Next”) találhatók.
        - Keresési és szűrési lehetőségek
        - A táblázat jobb felső részén található "Search" mező lehetővé teszi a felhasználónak, hogy szöveg alapján szűrje a megjelenített tranzakciókat.
        - A megjelenő adatok:
                - A frissen létrehozott megtakarítási számla kezdő befizetése azonnal megjelenik a tranzakciók listájában.
                - Az egyenleg mező helyesen tükrözi az induló összeget.


US07 – Kijelentkezés
    Felhasználóként
        arra számítok, hogy egyetlen kattintással lezárhatom a munkamenetemet,
        mert így a saját adataim mindig védett és tiszta térben maradnak.

    Elfogadási feltételek (Acceptance Criteria)
        - A jobb felső sarok menüjében megjelenik a kijelentkezési lehetőség.
        - Kijelentkezést követően a rendszer visszavisz a bejelentkezési felületre.
        - Zöld, pozitív visszacsatolás érkezik: „Sikeres kilépés.”
        - Új oldalbetöltéskor ismét belépést kér a rendszer.
