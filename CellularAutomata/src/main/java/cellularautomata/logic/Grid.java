package cellularautomata.logic;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Grid {

    private int width;
    private int height;
    private boolean[][] states;

    public Grid(int x, int y) {
        this.width = x;
        this.height = y;

        this.states = new boolean[x][y];
        //Arrays.fill(states, false);
        for (boolean[] row : states) {
            Arrays.fill(row, false);
        }
    }

    public Grid(boolean[][] states) {
        this.states = states;
        this.width = states.length;
        this.height = states[0].length;
    }

    public boolean getCoordinate(int x, int y) {
        if (inBounds(x, y)) {
            return states[x][y]; //return value
        }
        return false; // if out-of-bounds return false
    }

    public boolean inBounds(int x, int y) {
        if (x < width && y < height && x >= 0 && y >= 0) { // testing if index is in-bounds
            return true;
        }
        return false;
    }

    public int aliveNeighbors(int x, int y) {
        int[] neighborhood = this.getNeighborhood(x, y);
        int currentAlive = (getCoordinate(x, y)) ? 1 : 0;
        int aliveNeighbors = IntStream.of(neighborhood).sum() - currentAlive;
        return aliveNeighbors;
    }

    public int[] getNeighborhood(int x, int y) {
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

    public boolean[][] copyStates() {
        boolean[][] copy = new boolean[this.width][this.height];
        for (int i = 0; i < states.length; i++) {
            copy[i] = states[i].clone();
        }
        return copy;
    }

    public void setStates(boolean[][] states) {
        this.states = states;
        width = states.length;
        height = states[0].length;
    }

    public void setState(int x, int y, boolean state) {
        states[x][y] = state;
    }

    public void switchState(int x, int y) {
        boolean current = states[x][y];
        setState(x, y, !current);
    }
    
    
    
}
