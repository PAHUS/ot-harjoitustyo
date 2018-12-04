# CellularAutomata
This application is a cellular automata implementation with a graphical user interface. It currently supports the ruleset of **Conway's Game of Life**, but it will support other rulesets in the future.

## Releases
### [Week 5](https://github.com/PAHUS/ot-harjoitustyo/releases/tag/viikko5)


## Command line commands
### Running the program
Run file from command line:
```
mvn compile exec:java -Dexec.mainClass=cellularautomata.gui.GUI

```
Create JAR file:
```
mvn package
```
which you can run with "java -jar CellularAutomata-1.0-SNAPSHOT.jar" at the _/target_ directory

### Testing
Test with maven:
```
mvn test
```
Test coverage:
```
mvn jacoco:report
```
Creates a test coverage report to _target/site/jacoco/index.html_ which can be opened in browser.

Test checkstyle:
```
mvn jxr:jxr checkstyle:checkstyle
```
Creates a checkstyle report to _target/site/checkstyle.html_ which can be opened in browser.

## Documentation
[Specification document](https://github.com/PAHUS/ot-harjoitustyo/blob/master/laskarit/viikko2/dokumentointi/alustavaMaarittely.md),

[Work time bookkeeping](https://github.com/PAHUS/ot-harjoitustyo/blob/master/laskarit/viikko2/dokumentointi/tyoaikakirjanpito.md),

[Class diagram](https://github.com/PAHUS/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md),

[Sequence diagram of iterate() method](https://github.com/PAHUS/ot-harjoitustyo/blob/master/dokumentaatio/sequenceDiag.md)

