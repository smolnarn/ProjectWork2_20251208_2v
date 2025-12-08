Feature: Bejelentkezés és Kijelentkezés
  Mint felhasználó
  Szeretnék be- és kijelentkezni
  Hogy hozzáférjek a pénzügyeimhez és biztonságban tudjam őket

  Background:
    Given a bejelentkezési oldalon vagyok

  Rule: Üres vagy hibás mezők esetén a rendszer figyelmeztet (US01)
    
    Example: Sikertelen bejelentkezés hibás jelszóval
      When hibás felhasználónevet vagy jelszót adok meg
      And a "Belépés" gombra kattintok
      Then egy figyelmeztető üzenetet kell látnom: "Hiba Hibás belépési adatok vagy a hozzáférés nem engedélyezett a felhasználói fiók státusza, vagy létező felhasználó munkamenet miatt."
      And a bejelentkezési oldalon maradok

  Rule: Helyes adatok bevitele után a rendszer átirányít és üdvözöl (US02)

    Example: Sikeres bejelentkezés érvényes adatokkal
      When érvényes felhasználónevet és jelszót adok meg
      And a "Belépés" gombra kattintok
      Then átirányításra kerülök az "Áttekintés" oldalra
      And üdvözlő üzenetet kell látnom
      And a bal oldali menü elérhetővé válik

  Rule: Kijelentkezéskor a rendszer biztonságosan kiléptet (US07)

    Example: Kijelentkezés a menüből
      Given be vagyok jelentkezve
      When a kijelentkezés opciót választom
      Then visszakerülök a bejelentkezési oldalra
      And egy "Sikeres kilépés." üzenetet kell látnom
      And újbóli oldalbetöltéskor ismét bejelentkezést kér a rendszer
