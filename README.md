# CellularAutomata
This application is a cellular automata implementation with a graphical user interface. It currently supports the ruleset of **Conway's Game of Life**, but it will support other rulesets in the future.

## Releases
### Week 3
I have completed the application logic with Game of Life implementation. The application can calculate the next generation of the automata with the data of the current generation. The application has several JUnit tests: like counting alive neighbours and making sure class constructors work properly. It also supports maven testing with Jacoco and launching the application from the command line.

### Week 4
Now the application has a working GUI with working reset and iterate (">") button. File structure is also more logical.

## Command line commands
### Running the program
Run file from command line:
```
mvn compile exec:java -Dexec.mainClass=cellularautomata.gui.GUI

```
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

[Class diagram](https://github.com/PAHUS/ot-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)

