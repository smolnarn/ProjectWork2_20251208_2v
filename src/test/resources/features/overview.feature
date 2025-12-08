Feature: Pénzügyi áttekintés
  Mint felhasználó
  Szeretném látni a pénzügyi grafikonjaimat
  Hogy átlássam a helyzetemet

  Rule: Grafikonok megjelenítése a főoldalon (US03)
    
    Example: Áttekintés oldal grafikonjainak ellenőrzése
      Given be vagyok jelentkezve
      And az "Áttekintés" oldalon vagyok
      Then látnom kell a számlaegyenleg összegző grafikont
      And látnom kell a be- és kifizetések utolsó három hónapját mutató grafikont
      And a kategória szerinti bontásoknak vizuálisan el kell különülniük
