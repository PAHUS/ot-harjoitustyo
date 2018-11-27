
package cellularautomata.logic.rules;

import cellularautomata.logic.Grid;

public interface Rules {
    boolean nextState(int x, int y, Grid grid);//boolean state, int neighbors
}
