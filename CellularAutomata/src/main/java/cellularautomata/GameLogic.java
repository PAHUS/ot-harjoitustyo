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
        
    }
    
    public int aliveNeighbors(int x, int y){
        //JOS HUONOT INDEKSIT???
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
    
    
            
}
