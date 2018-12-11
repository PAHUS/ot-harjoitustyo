# Arkkitehtuurikuvaus

## Rakenne
Ohjelma koostuu graafisesta käyttöliittymästä (_cellularautomata.gui_), sovelluslogiikasta(_cellularautomata.logic_ ja _cellularautomata.logic.rules_) ja dao-logiikasta (_cellularautomata.dao_), joka käsittelee tiedon tallettamista ja lukemista tiedostoista. Seuraavana on luokkakaavio sovelluslogiikkaluokista:
<img src="https://raw.githubusercontent.com/PAHUS/ot-harjoitustyo/master/laskarit/viikko2/dokumentointi/umldiag.png" width="400">

## Käyttöliittymä

Käyttöliittymä sisältää yhden näkymän, jossa on [BorderPane](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/BorderPane.html) olioon sijoitettu ylä- ja alapaneeleihin nappuloita, joilla käsitellään paneelin keskelle sijoitettuun [GridPaneen](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/GridPane.html) [nappuloilla](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Button.html) toteutetun ruudukkoon asetuksia (koko, väri) ja toiminnallisuuksia (iterointi, animointi).

Käyttöliittymä on toteutettu luokkaan [cellularautomata.gui.GUI](https://github.com/PAHUS/ot-harjoitustyo/blob/master/CellularAutomata/src/main/java/cellularautomata/gui/GUI.java). Käyttöliittymä viestii sovelluslogiikan kanssa kutsumalla muita luokkia ja niiden metodeja (esim napeilla ja animation timerilla).






