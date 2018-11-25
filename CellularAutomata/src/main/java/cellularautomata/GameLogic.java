/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cellularautomata;

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
                boolean current = grid.getCoordinate(i, j); //get current state
                int neighbors = this.aliveNeighbors(i, j); //count neighbors
                boolean state = rules.nextState(current, neighbors); //calculate next state
                
                nextGen[i][j] = state; //SET NEXT STATE
            }
        }
        this.grid.setStates(nextGen); //Change the state of the Grid to next generation
    }
    
    public int aliveNeighbors(int x, int y){
        int[] neighborhood = this.getNeighborhood(x, y);
        int currentAlive = (grid.getCoordinate(x, y)) ? 1 : 0;
        int aliveNeighbors = IntStream.of(neighborhood).sum() - currentAlive;
        return aliveNeighbors;
    }
    
    public int[] getNeighborhood(int x, int y){
        int[] neighborhood = new int[9];
        int index = 0;
        for(int i = x-1; i<=x+1; i++){
            for(int j = y-1; j<=y+1; j++){
                neighborhood[index]= (grid.getCoordinate(i,j)) ? 1 : 0; // ternary map from boolean to int
                index++;
            }
        }
        return neighborhood;
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
