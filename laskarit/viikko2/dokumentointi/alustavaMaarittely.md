# Alustava Määrittelydokumentti
## Sovelluksen tarkoitus
Sovelluksena on Soluautomaatti (Cellular Automata). Tämä on ruudukkoona rakennettava
malli, jossa jokainen ruudukon solu on joko "elävä" tai "kuollut". Automaatille
määritellään alkutila, jonka jälkeen sovellus alkaa iteroida ruudukkoa ennaltamää-
rättyjen sääntöjen mukaisesti.
Suunnitelmana olisi alustavasti tarkoituksena toteuttaa Conway's Game Of Life, jonka
säännöt tomivat seuraavasti:
1. solu muuttuu eläväksi kun tasan kolme sen naapureista elää
2. solu pysyy elävänä jos 2 tai 3 sen naapureista elää
3. muutoin solu kuolee tai pysyy kuolleena

Sovelluspohjalla voi perjaatteessa toteuttaa myös muita soluautomaatteja, kuten Rule 110
tai Game Of Lifen muunnoksia 

## Suunnitellut toiminnallisuudet
- Graafinen käyttöliittymä, jossa käyttäjä voi määritellä alkutilan
- Animaatio automaatin iteraatioista
- Alkutilojen tallennus tietokantaan ja tallennettujen alkutilojen lataus

