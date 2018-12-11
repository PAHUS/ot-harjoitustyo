package cellularautomata.logic.rules;

import cellularautomata.logic.Grid;
/**
 * Ruleset that defines the rules of Conway's Game of Life (B3/S23)
 * @author Tande
 */
public class GameOfLifeRules implements Rules {

    /**
     * Calculates the next state of the specified coordinate:
     * 
     * 1) If alive and 2 or 3 alive neighbors stay alive. Otherwise die.
     * 
     * 2) If dead and exactly 3 alive neighbors, reproduce (become alive). Otherwise stay dead.
     * @param x x-coordinate
     * @param y y-coordinate
     * @param grid current state of the automata
     * @return returns the next state of the coordinate
     */
    @Override
    public boolean nextState(int x, int y, Grid grid) {
        boolean alive = grid.getCoordinate(x, y);
        int aliveNeighbors = grid.aliveNeighbors(x, y);
        if (alive) {
            if (aliveNeighbors == 2 || aliveNeighbors == 3) { //if alive and 2 or 3 alive neighbors stay alive
                return true;
            }
            return false; //otherwise die
        }
        if (aliveNeighbors == 3) {
            return true; // if dead and exactly 3 alive neighbors, reproduce (become alive) 
        }
        return false; // otherwise stay dead
    }

}
