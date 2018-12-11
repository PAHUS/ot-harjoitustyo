package cellularautomata.logic;

import java.util.Arrays;
import java.util.stream.IntStream;
/**
 * This class wraps a 2 dimensional boolean array and 
 * provides methods for gathering gata from the array, and for 
 * editing states.
 */
public class Grid {

    private int width;
    private int height;
    private boolean[][] states;

   /**
    * Constructs a Grid of the wanted size
    * @param x width of the Grid
    * @param y height of the Grid
    */
    public Grid(int x, int y) {
        this.width = x;
        this.height = y;

        this.states = new boolean[x][y];
        //Arrays.fill(states, false);
//        for (boolean[] row : states) {
//            Arrays.fill(row, false);
//        }
    }

    /**
     * Cpnstructs a Grid with the chosen states
     * @param states the boolean array that the Grid will wrap
     */
    public Grid(boolean[][] states) {
        this.states = states;
        this.width = states.length;
        this.height = states[0].length;
    }

    /**
     * If (x,y) in-bounds returns the value from the wrapped boolean array.
     * Else returns false.
     * @param x x value
     * @param y y value
     * @return returns true or false depending on the states of the Grid
     */
    public boolean getCoordinate(int x, int y) {
        if (inBounds(x, y)) {
            return states[x][y]; //return value
        }
        return false; // if out-of-bounds return false
    }

    /**
     * Finds if a pair of indexes are in the array
     * @param x the row of the index
     * @param y the column of the index
     * @return 
     */
    public boolean inBounds(int x, int y) {
        if (x < width && y < height && x >= 0 && y >= 0) { // testing if index is in-bounds
            return true;
        }
        return false;
    }

    /**
     * Counts the number of alive neighbours of the current cell 
     * @param x x-value of the current cell
     * @param y y-value of the current cell
     * @return 
     */
    public int aliveNeighbors(int x, int y) {
        int[] neighborhood = this.getNeighborhood(x, y);
        int currentAlive = (getCoordinate(x, y)) ? 1 : 0;
        int aliveNeighbors = IntStream.of(neighborhood).sum() - currentAlive;
        return aliveNeighbors;
    }

    private int[] getNeighborhood(int x, int y) {
        int[] neighborhood = new int[9];
        int index = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                neighborhood[index] = (getCoordinate(i, j)) ? 1 : 0; // ternary map from boolean to int
                index++;
            }
        }
        return neighborhood;
    }

    public int size() {
        return this.states.length * this.states[0].length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean[][] getStates() {
        return states;
    }

    /**
     * Creates a deep copy of the states of the Grid
     * @return returns states
     */
    public boolean[][] copyStates() {
        boolean[][] copy = new boolean[this.width][this.height];
        for (int i = 0; i < states.length; i++) {
            copy[i] = states[i].clone();
        }
        return copy;
    }

    /**
     * Sets the states of the Grid to the specified states
     * @param states 
     */
    public void setStates(boolean[][] states) {
        this.states = states;
        width = states.length;
        height = states[0].length;
    }

    public void setState(int x, int y, boolean state) {
        states[x][y] = state;
    }

    /**
     * Switches the state of the specified cell
     * @param x x-value 
     * @param y y-value
     */
    public void switchState(int x, int y) {
        boolean current = states[x][y];
        setState(x, y, !current);
    }
    
    
    
}
