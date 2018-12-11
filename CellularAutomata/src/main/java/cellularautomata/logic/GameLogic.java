
package cellularautomata.logic;

import cellularautomata.logic.rules.Rules;

/**
 * This class calculates the gamestates according to the ruleset and Grids
 * and is responsible for handling rulesets
 * @author tyivaana
 */
public class GameLogic {

    private Grid grid;
    private Rules rules;

    /**
     * Contructs a Game Logic calculator with specified Grid and Ruleset
     * @param grid the Grid that holds current state of the game
     * @param rules the current ruleset of the gmae
     */
    public GameLogic(Grid grid, Rules rules) {
        this.grid = grid;
        this.rules = rules;
    }

    /**
     * Iterates over the Grid and calculate the next State of the game according to the current Ruleset
     */
    public void iterate() {
        boolean[][] nextGen = this.grid.copyStates();
        for (int i = 0; i < grid.getWidth(); i++) {
            for (int j = 0; j < grid.getHeight(); j++) { //iterate over the array and count next generation values
                boolean nextState = rules.nextState(i, j, grid); //calculate next state
                nextGen[i][j] = nextState; //SET NEXT STATE
            }
        }
        this.grid.setStates(nextGen); //Change the state of the Grid to next generation
    }

    /**
     * Returns current ruleset
     * @return 
     */
    public Rules getRules() {
        return rules;
    }

    /**
     * Setter for the rules
     * @param rules 
     */
    public void setRules(Rules rules) {
        this.rules = rules;
    }

    /**
     * Getter for Grid
     * @return 
     */
    public Grid getGrid() {
        return grid;
    }

}
