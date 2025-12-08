Feature: Megtakarítások kezelése
  Mint felhasználó
  Szeretném kezelni a megtakarításaimat
  Hogy növelhessem a vagyonomat

  Background:
    Given be vagyok jelentkezve

  Rule: A "Megtakarítás" menü és almenük navigációja (US04)

    Example: Almenük megjelenítése és elrejtése
      When a "Megtakarítás" menüre kattintok
      Then meg kell jelennie a "Megtakarítások megtekintése" és "Új megtakarítás" almenüknek
      And ha újra a "Megtakarítás" menüre kattintok, az almenüknek el kell tűnniük

    Example: Navigáció a Megtakarítások megtekintése oldalra
      When a "Megtakarítások megtekintése" almenüre kattintok
      Then a "Megtakarítási számlák megtekintése" oldalra jutok

    Example: Navigáció az Új megtakarítás oldalra
      When az "Új megtakarítás" almenüre kattintok
      Then a "Megtakarítási számla létrehozása" oldalra jutok

  Rule: Új megtakarítás létrehozása űrlap működése (US05)

    Example: Űrlap alaphelyzetbe állítása
      Given az "Új megtakarítási számla létrehozása" oldalon vagyok
      And kitöltöm az űrlapot adatokkal
      When az "Alaphelyzetbe állítás" gombra kattintok
      Then az összes mezőnek törlődnie kell

    Example: Sikeres számlanyitás érvényes adatokkal
      Given az "Új megtakarítási számla létrehozása" oldalon vagyok
      When kiválasztom a "Megtakarítások" számlatípust
      And kiválasztom az "Egyéni" tulajdonjogot
      And megadok egy számlanevet
      And megadok egy érvényes kezdeti befizetési összeget
      And az "Elküldés" gombra kattintok
      Then egy sikerüzenetet kell látnom
      And átirányításra kerülök a "Megtakarítási számlák megtekintése" oldalra

  Rule: Létrehozott számla adatainak és tranzakcióinak megjelenítése (US06)

    Scenario Outline: Új számla adatainak ellenőrzése a listában
      Given sikeresen létrehoztam egy új megtakarítási számlát
      When a "Megtakarítási számlák megtekintése" oldalon vagyok
      Then egy zöld színű kártyán látnom kell az alábbi adatokat:
        | Mező        | Érték           |
        | Számla      | <Számla>        |
        | Tulajdonjog | <Tulajdonjog>   |
        | Számlaszám  | <Számlaszám>    |
        | Kamatláb    | <Kamatláb>      |
        | Egyenleg    | <Egyenleg>      |

      Examples:
        | Számla         | Tulajdonjog | Számlaszám | Kamatláb | Egyenleg |
        | Megtakarítások | Egyéni      | 486130016  | 1.85%    | $25.00   |

    Example: Kezdő befizetés megjelenése a tranzakciók között
      Given sikeresen létrehoztam egy új megtakarítási számlát
      When a "Megtakarítási számlák megtekintése" oldalon vagyok
      Then a kezdő befizetést látnom kell a tranzakciók között a megfelelő összeggel
