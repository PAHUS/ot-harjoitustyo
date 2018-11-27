
package cellularautomata.logic.rules;

public interface Rules {
    boolean nextState(boolean state, int neighbors);
}
