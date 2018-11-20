/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cellularAutomata;

import java.util.Arrays;

/**
 *
 * @author Tande
 */
public class Grid {
    private Cell[][] states;
    
    
    public Grid(int x, int y) {
        this.states = new Cell[x][y];
        Arrays.fill(states, new Cell(false));
    }
    
}
