
package cellularautomata;

import java.util.Arrays;

public class Grid {
    private int xSize;
    private int ySize;
    private boolean[][] states;
    
    
    public Grid(int x, int y) {
        this.xSize = x;
        this.ySize = y;
        
        this.states = new boolean[x][y];
        //Arrays.fill(states, false);
          for (boolean[] row : states){
              Arrays.fill(row, false);
          }
    }
    
    public Grid(boolean[][] states){
        this.states = states;
        this.xSize = states.length;
        this.ySize = states[0].length;
    }
    
    public boolean getCoordinate(int x, int y){
        if(inBounds(x,y)){
            return states[x][y]; //return value
        }
        return false; // if out-of-bounds return false
    }
    
    public boolean inBounds(int x, int y){
        if(x<xSize && y<ySize && x>=0 && y>=0){ // testing if index is in-bounds
            return true;
        }
        return false;
    }
    
    public int size() {
        return this.states.length * this.states[0].length;
    }

    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }
    

    public boolean[][] getStates() {
        return states;
    }
    
}
