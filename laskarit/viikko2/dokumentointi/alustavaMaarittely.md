# Alustava Määrittelydokumentti
## Sovelluksen tarkoitus
Sovelluksena on Soluautomaatti (Cellular Automata). Tämä on ruudukkoona rakennettava
malli, jossa jokainen ruudukon solu on joko "elävä" tai "kuollut". Automaatille
määritellään alkutila (eli jokaiselle solulle määritellään tila), jonka jälkeen sovellus alkaa iteroida ruudukkoa ennaltamää-
rättyjen sääntöjen mukaisesti. Automaatilla on siis tämänhetkinen tila, joka määrää yksiselitteisesti seuraavan tilan.
Suunnitelmana olisi alustavasti tarkoituksena toteuttaa toimimaan Conway's Game Of Life -säännöstön mukaan, joka määrittelee seuraavan iteraation seuraavien sääntöjen mukaan:
1. solu muuttuu eläväksi kun tasan kolme sen naapureista elää
2. solu pysyy elävänä jos 2 tai 3 sen naapureista elää
3. muutoin solu kuolee tai pysyy kuolleena

Sovelluspohjalla voisi toteuttaa myös muita soluautomaatteja (eli eri säännöstöjä), kuten Rule 110
tai Game Of Lifen muunnoksia, mutta nämä eivät ole tämänhetkisessä versiossa.

## Lisätyt toiminnallisuudet
- Graafinen käyttöliittymä, jossa käyttäjä voi määritellä alkutilan, tai muuntaa sen hetkistä tilaa
- Erilaisia asetuksia käyttöliittymälle, kuten ruudukon koko, animaation nopeus ja ruudukon resettaus
- Animaatio automaatin iteraatioista
- Alkutilojen tallennus tietokantaan ja tallennettun alkutilann lataus

