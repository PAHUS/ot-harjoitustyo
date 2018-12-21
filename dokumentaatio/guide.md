# Guide
Download the newest jar-file CellularAutomata.jar from [here](https://github.com/PAHUS/ot-harjoitustyo/releases)

## Configuration
If you want an example gamestate download also the file [example.csv](https://github.com/PAHUS/ot-harjoitustyo/releases/download/viikko6/example.csv)

## Launching the application
Launch the application with the command

`` java -jar CellularAutomata.jar ``

## How the game works?
Conway's Game of Life is a Cellular Automata where the boardstate changes according to two factors - previous state of the grid 
and the ruleset. So you set the initial state of the array and after that the game iterates to the next state according to these rules: 
  1. If the cell is alive (selected) and it has 2 or 3 alive neighbors it will stay alive
  2. If the cell is dead, but has exactly 3 alive neighbors it will become alive
  3. Otherwise the cell stays/will become dead

## How to use the application
1. Set the starting state/pattern by 

- selecting the cells you want to be alive

- Click "Load" to load the exaple starting state, or your own saved state

2. Iterate the array, either by pressing ">" to iterate a single time or by pressing "Start" to start the animation which iterates the array
several times a second. You can stop the animation by pressing the same button, or switch the speed by pressing the corresponding button.
