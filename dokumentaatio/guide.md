# Guide
Download the newest jar-file CellularAutomata.jar from [here](https://github.com/PAHUS/ot-harjoitustyo/releases)

## Configuration
If you want an example gamestate download also the file [example.csv](https://github.com/PAHUS/ot-harjoitustyo/releases/download/viikko6/example.csv)

## Launching the application
Launch the application with the command

`` java -jar CellularAutomata.jar ``

## How the game works?
Conway's Game of Life is a Cellular Automata where the boardstate changes according to two factors - previous state of the grid 
and the ruleset. 

## How to use the application
1. Set the starting state/pattern by 
  a) selecting the cells you want to be alive
  b) Click "Load" to load the exaple starting state, or your own saved state

2. Iterate the array, either by pressing ">" to iterate a single time or by pressing "Start" to start the animation which iterates the array
several times a second. You can stop the animation by pressing the same button, or switch the speed by pressing the corresponding button.
