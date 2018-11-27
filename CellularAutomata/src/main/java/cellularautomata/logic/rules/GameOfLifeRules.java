package cellularautomata.logic.rules;

import cellularautomata.logic.rules.Rules;

public class GameOfLifeRules implements Rules {
    @Override
    public boolean nextState(boolean alive, int aliveNeighbors) {
        if(alive){
            if(aliveNeighbors == 2 || aliveNeighbors == 3){ //if alive and 2 or 3 alive neighbors stay alive
                return true;
            }
            return false; //otherwise die
        }
        if(aliveNeighbors == 3) return true; // if dead and exactly 3 alive neighbors, reproduce (become alive) 
        return false; // otherwise stay dead
    }
    
}
