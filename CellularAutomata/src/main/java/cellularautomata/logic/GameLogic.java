/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cellularautomata.logic;

import cellularautomata.logic.rules.Rules;
import java.util.stream.*;

/**
 *
 * @author tyivaana
 */
public class GameLogic {
    private Grid grid;
    private Rules rules;

    public GameLogic(Grid grid, Rules rules) {
        this.grid = grid;
        this.rules = rules;
    }

    
    public void iterate(){
        boolean[][] nextGen = this.grid.copyStates();
        for(int i= 0; i<grid.getxSize();i++){
            for(int j=0; j<grid.getySize(); j++){ //iterate over the array and count next generation values
                boolean nextState = rules.nextState(i,j,grid); //calculate next state
                nextGen[i][j] = nextState; //SET NEXT STATE
            }
        }
        this.grid.setStates(nextGen); //Change the state of the Grid to next generation
    }
    
    
    
    

    public Rules getRules() {
        return rules;
    }

    public void setRules(Rules rules) {
        this.rules = rules;
    }

    public Grid getGrid() {
        return grid;
    }
           
}
