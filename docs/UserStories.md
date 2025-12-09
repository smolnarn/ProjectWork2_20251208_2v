## Digital Bank user stories ##

US01 – Bejelentkezési folyamat kezelése
    Felhasználóként
        fontos számomra, hogy a hitelesítő adataimmal be tudjak lépni a Digital Bank alkalmazásba, 
        illetve megfelelő visszajelzést kapjak hibás adatok esetén,
        mert azonosítás szükséges ahhoz, hogy hozzáférjek a pénzügyi adataimhoz.

    Elfogadási feltételek (Acceptance Criteria)

        - A bejelentkezési oldalon minden szükséges elem elérhető (felhasználónév, jelszó mezők, "Emlékezzen rám" opció, "Belépés" gomb).

        Sikeres bejelentkezés:
            - Helyes adatok megadása után a rendszer átirányít az "Áttekintés" (Overview) oldalra.
            - Megjelenik a személyre szabott üdvözlő üzenet (pl. "Üdvözöljük, [Név]").
            - A bal oldali navigációs menü teljes funkcionalitással elérhetővé válik. 
                (Kezdőlap, Folyószámla, Megtakarítás, Külső, Befizetés, Kifizetés, Átutalás számlák között, VISA közvetlen átutalás).
        
        Sikertelen bejelentkezés:
            - Ha a felhasználó hiányosan tölti ki a formot, akkor a bejelentkezés gomb megnyomását követően figyelmeztetést kap a hiányos adatokra.
            - Ha a felhasználó nem megfelelő usernév és password kombinációt ad meg, akkor a rendszer hibaüzenettel figyelmeztet: 
                "Hiba Hibás belépési adatok vagy a hozzáférés nem engedélyezett a felhasználói fiók státusza, 
                vagy létező felhasználó munkamenet miatt."
            - A sikertelen kísérlet után a felhasználó a bejelentkezési oldalon marad, és lehetősége van az adatok javítására.


US02 - Cookie banner elfogadása
        Felhasználóként
             fontos nekem a magánszféra védelme, ezért új böngésző sessionben a tesztoldal megnyitásakor mindig figyelmeztető üzenetet szeretnék látni, hogy az oldal sütiket használ.

        Elfogadási feltételek (Acceptance Criteria)
            - Új böngésző sessionben megjelenik a cookie banner.
            - Ha a felhasználó elfogadja, akkor eltűnik a cookie banner.
        


US03 – Pénzügyi áttekintés megjelenítése grafikonokon ("Áttekintés" oldal)
        Felhasználóként
            szeretném, hogy az "Áttekintés" oldalon átlátható grafikonok mutassák meg a pénzmozgásaim lényegét,
            hogy egyetlen pillantással rálássak az aktuális pénzügyi állapotomra.

    Elfogadási feltételek (Acceptance Criteria)
        - A főoldalon megjelenik a számlaegyenleg összegző grafikon.
        - Külön grafikon mutatja a be- és kifizetések utolsó három hónapját.
        
        

US04 - Új megtakarítás létrehozása
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


US05 - Létrehozott megtakarítási számla adatainak megjelenítése
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


US06 – Kijelentkezés
    Felhasználóként
        arra számítok, hogy egyetlen kattintással lezárhatom a munkamenetemet,
        mert így a saját adataim mindig védett és tiszta térben maradnak.

    Elfogadási feltételek (Acceptance Criteria)
        - A jobb felső sarok menüjében megjelenik a kijelentkezési lehetőség.
        - Kijelentkezést követően a rendszer visszavisz a bejelentkezési felületre.
        - Zöld, pozitív visszacsatolás érkezik: „Sikeres kilépés.”
        - Új oldalbetöltéskor ismét belépést kér a rendszer.
