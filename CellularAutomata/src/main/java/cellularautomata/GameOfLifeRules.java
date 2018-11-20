/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cellularautomata;

/**
 *
 * @author tyivaana
 */
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
